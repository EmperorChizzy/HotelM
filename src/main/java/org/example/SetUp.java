package org.example;

import org.example.DTOs.StaffDTOS;
import org.example.entities.Guest;
import org.example.entities.Staff;
import org.example.enums.Role;
import org.example.enums.RoomType;
import org.example.enums.RoomTypePayment;
import org.example.serviceImpl.StaffServiceImpl;

public class SetUp {
    public static void main(String[] args) throws Exception {
        Main setUp = new Main();

        //Sets up all we need to run our application
        setUp.setUp();
    }

}