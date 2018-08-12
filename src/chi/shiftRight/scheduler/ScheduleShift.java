package chi.shiftRight.scheduler;

import chi.shiftRight.scheduler.Shift.DayShift;
import chi.shiftRight.scheduler.Shift.TimeShift;
import chi.shiftRight.scheduler.Shift.WeekShift;
import chi.shiftRight.scheduler.ShiftFactory.WeekShiftFactory;
import java.util.ArrayList;

public class ScheduleShift{
    ArrayList<WeekShift> oneWeekShift;
    
    
    public ScheduleShift(){
        oneWeekShift = new WeekShiftFactory().getWeekList();
    }

    public void run(){
        System.out.println("Size of weekshift : " + oneWeekShift.size());
        for (WeekShift week : oneWeekShift){
            System.out.println("Week: " + week.getID());

            for (DayShift day : week.getDayList()){
                System.out.println("\tDay: " + day.getID());
                for (TimeShift shift : day.getShiftList()){
                    System.out.println("\t" + shift.getShiftID());
                    System.out.println("\tTeam: " + shift.getTeamID());
                     shift.printStaffList();
                }

            }
        }

    }
    
   public ArrayList<WeekShift> getScheduledShift(){
       return this.oneWeekShift;
   }


}
