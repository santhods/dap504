package chi.shiftright.scheduler.staff;

import chi.shiftright.scheduler.calc.IDGenerator;

import java.util.ArrayList;
import java.util.Random;

public class EmployeeTeamFactory {
    private ArrayList<EmployeeTeam> teams;

    private final int TEAM_TOTAL = 4; //default value should be 6
    private final int TEAM_LIMIT = 3;

    private String teamName;

    private EmployeeFactory GenerateEmployees = new EmployeeFactory();

    public EmployeeTeamFactory(){
        teams = new ArrayList<>();

        for (int teamCounter = 0; teamCounter < TEAM_TOTAL; teamCounter++){
            teams.add(new EmployeeTeam(new IDGenerator("Team").generateID(), GenerateEmployees));
        }

        System.out.println("Team size: " + teams.size());
        // GenerateEmployees. teams.get(0).getStaffList();
    }


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
