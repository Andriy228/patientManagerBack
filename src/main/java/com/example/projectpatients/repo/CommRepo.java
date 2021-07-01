package com.example.projectpatients.repo;

import com.example.projectpatients.model.Comment;
import com.example.projectpatients.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommRepo extends JpaRepository<Comment,Long> {

    void deleteCommentById(Long id);

    Optional<List<Comment>> findCommentById(Long id);
}
