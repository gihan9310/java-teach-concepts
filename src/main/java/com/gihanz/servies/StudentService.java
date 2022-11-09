package com.gihanz.servies;

import com.gihanz.dtos.StudentDTO;
import com.gihanz.entities.Student;
import com.gihanz.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentService {

    private StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Async
    @Transactional
    public CompletableFuture<List<StudentDTO>> saveAll(MultipartFile studentFile) throws Exception {

            List<Student> students = parseCSVFile(studentFile).get();
            long start = System.currentTimeMillis();
            log.info("Saving student list List Size {} : "+students.size());
            List<StudentDTO> all = new ArrayList<>(); //this.studentRepository.saveAll(students);
            students.forEach(student -> {
                Student save = this.studentRepository.save(student);
                all.add(save.getDto());
            });
            long end = System.currentTimeMillis();
            log.info("Total Time {} : "+(end-start));
            return CompletableFuture.completedFuture(all);

    }

    @Async
    public CompletableFuture<List<Student>> parseCSVFile(final MultipartFile multipartFile) throws Exception {

            List<Student> list = new ArrayList<>();
            final BufferedReader br = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                log.info("cccc...............");
                final String[] data = line.split(",");
                final Student user = new Student();
                user.setRegNo(data[0]);
                user.setName(data[1]);
                user.setMobile(data[2]);
                user.setEmail(data[3]);
                list.add(user);
            }
            return CompletableFuture.completedFuture(list);
    }
}
