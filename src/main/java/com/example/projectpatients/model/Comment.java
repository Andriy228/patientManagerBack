package com.example.projectpatients.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String date;
    private String commBody;
    private Long p_fk;

    public Long getId() {
        return id;
    }

    public void setId(Long commentId) {
        this.id = commentId;
    }

    public Long getP_fk() {
        return p_fk;
    }

    public void setP_fk(Long p_fk) {
        this.p_fk = p_fk;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCommBody() {
        return commBody;
    }

    public void setCommBody(String commBody) {
        this.commBody = commBody;
    }
}
