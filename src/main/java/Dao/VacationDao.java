package Dao;

import State2.db.Storage;
import State2.entity.Personnel;
import State2.entity.Vacation;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class VacationDao {


    public  Set<Vacation> get(String nc) {
        Set<Vacation> vacationsOfPersonnel=new HashSet<>();
        for(Vacation v: Storage.getInstance().getVacations()){
            if(v.getNationalCode().equals(nc)){
                vacationsOfPersonnel.add(v);

            }
        }
        return vacationsOfPersonnel;
    }


    public Set<Vacation> getAll() {
        return Storage.getInstance().getVacations();
    }


    public void save(Vacation v) {
        Storage.getInstance().getVacations().add(v);
        System.out.println("vacation added");
        System.out.println(Storage.getInstance().getVacations());
    }

    public void update(Vacation v, String in15,Date datee) {
        v.setNationalCode(Objects.requireNonNull(
                in15, "firstName cannot be null"));
        v.setDate(Objects.requireNonNull(
                datee, "date cannot be null"));

        System.out.println("vacation is updated");
        System.out.println("new vacation list"+Storage.getInstance().getVacations());
    }


    public void delete(Vacation vd) {
        Storage.getInstance().getVacations().remove(vd);
        System.out.println("vacation deleted");
        System.out.println("new vacation list:"+Storage.getInstance().getVacations());
    }


}
