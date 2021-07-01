package com.example.projectpatients.service;


import com.example.projectpatients.exception.UserNotFoundException;
import com.example.projectpatients.model.Comment;
import com.example.projectpatients.model.Patient;
import com.example.projectpatients.repo.CommRepo;
import com.example.projectpatients.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PatientService {
    private final PatientRepo patientRepo;
    private  final CommRepo commRepo;

    @Autowired
    public PatientService(PatientRepo patientRepo, CommRepo commRepo) {
        this.patientRepo = patientRepo;
        this.commRepo = commRepo;
    }

    public Patient addPatient(Patient patient){
        return patientRepo.save(patient);
    }

    public List<Patient> findAllPatient(){
        return patientRepo.findAll();
    }

    public Patient updatePatient(Patient patient){
        return  patientRepo.save(patient);
    }

    public Patient findPatientById(Long id){
        return patientRepo.findPatientById(id).orElseThrow(() -> new UserNotFoundException("Patient by id " + id + " was not found"));
    }

    public void deletePatient(Long id){
        patientRepo.deletePatientById(id);
    }
}
