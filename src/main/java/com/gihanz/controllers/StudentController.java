package com.gihanz.controllers;

import com.gihanz.db.StudentDB;
import com.gihanz.dtos.StudentDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "students")
public class StudentController {

    @PostMapping(value = "")
    public StudentDTO save(@RequestBody StudentDTO dto){
       return StudentDB.add(dto);
    }
    @PutMapping(value = "")
    public StudentDTO update(@RequestBody StudentDTO dto){
        return StudentDB.update(dto);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")String id){
        return StudentDB.delete(id);
    }
    @GetMapping("/{id}")
    public StudentDTO findById(@PathVariable("id")String id){
        return StudentDB.findById(id);
    }
    @GetMapping("")
    public List<StudentDTO> getAll(){
        return StudentDB.getAll();
    }
}
