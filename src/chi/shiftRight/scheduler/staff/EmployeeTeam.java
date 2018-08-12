package chi.shiftRight.scheduler.staff;

import chi.shiftRight.scheduler.Shift.TimeShift;
import chi.shiftRight.scheduler.calc.IDGenerator;
import chi.shiftRight.scheduler.constant.Gender;
import chi.shiftRight.scheduler.constant.Position;

import java.util.ArrayList;
import java.util.Random;

public class EmployeeTeam {
    private ArrayList<Employees> maleList, femaleList;
    private ArrayList<Employees> staffList;

    // private TimeShift assignedShift;

    private boolean isAssignedShift = false;

    private String groupID;

    private boolean switchset = false;

    private boolean docSelected = false;
    private boolean snrSelected = false;
    private boolean saSelected = false;
    private boolean genderBalanced = false;
    private int saCounter = 0;

    private boolean hasGroup = false;



    public EmployeeTeam(EmployeeFactory employeesList) {
        staffList = new ArrayList<>();
        this.groupID = new IDGenerator("Team").generateID();
        this.maleList = employeesList.getMaleList();
        this.femaleList = employeesList.getFemaleList();

        // this.staffList = formTeam();

        /*

        ArrayList<Employees> femaleStaff = GenerateEmployees.getFemaleList();
        ArrayList<Employees> maleStaff = GenerateEmployees.getMaleList();


        // Creating 6 groups with the total of 24 staff overall.
        // Then create three timeshift


        // EmployeeTeam team1 = new EmployeeTeam("Team alpha", GenerateEmployeeList.getEmployeesList());



        */
    }


    public ArrayList<Employees> getStaffList(){
        this.staffList = formTeam();

        return this.staffList;
    }


    private ArrayList<Employees> formTeam() {
        ArrayList<Employees> uncheckedStaffList = getUniqueStaffList();

        genderBalanced = checkGenderBalanceList(uncheckedStaffList);

        /*
        if (checkGenderBalanceList(uncheckedStaffList) == true){
            return uncheckedStaffList;
        } else {
            System.out.println("Gender not balanced, rerun again.");
            return null;
        }

        */

        while (!genderBalanced) {
            System.out.println("Gender not balanced, rerun again.");

            resetSelectionStatus();


            uncheckedStaffList.forEach(staff -> staff.setHasGroup(false));
            uncheckedStaffList = getUniqueStaffList();
            genderBalanced = checkGenderBalanceList(uncheckedStaffList);
        }

        // this.staffList = uncheckedStaffList;

         /*
         System.err.println(groupName);
        staffList.forEach(staff -> System.out.println(staff.getEmployeeID() + ": " + staff.getName() + ", " + staff.getGender()));
        */
        return uncheckedStaffList;

    }

    private ArrayList<Employees> getUniqueStaffList() {
        int staffCounter = 0;
        Employees tempStaff;
        ArrayList<Employees> dynamicList;
        ArrayList<Employees> tempStaffList = new ArrayList<>();


        while (!(docSelected && snrSelected && saSelected)) {


                /* for debugging purpose only
                System.out.println("Staff counter: " + staffCounter);
                printStaffList();
                */

            dynamicList = getDynamicGenderList();

            if (staffCounter >= 2) {
                tempStaff = getRandomStaff(dynamicList);
            } else {
                tempStaff = getRandomStaff(dynamicList);
            }

            if (tempStaff != null) {

                tempStaffList.add(tempStaff);
                staffCounter++;
            } else {
                System.out.println("A staff is not available");
            }

        }

        /* for debugging purpose only
        if (!(docSelected && snrSelected && saSelected)){
            System.out.println("Need to rerun");
        } else {
            System.out.println("All positions fulfilled");
        }

        System.out.println("Size of staff list before return: " + tempStaffList.size());
    */
        return tempStaffList;

    }

