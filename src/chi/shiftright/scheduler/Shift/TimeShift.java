package chi.shiftright.scheduler.Shift;

import chi.shiftright.scheduler.calc.IDGenerator;
import chi.shiftright.scheduler.constant.ShiftCode;
import chi.shiftright.scheduler.staff.EmployeeFactory;
import chi.shiftright.scheduler.staff.EmployeeTeam;
import chi.shiftright.scheduler.staff.Employees;

import java.util.ArrayList;


public class TimeShift{
    private EmployeeTeam shiftTeam;
    private ArrayList<Employees> shiftStaffList;
    private ShiftCode shiftCode;
    private String shiftID;

    private boolean assignedTeam = false;


    public TimeShift(EmployeeTeam selectedStaffGroup){
        shiftStaffList = new ArrayList<>();
        this.shiftTeam = selectedStaffGroup;
        shiftCode = ShiftCode.TIMESHIFT;
        shiftID = new IDGenerator(shiftCode.value()).generateID();
    }

    public void printStaffList(){
        if (assignedTeam){
            EmployeeFactory.printStaffList(shiftTeam.getStaffList());
        } else {
            System.err.println("Error: group not assigned to this timeshift " + shiftID);
        }

    }


    public String getShiftID(){
        return this.shiftID;
    }

    public void assignTeam(EmployeeTeam group){
        if (!group.getStaffList().isEmpty()){
            this.shiftTeam = group;
            assignedTeam = true;
        }

    }









}
