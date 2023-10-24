package org.example;

import org.example.DTOs.StaffDTOS;
import org.example.entities.Guest;
import org.example.entities.Staff;
import org.example.enums.Role;
import org.example.enums.RoomType;
import org.example.enums.RoomTypePayment;
import org.example.serviceImpl.StaffServiceImpl;

import java.math.BigDecimal;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public void setUp() throws Exception {
        StaffDTOS staffDTOS = new StaffDTOS();
        staffDTOS.setName("Gadibia Dizsartz");
        staffDTOS.setEmail("Diz@gmail.com");
        staffDTOS.setRole("ACCOUNTANT");
        staffDTOS.setSalary(Staff.SALARY_3);
        Staff staff3 = new Staff(staffDTOS);

        Staff staff = Staff.builder()
                .role(Role.SUPERVISOR)
                .staffSalary(Staff.SALARY_2).build();
        Staff staff1 = new Staff();
        staff1.setRole(Role.ACCOUNTANT);
        StaffServiceImpl staffService = new StaffServiceImpl();
        staffService.addStaff(staff1);
        staffService.addStaff(staff);
        staffService.addStaff(staff3);
        System.out.println(StaffServiceImpl.allStaffs);
        Guest guest = Guest.builder()
                .payment(RoomTypePayment.L_20000)
                .roomType(RoomType.LOCAL)
                .roomNumber(12)
                .build();
        guest.setName("Gadibia Daro");
        guest.setEmail("daro@gmail.com");
        Guest guest2 = Guest.builder()
                .payment(RoomTypePayment.L_20000)
                .roomType(RoomType.LOCAL)
                .roomNumber(staffService.allocateRoomNumber())
                .build();
        guest2.setName("Gadibia Tare");
        guest2.setEmail("Gtare@gmail.com");
        Guest guest1 = Guest.builder()
                .payment(RoomTypePayment.L_20000)
                .roomType(RoomType.LOCAL)
                .roomNumber(14)
                .build();

        staffService.checkIn(guest, staff);
        staffService.checkIn(guest1, staff);
        staffService.checkIn(guest2, staff);
        System.out.println(staffService.viewAllGuest());
        System.out.println(staffService.checkOut(1));
        System.out.println(staffService.viewAllGuest());
        System.out.println(guest.getPayments());
    }
}