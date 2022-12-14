package com.gihanz.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data()
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String regNo;
    private String name;
    private String mobile;
    private String email;

    @JsonIgnore
    public Student getEntities(){
        Student student = new Student();
        BeanUtils.copyProperties(this,student);
        return student;
    }
}
