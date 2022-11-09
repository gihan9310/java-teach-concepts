package com.gihanz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.dtos.StudentDTO;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Data()
@ToString
@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String regNo;
    private String name;
    private String mobile;
    private String email;

    @JsonIgnore
    public StudentDTO getDto(){
        StudentDTO student = new StudentDTO();
        BeanUtils.copyProperties(this,student);
        return student;
    }
}
