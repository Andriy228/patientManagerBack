package com.example.projectpatients;

import com.example.projectpatients.model.Comment;
import com.example.projectpatients.model.Patient;
import com.example.projectpatients.service.CommentService;
import com.example.projectpatients.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientResource {
    private final PatientService patientService;
    private final CommentService commentService;

    public PatientResource(PatientService patientService, CommentService commentService) {
        this.patientService = patientService;
        this.commentService = commentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatient(){
        List<Patient> patients = patientService.findAllPatient();
        return  new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/comment/all")
    public ResponseEntity<List<Comment>> getAllComment(){
        List<Comment> comments = commentService.findAllComment();
        return  new ResponseEntity<>(comments,HttpStatus.OK);
    }

    @GetMapping("/comment/all/{id}")
    public ResponseEntity<List<Comment>> getCommentByPatientId(@PathVariable Long id)
    {
        Patient newPatient = patientService.findPatientById(id);
        List<Comment> comments = newPatient.getComments();
        return  new ResponseEntity<>(comments,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Long id){
        Patient patient = patientService.findPatientById(id);
        return  new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        Patient newPatient = patientService.addPatient(patient);
        newPatient.getDateOfBirth().substring(0,10);
        return new ResponseEntity<>(newPatient,HttpStatus.CREATED);
    }

    @PostMapping("comment/add/{id}")
    public ResponseEntity<Comment> addComment(@PathVariable Long id,@RequestBody Comment comm){
        Comment newComment = commentService.addComment(id,comm);
        return new ResponseEntity<>(newComment,HttpStatus.OK);
    }


    @PutMapping("/update/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long patientId, @RequestBody Patient patient){
        patient.setId(patientId);
        patientService.updatePatient(patient);
        return new ResponseEntity<>(patient,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable("id") Long id){
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
