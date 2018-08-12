package chi.shiftRight.scheduler.constant;

public enum ShiftCode {
    TIMESHIFT, DAYSHIFT, WEEKSHIFT;

    public String value() {
        switch (this) {
            case TIMESHIFT: {
                return "TimeShift";
            }
            case DAYSHIFT: {
                return "DayShift";
            }
            case WEEKSHIFT: {
                return "WeekShift";
            }
            default: return null;
        }
    }

    public String code(){
            switch (this){
                case TIMESHIFT: {
                    return "HT";
                }
                case DAYSHIFT: {
                    return "HD";
                }
                case WEEKSHIFT: {
                    return "HW";
                }
                default: return null;
        }
    }


}
