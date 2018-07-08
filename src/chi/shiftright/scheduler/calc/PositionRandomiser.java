package chi.shiftright.scheduler.calc;

import chi.shiftright.scheduler.constant.Position;
import chi.shiftright.scheduler.staff.Employees;

import java.util.Random;

public class PositionRandomiser {
    private static boolean docSelected = false;
    private static boolean snrSelected = false;
    private static boolean saSelected = false;

    private static int saCounter = 0;

    private static int staffCounter = 0;



    public static void main(String args[]) {

/*
        System.out.println("First set: ");
        while (!(docSelected && snrSelected && saSelected)) {
           // for (int n = 0; n <= 1; n++) {
                if (staffCounter == 2){
                    System.out.println("-----------------");
                    System.out.println("Running a new set");
                }
                runner(); //run runner method twice.
          //  }
        }


    }


    private static void runner(){
        Random rand = new Random();
        //int poslen = Employees.POSITIONS.size();
        int poslen = Position.values().length;
        //System.out.println(Position.);

        for (int n = 0; n <= 1; n++) {

            if (saCounter == 2) saSelected = true;

            if (docSelected && snrSelected && saSelected) {
                System.out.println("Positions fulfilled");
                // break;
            }
            System.out.print(n + " ");

          //  switch (Employees.POSITIONS.get(rand.nextInt(poslen))) {
            switch (Position.values()[rand.nextInt(Position.values().length)]){
                case DOCTOR: {
                    if (docSelected) {
                        System.out.println("Skip doctor");
                        break;
                    } else {
                        docSelected = true;
                        System.out.println("A doctor is selected");
                        staffCounter++;
                        break;
                    }

                }
                case SENIOR_ASSISTANT: {
                    if (snrSelected) {
                        System.out.println("Skip Snr Assistant");
                        break;
                    } else {
                        snrSelected = true;
                        System.out.println("A senior assistant is selected");
                        staffCounter++;
                        break;
                    }
                }

                case ASSISTANT: {
                    if (saSelected) {
                        System.out.println("Skip Assistant");
                        break;
                    } else {
                        // saSelected = true;
                        System.out.println("An assistant is selected");
                        saCounter++;
                        staffCounter++;
                        break;
                    }
                }

            }
        }

        if (!(docSelected && snrSelected && saSelected)){
            System.out.println("Need to rerun");
        } else {
            System.out.println("All positions fulfilled");
        }

    }


*/

    }
}
