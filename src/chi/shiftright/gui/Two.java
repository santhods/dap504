package chi.shiftright.gui;

import chi.shiftright.scheduler.constant.Position;

import java.util.Random;

public class Two {
    //public static String secretmessage = "Hello";


    public static void main(String args[]){

        Random rand = new Random();

        for (int n = 0; n < 20; n++){
            System.out.println(Position.values()[rand.nextInt(Position.values().length)]);
        }



    }

}
