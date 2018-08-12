package chi.shiftRight.scheduler.calc;


import chi.shiftRight.scheduler.constant.Position;
import chi.shiftRight.scheduler.constant.ShiftCode;

public class IDGenerator {

    private String constraint;

    private static final String TEAMCODE = "T", GROUPCODE = "G";

    private static int doctorCounter = 0, seniorAsnCounter = 0, asnCounter = 0;
    private static int shiftCounter = 0, dayCounter = 0, weekCounter = 0;
    private static int teamCounter = 0, groupCounter = 0;
    private static int genericCounter = 0;


    public IDGenerator(String constraint){
        this.constraint = constraint;
    }

    public String generateID(){
        String IDStr = "";

        switch (constraint){
            case "Doctor": {
                doctorCounter += 1;
                IDStr  = Position.DOCTOR.code() + formatID(doctorCounter);
                break;
            }
            case "Senior Assistant": {
                seniorAsnCounter += 1;
                IDStr  = Position.SENIOR_ASSISTANT.code() + formatID(seniorAsnCounter);
                break;
            }
            case "Assistant": {
                asnCounter += 1;
                IDStr  = Position.ASSISTANT.code() + formatID(asnCounter);
                break;
            }

            case "TimeShift": {
                shiftCounter += 1;
                IDStr = ShiftCode.TIMESHIFT.code() + formatID(shiftCounter);
                break;
            }

            case "DayShift": {
                dayCounter += 1;
                IDStr = ShiftCode.DAYSHIFT.code() + formatID(dayCounter);
                break;
            }

            case "WeekShift": {
                weekCounter += 1;
                IDStr = ShiftCode.WEEKSHIFT.code() + formatID(weekCounter);
                break;
            }

            case "Team":{
                teamCounter += 1;
                IDStr = TEAMCODE + formatID(teamCounter);
                break;
            }

            case "Group":{
                groupCounter += 1;
                IDStr = GROUPCODE + formatID(groupCounter);
                break;
            }

            default:
                IDStr = constraint + formatID(genericCounter);
        }

        return IDStr;
    }


    private String formatID(int counter){
        return String.format("%03d", counter);
    }
    
    
    public static void resetStaffCounter(){
        doctorCounter = 0;
        seniorAsnCounter = 0;
        asnCounter = 0;
        shiftCounter = 0;
        dayCounter = 0;
        weekCounter = 0;
        teamCounter = 0;
        groupCounter = 0;
        genericCounter = 0;
    }
}



