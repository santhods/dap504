package chi.shiftright.scheduler.Shift;

import java.util.ArrayList;

public class DayShift extends Shift{
    private ArrayList<TimeShift> shiftList;

    /*
    private TimeShift shiftOne, shiftTwo, shiftThree;

    public DayShift(TimeShift shiftOne, TimeShift shiftTwo, TimeShift shiftThree){
        this.shiftOne = shiftOne;
        this.shiftTwo = shiftTwo;
        this.shiftThree = shiftThree;
    }


  */


    public DayShift(String name, ArrayList<TimeShift> timeShifts){
        // super.ID =
        super.name = name;


    }

}
