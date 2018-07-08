package chi.shiftright.scheduler.staff;

import chi.shiftright.scheduler.calc.IDGenerator;
import chi.shiftright.scheduler.constant.Gender;
import chi.shiftright.scheduler.constant.Position;


public class Employees {

        //public static ArrayList<String> POSITIONS = new ArrayList<>(Arrays.asList("Doctor", "Senior Assistant", "Assistant"));

        // private static int dCounter = 0, sCounter = 0, aCounter = 0;

        private String employeeID;
        private String name;
        private Position position;
        private Gender gender;
        private Boolean hasGroup = false;
        private EmployeeTeam group;


        public Employees(String name, Position position, Gender gender){
            this.name = name;
            this.position = position;
            this.gender = gender;
            this.employeeID = new IDGenerator(position.value()).generateID(); // generateID(position);


            System.out.println("A new employee is created with the ID: " + this.employeeID);
        }

    /*
        private String generateID(String position){
            String IDStr = "";

            switch (position){
                case "Doctor": {
                    dCounter += 1;
                    IDStr  = "D" + formatID(dCounter);
                    break;
                }
                case "Senior Assistant": {
                    sCounter += 1;
                    IDStr  = "S" + formatID(sCounter);
                    break;
                }
                case "Assistant": {
                    aCounter += 1;
                    IDStr  = "A" + formatID(aCounter);
                    break;
                }

            }

            return IDStr;
        }

        private String formatID(int counter){
            return String.format("%03d", counter);
        }
        */

        public String getName(){
            return this.name;
        }

        public Gender getGender(){
            return this.gender;
        }

        public Position getPosition(){
            return this.position;
        }

        public String getEmployeeID(){
            return this.employeeID;
        }


        public Employees getEmployee(){
            return this;
        }

        public void setHasGroup(boolean status){
            this.hasGroup = status;
        }

        public Boolean getHasGroup(){
            return this.hasGroup;
        }


        public void setGroup(EmployeeTeam group){
            this.group = group;
        }



}
