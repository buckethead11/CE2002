package Staff;

import java.util.ArrayList;

public class Staff_Control {
    private static ArrayList<Staff> StaffList = new ArrayList<Staff>();

    public static void init() {
        addStaff("MINHWAN", Gender.NONBINARY, JobTitle.MANAGER);
        addStaff("BIANCA", Gender.FEMALE, JobTitle.STAFF);
        addStaff("BUDI", Gender.FEMALE, JobTitle.STAFF);
        addStaff("TIMOTHY", Gender.MALE, JobTitle.STAFF);
        addStaff("LARRY", Gender.MALE, JobTitle.STAFF);
        addStaff("SHERWIN", Gender.MALE, JobTitle.STAFF);
        addStaff("ARJUN", Gender.MALE, JobTitle.STAFF);
        System.out.println("Staff loaded");
    }

    public static void addStaff(String name, Gender gender, JobTitle jobTitle) {
        Staff newStaff = new Staff(name, StaffList.size(), gender, jobTitle);
        StaffList.add(newStaff);
    }

    public static ArrayList<Staff> getStaffList() {
        return StaffList;
    }
}
