package chi.shiftright.scheduler.staff;

import chi.shiftright.scheduler.constant.Gender;
import chi.shiftright.scheduler.constant.Position;
import java.util.ArrayList;
import java.util.Collections;

public class EmployeeFactory {
    private ArrayList<Employees> EmployeeList;
    private ArrayList<Employees> MaleEmployees;
    private ArrayList<Employees> FemaleEmployees;

    public EmployeeFactory() {
        this.EmployeeList = new ArrayList<>();
        this.EmployeeList.add(new Employees("John Smith", Position.DOCTOR, Gender.MALE)); //D001
        this.EmployeeList.add(new Employees("Ivanka", Position.DOCTOR, Gender.FEMALE)); //D002
        this.EmployeeList.add(new Employees("Carl", Position.DOCTOR, Gender.MALE));
        this.EmployeeList.add(new Employees("Lily", Position.DOCTOR, Gender.FEMALE));
        this.EmployeeList.add(new Employees("Jimmy", Position.SENIOR_ASSISTANT, Gender.MALE)); //S001
        this.EmployeeList.add(new Employees("Amanda", Position.SENIOR_ASSISTANT, Gender.FEMALE)); //S002
        this.EmployeeList.add(new Employees("Michael", Position.SENIOR_ASSISTANT, Gender.MALE));
        this.EmployeeList.add(new Employees("Penny", Position.SENIOR_ASSISTANT, Gender.FEMALE));
        this.EmployeeList.add(new Employees("Kate", Position.ASSISTANT, Gender.FEMALE)); //A001
        this.EmployeeList.add(new Employees("Paul", Position.ASSISTANT, Gender.MALE)); //A002
        this.EmployeeList.add(new Employees("Peter", Position.ASSISTANT, Gender.MALE)); //A003
        this.EmployeeList.add(new Employees("Caroline", Position.ASSISTANT, Gender.FEMALE)); //A004
        this.EmployeeList.add(new Employees("Philip", Position.ASSISTANT, Gender.MALE));
        this.EmployeeList.add(new Employees("Katheryn", Position.ASSISTANT, Gender.FEMALE));
        this.EmployeeList.add(new Employees("Matthew", Position.ASSISTANT, Gender.MALE));
        this.EmployeeList.add(new Employees("Ann", Position.ASSISTANT, Gender.FEMALE));

        this.MaleEmployees = getGenderList(this.EmployeeList, Gender.MALE);
        this.FemaleEmployees = getGenderList(this.EmployeeList, Gender.FEMALE);
    }

    public int getEmployeeSize() {
        return this.EmployeeList.size();
    }

    public ArrayList<Employees> getEmployeeList() {

        Collections.shuffle(this.EmployeeList);

        return this.EmployeeList;
    }

    public ArrayList<Employees> getMaleList() {

        Collections.shuffle(this.MaleEmployees);

        return this.MaleEmployees;
    }

    public ArrayList<Employees> getFemaleList() {

        Collections.shuffle(this.FemaleEmployees);

        return this.FemaleEmployees;
    }

    private ArrayList<Employees> getGenderList(ArrayList<Employees> list, Gender gender) {
        ArrayList<Employees> filteredList = new ArrayList<>();

        for (Employees staff : list) {
            if (staff.getGender() == gender && staff.getHasGroup() == false) {
                filteredList.add(staff);
            }

        }
        return filteredList;

    }

    public static void printStaffList(ArrayList<Employees> list) {
        list.forEach(staff -> System.out.println(staff.getEmployeeID() + ": " + staff.getName() + ", " + staff.getGender()));
        }
}
