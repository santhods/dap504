package chi.shiftright.scheduler.constant;

public enum Gender {
    MALE, FEMALE;

    String value(){
        switch (this){
            case MALE: return "MALE";
            case FEMALE: return "FEMALE";
            default: return null;
        }
    }

}
