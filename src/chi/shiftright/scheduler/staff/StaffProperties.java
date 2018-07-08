package chi.shiftright.scheduler.staff;

import java.util.ArrayList;
import java.util.Random;

class Items{
    private String name;
    private boolean isSelected = false;

    public Items(String name){
        this.name = name;
    }


    public String getName(){
        return this.name;
    }

    public boolean getStatus() {
        return isSelected;
    }

    public void setStatus(boolean status){
        this.isSelected = status;
    }
}


// not in use at the moment
public final class StaffProperties {


    public static void main(String args[]){

        // creating six teams
        ArrayList<Items> list = new ArrayList<>();

        list.add(new Items("A"));
        list.add(new Items("B"));
        list.add(new Items("C"));
        list.add(new Items("D"));
        list.add(new Items("E"));
        list.add(new Items("F"));

        Random rand = new Random();

        Items temp;

        for (int n = 1; n <= 2; n++){
            System.out.println("Day " + n);

            System.out.print("Select the following groups: ");
            for (int selector = 1; selector <= 3; selector++){
                temp = list.get(rand.nextInt(list.size()));

                if (!temp.getStatus()){
                    System.out.print(temp.getName() + " ");
                    temp.setStatus(true);
                } else selector--;

                // System.out.println(selector);

            }
            System.out.println();
        }



    }
}