    private Employees getRandomStaff(ArrayList<Employees> list) {
        Random rand = new Random();
        Employees selectedStaff = null;
        Position selectedRandomPosition;


        ArrayList<Employees> doctorsList = getPositionList(list, Position.DOCTOR);
        ArrayList<Employees> snrAssistantList = getPositionList(list, Position.SENIOR_ASSISTANT);
        ArrayList<Employees> assistantList = getPositionList(list, Position.ASSISTANT);


        boolean doctorsListEmpty = doctorsList.isEmpty();
        boolean snrAssistantListEmpty = snrAssistantList.isEmpty();
        boolean assistantListEmpty = assistantList.isEmpty();

        /* for debugging purpose only
        System.out.println("Total number of doctors = " + doctorsList.size());
        System.out.println("Total number of senior assistants = " + snrAssistantList.size());
        System.out.println("Total number of assistants = " + assistantList.size());


        System.out.println("Doctor list status " + doctorsListEmpty);
        System.out.println("Senior assistant list status " + snrAssistantListEmpty);
        System.out.println("Assistant list status " + assistantListEmpty);
        */


        if (saCounter == 2) saSelected = true;

        if (docSelected && snrSelected && saSelected) {
            System.out.println("Positions fulfilled");
        }


        selectedRandomPosition = Position.values()[rand.nextInt(Position.values().length)];
        System.out.println("Selected random position: " + selectedRandomPosition.value());

        switch (selectedRandomPosition) {
            case DOCTOR: {
                if (docSelected) {
                    System.out.println("Skip doctor");
                    break;
                } else {

                    if (!doctorsList.isEmpty()) {

                        System.out.println("Getting a doctor");
                        selectedStaff = getOneRandomEmployee(doctorsList);
                        docSelected = true;
                        break;
                    } else {
                        System.out.println("Doctor list is empty.");
                    }

                }

            }
            case SENIOR_ASSISTANT: {
                if (snrSelected) {
                    System.out.println("Skip Snr Assistant");
                    break;
                } else {

                    if (!snrAssistantList.isEmpty()) {
                        System.out.println("Getting a senior assistant");
                        selectedStaff = getOneRandomEmployee(snrAssistantList);
                        snrSelected = true;
                        break;
                    } else {
                        System.out.println("Senior assistant list is empty");
                    }

                }
            }

            case ASSISTANT: {
                if (saSelected) {
                    System.out.println("Skip Assistant");
                    break;
                } else {

                    if (!assistantList.isEmpty()) {
                        // System.out.println("Getting an assistant");
                        selectedStaff = getOneRandomEmployee(assistantList);
                        saCounter++;
                    } else {
                        System.out.println("Assistant list is empty.");
                    }
                    break;
                }
            }

        }

        if (selectedStaff != null) {
            selectedStaff.setHasGroup(true);
            return selectedStaff;
        } else {
            return null;
        }

    }

    private boolean checkGenderBalanceList(ArrayList<Employees> list) {
        int femaleList = 0;

        for (Employees staff : list) {
            if (staff.getGender() == Gender.FEMALE)
                femaleList++;
        }
        return (femaleList == 2);
    }

    private ArrayList<Employees> getPositionList(ArrayList<Employees> rawlist, Position position) {
        ArrayList<Employees> filteredList = new ArrayList<>();

        for (Employees staff : rawlist) {
            if (staff.getPosition() == position && staff.getHasGroup() == false) {
                filteredList.add(staff);
            }
        }
        return filteredList;

    }

    private Employees getOneRandomEmployee(ArrayList<Employees> list) {
        Random randomiser = new Random();
        Employees selectedStaff;
        int listSize;

        if (!list.isEmpty()) {
            listSize = list.size() == 1 ? 1 : list.size() - 1;

            System.out.println("List size: " + listSize);
            System.out.println("Random position: " + randomiser.nextInt(listSize));

            selectedStaff = list.get(randomiser.nextInt(listSize));
            return selectedStaff;

        } else return null;
    }

    private ArrayList<Employees> getDynamicGenderList(){
       if (switchset == true){
           switchset = false;
       } else {
           switchset = true;
       }


       if (switchset == true){
           return femaleList;
       } else {
           return maleList;
       }

    }

    private void resetSelectionStatus(){
        this.saCounter = 0;
        this.saSelected = false;
        this.snrSelected = false;
        this.docSelected = false;
    }


    public boolean getHasGroup(){
        return this.hasGroup;

    }

    public void setHasGroup(boolean groupStatus){
        this.hasGroup = groupStatus;

        }

        public boolean getShiftAssignedStatus(){
            return this.isAssignedShift;
        }

        public void setShiftAssignedStatus(boolean status){
            this.isAssignedShift = status;
        }

        public String getGroupID(){
        return this.groupID;
        }
}
