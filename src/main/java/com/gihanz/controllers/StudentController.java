package com.gihanz.controllers;

import com.gihanz.db.StudentDB;
import com.gihanz.dtos.StudentDTO;
import com.gihanz.servies.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

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
    @PatchMapping(value = "")
    public StudentDTO patch(@RequestBody StudentDTO dto){
        return StudentDB.update(dto);
    }

    @PostMapping(value = "sava-all")
    public ResponseEntity<?> saveAllStudents(@RequestParam(value = "files")MultipartFile  file) throws Exception {
        CompletableFuture<List<StudentDTO>> listCompletableFuture = studentService.saveAll(file);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
