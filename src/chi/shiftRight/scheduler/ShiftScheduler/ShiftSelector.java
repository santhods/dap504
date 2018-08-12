package chi.shiftRight.scheduler.ShiftScheduler;

import chi.shiftRight.scheduler.Shift.DayShift;
import chi.shiftRight.scheduler.Shift.TimeShift;
import chi.shiftRight.scheduler.ShiftFactory.TimeShiftFactory;
import chi.shiftRight.scheduler.staff.EmployeeFactory;
import chi.shiftRight.scheduler.staff.EmployeeTeam;
import chi.shiftRight.scheduler.staff.EmployeeTeamFactory;
import chi.shiftRight.scheduler.staff.Employees;

import java.util.ArrayList;
import java.util.Collections;

public class ShiftSelector {

    /*
    private ArrayList<Employees> staffList;

    public ShiftSelector(ArrayList<Employees> staffList){
        this.staffList = new ArrayList<Employees>();
        this.staffList = staffList;
    }

    public Employees getStaffShift(){
        // return;
    }
    */

    public static void main(String args[]){

        /*
        Create 1 team factory
        Create one TimeShift for odd days and another for even days (TimeShiftFactory objects)
        Extract ArrayList of timeshifts by calling the method getAssignedShiftList();

  */
        EmployeeTeamFactory dayShiftTeam = new EmployeeTeamFactory();

        TimeShiftFactory oddDayShifts = new TimeShiftFactory(dayShiftTeam);


        DayShift Monday = new DayShift(oddDayShifts.getAssignedShiftList());

        ArrayList<TimeShift> oddDayShiftList = oddDayShifts.getAssignedShiftList();
        // Collections.shuffle(oddDayShiftList);

        DayShift Tuesday = new DayShift(oddDayShiftList);

        System.out.println("Monday List: ");
        Monday.getShiftList().forEach(shift -> System.out.println(shift.getShiftID()));

        System.out.println("Tuesday List:");
        Tuesday.getShiftList().forEach(shift -> System.out.println(shift.getShiftID()));

        /*

        int num = 14;


        for (int c = 0; c < num; c++){
            System.out.print("Day: " + c + " is an ");
            if (c % 4 == 0){
                System.out.print("odd");
            } else System.out.println("even");
            System.out.println(" day.");
        }




*/


        // oddDayShiftList.forEach(shift -> shift.printStaffList());


        /*
        TimeShiftFactory evenDayShifts = new TimeShiftFactory(dayShiftTeam);

        ArrayList<TimeShift> evenDayShiftList = evenDayShifts.getAssignedShiftList();


        System.out.println("Size of shift in odd day shiftlist: " + oddDayShiftList.size());

        System.out.println("Size of shift in even day shiftlist: " + evenDayShiftList.size());

        System.out.println("ODD DAYS --");
        oddDayShiftList.forEach(shift -> System.out.println("Shift: " + shift.getShiftID()));

        for (TimeShift timeShift : oddDayShiftList) {
            System.out.println("Staff on odd-day shift: " + timeShift.getShiftID());
            //EmployeeFactory.printStaffList(timeShift.getShiftStaffList());

            timeShift.printStaffList();
        }


        System.out.println("EVEN DAYS --");
        evenDayShiftList.forEach(shift -> System.out.println("Shift: " + shift.getShiftID()));

        for (TimeShift timeShift : evenDayShiftList) {
            System.out.println("Staff on even-day shift: " + timeShift.getShiftID());
            //EmployeeFactory.printStaffList(timeShift.getShiftStaffList());

            timeShift.printStaffList();
        }
        /*



        for (TimeShift shift: oddDayShifts.getAssignedShiftList()){
            System.out.println("ShiftID: " + shift.getShiftID());


            // EmployeeFactory.printStaffList(shift.getShiftStaffList()); // .forEach(staff -> System.out.println(staff.getEmployeeID() + ": " + staff.getName() + ", " + staff.getPosition()));

        }

        */

        // oddDayShifts.getAssignedShiftList().forEach(shift -> shift.getShiftStaffList().forEach(staff -> System.out.println(staff.getEmployeeID() + ": " + staff.getName() + ", " + staff.getPosition())));

    }

}
