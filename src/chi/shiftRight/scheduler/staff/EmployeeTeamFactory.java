package chi.shiftRight.scheduler.staff;

import chi.shiftRight.scheduler.calc.IDGenerator;

import java.util.ArrayList;
import java.util.Random;

public class EmployeeTeamFactory {
    private ArrayList<EmployeeTeam> teams;

    private final int TEAM_TOTAL = 6; //default value should be 6 = 24 staff in total
    private final int TEAM_LIMIT = 3; // specify the maximum number of teams per day

    private String teamName;

    private EmployeeFactory GenerateEmployees = new EmployeeFactory();

    public EmployeeTeamFactory(){
        teams = new ArrayList<>();

        for (int teamCounter = 0; teamCounter < TEAM_TOTAL; teamCounter++){
            teams.add(new EmployeeTeam(GenerateEmployees));
        }

        System.out.println("Team size: " + teams.size());
        // GenerateEmployees. teams.get(0).getStaffList();
    }

    // return three Employee Teams
    public ArrayList<EmployeeTeam> getTeams() {
        int teamCounter = 0;
        Random rand = new Random();
        EmployeeTeam tempTeam;
        ArrayList<EmployeeTeam> tempTeams = new ArrayList<>();

    // for (int teamCounter = 0; teamCounter < TEAM_LIMIT; teamCounter++){

        while (teamCounter < TEAM_LIMIT){
            tempTeam = teams.get(rand.nextInt(teams.size()));
            // aiming to get three teams for each method call
            if (!tempTeam.getHasGroup()){
                tempTeams.add(tempTeam);
                tempTeam.setHasGroup(true);
                teamCounter++;
            }
        }

        System.out.println("getTeams size: " + tempTeams.size());

        return tempTeams;
    }


}
