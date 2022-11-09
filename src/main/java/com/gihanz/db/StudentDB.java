package com.gihanz.db;

import com.gihanz.dtos.StudentDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentDB {
    private static List<StudentDTO> db = new ArrayList<>();

    public static StudentDTO add(StudentDTO dto) {
        dto.setId(UUID.randomUUID().node());
        db.add(dto);
        return dto;
    }

    public static StudentDTO update(StudentDTO dto) {
        StudentDTO studentDTO = db.stream().filter(dto1 -> dto1.getId().equals(dto.getId())).findAny().orElse(null);
        if (studentDTO != null) {
            db.remove(studentDTO);
            db.add(dto);
            return dto;
        }
        return null;
    }

    public static String delete(String id) {
        StudentDTO studentDTO = db.stream().filter(dto1 -> dto1.getId().equals(id)).findAny().orElse(null);
        if (studentDTO != null) {
            db.remove(studentDTO);
            return id;
        }
        return null;
    }

    public static StudentDTO findById(String id) {
        return db.stream().filter(dto1 -> dto1.getId().equals(id)).findAny().orElse(null);
    }

    public static List<StudentDTO> getAll() {
        return db;
    }

}
