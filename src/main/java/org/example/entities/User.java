package org.example.entities;

import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class User {
    private String name;
    private int age;
    private Long phoneNumber;
    private LocalDate dob;
    private Address address;
    private String email;
}