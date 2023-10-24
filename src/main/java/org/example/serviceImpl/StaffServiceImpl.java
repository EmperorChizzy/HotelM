package org.example.serviceImpl;

import org.example.Main;
import org.example.entities.Guest;
import org.example.entities.Staff;
import org.example.enums.Role;
import org.example.service.StaffService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StaffServiceImpl implements StaffService {
    public static List<Guest> allCheckedInGuests = new ArrayList<>();//list of guests
    public static List<Integer> occupiedRooms = new ArrayList<>();
    public static HashMap<Role, List<Staff>> allStaffs =  new HashMap<>();//hash map of staff list and their role
    @Override
    public Guest checkIn(Guest guest, Staff staff) {
        //condition to check role privilege of staff before adding a guest to the list in line 13
        if (staff.getRole().equals(Role.SECRETARY)
                ||staff.getRole().equals(Role.MANAGER)
                ||staff.getRole().equals(Role.RECEPTIONIST)
                ||staff.getRole().equals(Role.SUPERVISOR)){
            occupiedRooms.add(guest.getRoomNumber());
            //adds a guest to the list in line 13
            allCheckedInGuests.add(guest);
            return guest;
        }
        return null;
    }

    @Override
    public List<Guest> viewAllGuest() {
        //returns List<Guest> or list of guest in line 13
        return allCheckedInGuests;
    }

    @Override
    public Guest checkOut(Guest guest) {
        //returns the index location of an object in an array list
        int i = allCheckedInGuests.indexOf(guest);
        //removes an object from an array list and returns the removed object from the array list
        return allCheckedInGuests.remove(i);
    }

    @Override
    public Staff addStaff(Staff staff) {
        //condition to check if the staff has a Role set in it
        if (staff.getRole()==null){
            //Exception is throw when you try to add a staff that does not have role set
            throw new NullPointerException("ALERT GHOST WORKER!!! Role cannot be null");
        }
        //condition to check the HashMap for staff already has a key(Role) and value(List<Staff>) stored in it.
        if (allStaffs.get(staff.getRole())==null){
            //if there is no staff role or list of staff stored in the hashMap create a list of staff
            List<Staff> staffList = new ArrayList<>();
            //add our staff to the list
            staffList.add(staff);
            //put the list of staff and the Role (as the key) in the HashMap
            allStaffs.put(staff.getRole(), staffList);
        }
        //else if there already is a key(for the role) and a value( for the list of staff)
        else{
            //simply get the role by key (which returns the list of staff) and add the staff to the list
            allStaffs.get(staff.getRole()).add(staff);
        }
        //return the object of the added staff
        return staff;
    }

    @Override
    public int allocateRoomNumber() throws Exception {
        //Randomly generated room number is stored here
        int roomNumber = 0;
        //condition to check if there is vacancy in the hotel
        if (occupiedRooms.size()==30){
            //Exception throw when there is no vacancy
            throw new Exception(" NO VACANCY! ALL ROOMS ARE OCCUPIED");
        }
        //loop to run while the randomly generated roomnumber is already occupied
        while (occupiedRooms.contains(roomNumber)||roomNumber==0) {
            roomNumber = (int) (Math.random() * 31);
        };
        //return sucessfully randomly generated room number
        return roomNumber;
    }

    public Guest checkOut(int guestIndex) {
        //removes an object from an array list using the index location of the object
        return allCheckedInGuests.remove(guestIndex);
    }
}