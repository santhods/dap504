package chi.shiftright.scheduler.ShiftFactory;

import chi.shiftright.scheduler.Shift.DayShift;

public class DayShiftFactory {
    // private static final int DAY_LIMIT = 7;


    public DayShiftFactory() {


        for (int dayCounter = 0; dayCounter < DAY_LIMIT; dayCounter++){
            new DayShift();

    }




    }





}
