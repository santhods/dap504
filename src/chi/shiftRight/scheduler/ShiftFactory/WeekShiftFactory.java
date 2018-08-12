package chi.shiftRight.scheduler.ShiftFactory;

import chi.shiftRight.scheduler.Shift.DayShift;
import chi.shiftRight.scheduler.Shift.WeekShift;

import java.util.ArrayList;

public class WeekShiftFactory {

    private static final int WEEK_LIMIT = 1;

    private ArrayList<WeekShift> weekList = new ArrayList<>();

    private ArrayList<DayShift> workingDayList;

    public WeekShiftFactory(){

        for (int n = 0; n < WEEK_LIMIT; n++){
            workingDayList = new DayShiftFactory().getDayList();
            weekList.add(new WeekShift(workingDayList));
        }
    }

    public ArrayList<WeekShift> getWeekList(){
        return this.weekList;
    }


}
