package State2;

import java.util.LinkedList;
import java.util.List;

public class Storage {
    private List<Personnel> listOfPersonnel=new LinkedList<>();
    private List<Vacation> listOfVacation=new LinkedList<>();

    public List<Personnel> getListOfPersonnel() {
        return listOfPersonnel;
    }

    public void setListOfPersonnel(List<Personnel> listOfPersonnel) {
        this.listOfPersonnel = listOfPersonnel;
    }

    public List<Vacation> getListOfVacation() {
        return listOfVacation;
    }

    public void setListOfVacation(List<Vacation> listOfVacation) {
        this.listOfVacation = listOfVacation;
    }
}
