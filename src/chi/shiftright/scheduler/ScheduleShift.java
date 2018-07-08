package chi.shiftright.scheduler;

import chi.shiftright.scheduler.Shift.TimeShift;
import chi.shiftright.scheduler.staff.EmployeeFactory;
import chi.shiftright.scheduler.staff.EmployeeTeam;
import chi.shiftright.scheduler.staff.Employees;

import java.util.ArrayList;

public class ScheduleShift extends EmployeeFactory{

    public static void main(String args[]){
        EmployeeFactory GenerateEmployees = new EmployeeFactory();


        System.out.println(GenerateEmployees.getEmployeeSize());

        /*

        ArrayList<Employees> staffList = GenerateEmployees.getEmployeeList();

        ArrayList<Employees> femaleStaff = GenerateEmployees.getFemaleList();
        ArrayList<Employees> maleStaff = GenerateEmployees.getMaleList();

        */


        // Creating 6 groups with the total of 24 staff overall.
        // Then create three timeshift


        EmployeeTeam team1 = new EmployeeTeam("Team alpha", GenerateEmployees);

        ArrayList<Employees> team1List = team1.getStaffList();


        EmployeeTeam team2 = new EmployeeTeam("Team alpha", GenerateEmployees);

        ArrayList<Employees> team2List = team1.getStaffList();


        System.out.println("Team 1");
        GenerateEmployees.printStaffList(team1List);

        System.out.println("Team 2");
        GenerateEmployees.printStaffList(team2List);


        /*

        EmployeeTeam group1 = new EmployeeTeam("Group 1", maleStaff, femaleStaff);

        EmployeeTeam group2 = new EmployeeTeam("Group 2", maleStaff, femaleStaff);

        EmployeeTeam group3 = new EmployeeTeam("Group 3", maleStaff, femaleStaff);

        EmployeeTeam group4 = new EmployeeTeam("Group 4", maleStaff, femaleStaff);


        ArrayList<Employees> group1staff = group1.getStaffList();
        ArrayList<Employees> group2staff = group2.getStaffList();
        ArrayList<Employees> group3staff = group3.getStaffList();
        ArrayList<Employees> group4staff = group4.getStaffList();

        System.out.println("Group 1");
        group1staff.forEach(staff -> System.out.println(staff.getEmployeeID() + ": " + staff.getName() + ", " + staff.getGender()));

        System.out.println("Group 2");
        group2staff.forEach(staff -> System.out.println(staff.getEmployeeID() + ": " + staff.getName() + ", " + staff.getGender()));

        System.out.println("Group 3");
        group3staff.forEach(staff -> System.out.println(staff.getEmployeeID() + ": " + staff.getName() + ", " + staff.getGender()));

        System.out.println("Group 4");
        EmployeeFactory.printStaffList(group4staff);
        */



        /*




        TimeShift morningShift = new TimeShift(group4);

        System.out.println("Group ID: " + morningShift.getShiftID());
        morningShift.printStaff();


        TimeShift afternoonShift = new TimeShift(group1);

         */
        // TimeShift MorningShift = new TimeShift(staffList);


        // System.out.println("Shift ID: " + MorningShift.getShiftID());


        // EmployeeTeam group1 = new EmployeeTeam("Group 1");

        //MorningShift.assignGroup(group1);

        //MorningShift.validate();


        // TimeShift AfternoonShift = new TimeShift();
        // TimeShift EveningShift = new TimeShift();


    }


}
