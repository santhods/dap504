package chi.shiftright.scheduler.ShiftFactory;

import chi.shiftright.scheduler.Shift.TimeShift;
import chi.shiftright.scheduler.staff.EmployeeTeamFactory;
import chi.shiftright.scheduler.staff.Employees;

import java.util.ArrayList;

public class TimeShiftFactory {
    private static final int SHIFT_LIMIT = 3;
    private EmployeeTeamFactory shiftTeam;

    private ArrayList<Employees> teamStaff;


    public TimeShiftFactory(EmployeeTeamFactory team){
        this.shiftTeam = team;
        // teamStaff = shiftTeam.getTeams().
        System.out.println(shiftTeam.getTeams().size());
    }

    public ArrayList<TimeShift> getTimeShiftList(){


        shiftTeam.getTeams();
    }



}
