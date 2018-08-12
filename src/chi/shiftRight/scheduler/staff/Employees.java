package chi.shiftRight.scheduler.staff;

import chi.shiftRight.scheduler.calc.IDGenerator;
import chi.shiftRight.scheduler.constant.Gender;
import chi.shiftRight.scheduler.constant.Position;


public class Employees {
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
            this.employeeID = new IDGenerator(position.value()).generateID();
        }

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

        public String getEmployeeDetails(){
            return this.employeeID + ": " + this.name + ", " + this.gender + ", " + this.position;
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
