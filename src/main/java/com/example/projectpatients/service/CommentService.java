package com.example.projectpatients.service;

import com.example.projectpatients.exception.CommentNotFoundException;
import com.example.projectpatients.exception.UserNotFoundException;
import com.example.projectpatients.model.Comment;
import com.example.projectpatients.model.Patient;
import com.example.projectpatients.repo.CommRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentService {
    private  final CommRepo commRepo;

    public CommentService(CommRepo commRepo) {
        this.commRepo = commRepo;
    }

    public List<Comment> findAllComment(){
        return commRepo.findAll();
    }

    public Comment addComment(Long id,Comment comment){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        comment.setDate(formatter.format(date));
        comment.setP_fk(id);
        return commRepo.save(comment);
    }
}
