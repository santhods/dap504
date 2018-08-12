package chi.shiftRight.scheduler.Shift;

import chi.shiftRight.scheduler.calc.IDGenerator;
import chi.shiftRight.scheduler.constant.ShiftCode;
import chi.shiftRight.scheduler.staff.EmployeeFactory;
import chi.shiftRight.scheduler.staff.EmployeeTeam;
import chi.shiftRight.scheduler.staff.Employees;

import java.util.ArrayList;


public class TimeShift{
    private EmployeeTeam shiftTeam;
    private ArrayList<Employees> shiftStaffList;
    private ShiftCode shiftCode;
    private String shiftID;

    private boolean assignedTeam = false;


    public TimeShift(EmployeeTeam selectedStaffTeam){
        shiftStaffList = new ArrayList<>();
        shiftCode = ShiftCode.TIMESHIFT;
        shiftID = new IDGenerator(shiftCode.value()).generateID();

        this.shiftTeam = selectedStaffTeam;

        assignTeam(this.shiftTeam);
    }

    public String getShiftID(){
        return this.shiftID;
    }


    private void assignTeam(EmployeeTeam team){
        ArrayList<Employees> teamStaffList = team.getStaffList();

        if (!teamStaffList.isEmpty()){
            this.shiftTeam = team;
            assignedTeam = true;

            team.setShiftAssignedStatus(true);
            shiftStaffList = teamStaffList; // shiftTeam.getStaffList();
        }

    }


    public void printStaffList(){
        if (assignedTeam){
            EmployeeFactory.printStaffList(shiftStaffList);
        } else {
            System.err.println("Error: group not assigned to this timeshift " + shiftID);
        }
    }



    public ArrayList<Employees> getShiftStaffList(){
        if (assignedTeam)        {
            return this.shiftStaffList;
        } else return null;
    }


    public String getTeamID(){
        return this.shiftTeam.getGroupID();
    }


}
