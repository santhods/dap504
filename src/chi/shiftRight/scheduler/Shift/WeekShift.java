package chi.shiftRight.scheduler.Shift;

import chi.shiftRight.scheduler.calc.IDGenerator;
import chi.shiftRight.scheduler.constant.ShiftCode;

import java.util.ArrayList;

public class WeekShift extends Shift {
    private ArrayList<DayShift> daysList;



    public WeekShift(ArrayList<DayShift> givenDayList){
        super.shiftCode = ShiftCode.WEEKSHIFT;
        daysList = givenDayList; //new ArrayList<>(givenDayList);
        super.ID = new IDGenerator(super.shiftCode.value()).generateID();
    }


    public ArrayList<DayShift> getDayList(){
        return this.daysList;
    }



}
