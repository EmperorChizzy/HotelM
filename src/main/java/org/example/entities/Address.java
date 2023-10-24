package org.example.entities;

import lombok.Data;
import org.example.enums.State;

@Data
public class Address {
    private String city;
    private String street;
    private State state;

}