package State2.db;

import State2.entity.Personnel;
import State2.entity.Vacation;

import java.util.*;

public class Storage {

    private static Storage storage=new Storage();
    private Set<Personnel> personnels;
    private Set<Vacation> vacations;
    {
        this.personnels= new HashSet<>();
        this.vacations= new HashSet<>();
        personnels.add(new Personnel("0610272616","Ali","gholami","Arak"));
        personnels.add(new Personnel("0610272613","hossein","rahimi","karaj"));
        personnels.add(new Personnel("0610272352","sadaf","alizadeh","bushehr"));
        personnels.add(new Personnel("0610272253","akbar","sadeghi","tehran"));



        vacations.add(new Vacation("0610272616",new Date("12/11/1998")));
        vacations.add(new Vacation("0610272616",new Date("07/05/2020")));
        vacations.add(new Vacation("0610272352",new Date("09/12/2018")));
        vacations.add(new Vacation("0610272253",new Date("30/09/2011")));
    }

    private Storage() {

    }

    public Set<Personnel> getPersonnels() {
        return personnels;
    }

    public Set<Vacation> getVacations() {
        return vacations;
    }
    public static Storage getInstance(){
        return storage;
    }

    @Override
    public String toString() {
        return "Storage:"+"{"+personnels+","+vacations+"}";
    }
    //    public boolean doneAddPersonnel(){
//
//
//    }
//    public boolean doneAddVacation(){
//
//    }



}
