package com.gihanz.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data()
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String id;
    private String name;
    private String mobile;
    private String email;
}
