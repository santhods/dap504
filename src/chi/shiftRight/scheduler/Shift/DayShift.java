package chi.shiftRight.scheduler.Shift;

import chi.shiftRight.scheduler.calc.IDGenerator;
import chi.shiftRight.scheduler.constant.ShiftCode;

import java.util.ArrayList;

public class DayShift extends Shift{
    private ArrayList<TimeShift> shiftList;

    private ShiftCode shiftCode = ShiftCode.DAYSHIFT;


    public DayShift(ArrayList<TimeShift> timeShifts){
        super.ID = new IDGenerator(shiftCode.value()).generateID();

        this.shiftList = new ArrayList<>(timeShifts);
    }

    public ArrayList<TimeShift> getShiftList(){
        return this.shiftList;
    }
}
