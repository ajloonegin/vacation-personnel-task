package Dao;

import State2.db.Storage;
import State2.entity.Personnel;

import java.util.*;


public class PersonnelDao{

    public Personnel get(String nc) {
        for(Personnel p: Storage.getInstance().getPersonnels()){
            if(p.getNationalCode().equals(nc)){
                System.out.println("personnel found");
                return p;
            }
        }
        return null;
    }


    public Set<Personnel> getAll() {
        return Storage.getInstance().getPersonnels();
    }


    public void save(Personnel p) {
        Storage.getInstance().getPersonnels().add(p);
    }



    public void update(Personnel p, String[] params) {
        p.setNationalCode(Objects.requireNonNull(
                    params[0], "firstName cannot be null"));
        p.setFirstName(Objects.requireNonNull(
                    params[1], "firstName cannot be null"));
        p.setLastName(Objects.requireNonNull(
                    params[2], "lastName cannot be null"));
        p.setCityName(Objects.requireNonNull(
                    params[3], "cityName cannot be null"));

        System.out.println("Personnel updated");
        System.out.println("new list of Personnel:"+Storage.getInstance().getPersonnels());


    }


    public void delete(Personnel pd) {
        Storage.getInstance().getPersonnels().remove(pd);
        System.out.println("Personnel deleted");
        System.out.println("new personnel list:"+Storage.getInstance().getPersonnels());
    }




}
