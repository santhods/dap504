package chi.shiftright.scheduler.constant;

public enum Position {
    DOCTOR, SENIOR_ASSISTANT, ASSISTANT;

    public String value(){
        switch(this){
            case DOCTOR: {
                return "Doctor";
            }
            case SENIOR_ASSISTANT:{
                return "Senior Assistant";
            }
            case ASSISTANT: {
                return "Assistant";
            }
            default: return null;
        }
    }


    public String code(){
        switch (this){
            case DOCTOR:{
                return "D";
            }
            case SENIOR_ASSISTANT:{
                return "S";
            }
            case ASSISTANT:{
                return "A";
            }
            default: return null;
        }
    }




}
