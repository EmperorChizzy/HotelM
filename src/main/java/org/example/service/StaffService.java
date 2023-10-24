package org.example.service;

import org.example.entities.Guest;
import org.example.entities.Staff;

import java.util.List;

public interface StaffService {
    Guest checkIn(Guest guest, Staff staff);
    List<Guest> viewAllGuest();
    Guest checkOut(Guest guest);

    Staff addStaff(Staff staff);
    int allocateRoomNumber() throws Exception;
}