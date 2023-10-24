package org.example.DTOs;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StaffDTOS {
    private String name;
    private String email;
    private String role;
    private BigDecimal salary;
}