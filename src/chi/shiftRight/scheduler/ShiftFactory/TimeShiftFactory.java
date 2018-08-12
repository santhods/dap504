package chi.shiftRight.scheduler.ShiftFactory;

import chi.shiftRight.scheduler.Shift.TimeShift;
import chi.shiftRight.scheduler.staff.EmployeeTeam;
import chi.shiftRight.scheduler.staff.EmployeeTeamFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TimeShiftFactory {
    private static final int SHIFT_LIMIT = 3;
    private EmployeeTeamFactory shiftTeam;

    private ArrayList<EmployeeTeam> staffTeams;

    private ArrayList<TimeShift> shiftList;

    private boolean shiftListAssigned = false;


    public TimeShiftFactory(EmployeeTeamFactory team){
        this.shiftTeam = team;
        // staffTeams = shiftTeam.getTeams().
        staffTeams = shiftTeam.getTeams();
        System.out.println(staffTeams.size());

        /*
        System.out.println("Before shuffle: ");
        staffTeams.forEach(t -> System.out.println(t.getGroupID()));

        Collections.shuffle(staffTeams);

        System.out.println("After shuffle: ");
        staffTeams.forEach(t -> System.out.println(t.getGroupID()));

        */

        this.shiftList = getTimeShiftList();
    }

    private ArrayList<TimeShift> getTimeShiftList(){
        ArrayList<TimeShift> assignedShifts = new ArrayList<>();
        Random rand = new Random();
        int staffTeamsSize = staffTeams.size();//m - 1;

        System.out.println("Initial staff team size: " + staffTeamsSize);

        staffTeams.forEach(team -> System.out.println("Team: " + team.getGroupID()));

        for (EmployeeTeam team: staffTeams){
            assignedShifts.add(new TimeShift(team));
        }

        // staffTeamsSize--;


        /*
        EmployeeTeam tempTeam;
        // int shiftCounter = 0;

        for (int shiftCounter = 0; shiftCounter <= 3; shiftCounter++){

        // for (int shiftCounter = 0; shiftCounter <= 10; shiftCounter++){
         // while (shiftCounter < 10){  // SHIFT_LIMIT){
             System.out.println("Staff team size: " + staffTeamsSize);


             int randomindex = rand.nextInt(staffTeamsSize);

            System.out.println("Getting a team at index: " + randomindex);

            tempTeam = staffTeams.get(randomindex);

            System.out.println("Chosen team: " + tempTeam.getGroupID());

            if (!tempTeam.getShiftAssignedStatus()){
                assignedShifts.add(new TimeShift(tempTeam));
                // tempTeam.setShiftAssignedStatus(true);
                // shiftCounter++;
            } else {
                System.out.println("Team: " + tempTeam.getGroupID() + " is already selected.");
            }

             System.out.println("Counter: " + shiftCounter);
        }
        */

        System.out.println("Timeshift size: " + assignedShifts.size());
        this.shiftListAssigned = true;
        return assignedShifts;
    }


    public ArrayList<TimeShift> getAssignedShiftList(){
        if (shiftListAssigned){

            /*
            System.out.println("Before shuffle: ");
            this.shiftList.forEach(shift -> System.out.println(shift.getShiftID()));
            */

            Collections.shuffle(this.shiftList);

            /*
            System.out.println("After shuffle: ");
            this.shiftList.forEach(shift -> System.out.println(shift.getShiftID()));
            */

            return this.shiftList;
        } else return null;
    }



}
