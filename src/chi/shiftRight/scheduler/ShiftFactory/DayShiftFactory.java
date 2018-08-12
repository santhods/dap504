package chi.shiftRight.scheduler.ShiftFactory;

import chi.shiftRight.scheduler.Shift.DayShift;
import chi.shiftRight.scheduler.Shift.TimeShift;
import chi.shiftRight.scheduler.staff.EmployeeTeamFactory;

import java.util.ArrayList;

public class DayShiftFactory {
    private static final int DAY_LIMIT = 7;

    private ArrayList<DayShift> dayList = new ArrayList<>();

    private boolean listAssigned = false;

    private boolean switchset = false;

    ArrayList<TimeShift> selectedTimeList;

    TimeShiftFactory oddDayShifts, evenDayShifts;


    public DayShiftFactory() {
        EmployeeTeamFactory oneShiftTeam = new EmployeeTeamFactory();

        /*
        TimeShiftFactory oddDayShifts = new TimeShiftFactory(oneShiftTeam);

        TimeShiftFactory evenDayShifts = new TimeShiftFactory(oneShiftTeam);

        */
        oddDayShifts = new TimeShiftFactory(oneShiftTeam);

        evenDayShifts = new TimeShiftFactory(oneShiftTeam);


        // ArrayList<TimeShift> oddDayShiftList = oddDayShifts.getAssignedShiftList();

        // ArrayList<TimeShift> evenDayShiftList = evenDayShifts.getAssignedShiftList();

        /*
        System.out.println("Before assignment ----");
        System.out.println("ODDS:");
        oddDayShiftList.forEach(shift -> shift.printStaffList());
        System.out.println("EVENS:");
        evenDayShiftList.forEach(shift -> shift.printStaffList());
        */


        /*

        for (int dayCounter = 0; dayCounter < DAY_LIMIT; dayCounter++){

            if (dayCounter % 2 == 0){
                // Collections.shuffle(evenDayShiftList);
                dayList.add(new DayShift(evenDayShiftList));
            } else {
                // Collections.shuffle(evenDayShiftList);
                dayList.add(new DayShift(oddDayShiftList));
            }


            System.out.println("After assignment ----");
            System.out.println("ODDS:");
            oddDayShiftList.forEach(shift -> shift.printStaffList());
            System.out.println("EVENS:");
            evenDayShiftList.forEach(shift -> shift.printStaffList());


            //System.out.println("Day: " + dayCounter + " is an" + (dayCounter % 2 == 0 ? " even " : " odd ") + "day.");
            //new DayShift();
        }

        */


        for (int dayCounter = 0; dayCounter < DAY_LIMIT; dayCounter += 2){

            selectedTimeList = getDynamicDaySet();

            System.out.println("Size of selected time list: " + selectedTimeList.size());

            dayList.add(new DayShift(selectedTimeList));

            if (dayList.size() == DAY_LIMIT){
                break;
            }

            dayList.add(new DayShift(selectedTimeList));

            /*
            if (dayCounter % 2 == 0){new ArrayList<>(
                dayList.add(new DayShift(evenDayShifts.getAssignedShiftList()));
            } else {
                dayList.add(new DayShift(oddDayShifts.getAssignedShiftList()));
            }*
            */

        }

        // oddDayShifts.getAssignedShiftList();

        this.listAssigned = true;

        System.out.println("Size of dayshift list : " + dayList.size());

    }


    private ArrayList<TimeShift> getDynamicDaySet(){
        if (switchset == true){
            switchset = false;
        } else {
            switchset = true;
        }

        if (switchset == true){
            return oddDayShifts.getAssignedShiftList();
        } else {
            return evenDayShifts.getAssignedShiftList();
        }

    }


    public ArrayList<DayShift> getDayList(){
        if (listAssigned){
            return this.dayList;
        } return null;
    }

}
