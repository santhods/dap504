package chi.shiftRight.scheduler.Shift;

import chi.shiftRight.scheduler.constant.ShiftCode;

public abstract class Shift {
    protected ShiftCode shiftCode;
    protected String ID;
    protected String name;

    private String GenerateID(){
        return this.ID;
    }

    public String getID(){
        return this.ID;
    }

}






