package chi.shiftright.scheduler.constant;

import chi.shiftright.scheduler.staff.EmployeeFactory;
import chi.shiftright.scheduler.staff.EmployeeTeam;
import chi.shiftright.scheduler.staff.EmployeeTeamFactory;
import chi.shiftright.scheduler.staff.Employees;

import java.util.ArrayList;

public class Group {

    public static void main(String args[]){

        ArrayList<EmployeeTeam> teamList = new EmployeeTeamFactory().getTeams(); // .forEach(employeeTeam -> employeeTeam.getStaffList());

        teamList.forEach(team -> EmployeeFactory.printStaffList(team.getStaffList()));

        // EmployeeFactory.printStaffList(list);

    }




}
