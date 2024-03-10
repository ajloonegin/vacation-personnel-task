package State2.service;


import Dao.VacationDao;
import State2.db.Storage;
import State2.entity.Personnel;
import State2.entity.Vacation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class VacationService {
    static VacationDao vacationDao = new VacationDao();
    public static boolean addVacation(Vacation v){
        try {
            Storage storage=Storage.getInstance();



            vacationDao.save(v);
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }
    }

    public static Set<Vacation> showVacations(String ncCode){
        Storage storage=Storage.getInstance();


        return vacationDao.get(ncCode);

    }

    public static void updateVacation(Vacation v, String in15,Date datee){
        Storage storage=Storage.getInstance();
        System.out.println("service running");
        vacationDao.update(v, in15,datee);

    }
    public static void deleteVacation(Vacation vd){
        Storage storage=Storage.getInstance();

        vacationDao.delete(vd);

    }
    public static Set<Vacation> getVacations(String id) {
        Set<Vacation> vacas = vacationDao.get(id);

        return vacas;
    }

    public static Boolean validateAddVacation(Vacation v){
        if(Storage.getInstance().getVacations().contains(v)){
            System.out.println("personnel is alredy exist");
            return false;
        }
        return true;
    }

//    public static Boolean isValidDateFormat(String d){
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        sdf.setLenient(false); // Set to strict parsing
//        try {
//            Date date = sdf.parse(d);
//            if (date != null && sdf.format(date).equals(d)) {
//                return true; // Input date matches the specified format
//            } else {
//                return false; // Input date doesn't match the specified format
//            }
//        } catch (ParseException e) {
//            return false; // Input date couldn't be parsed with the specified format
//        }
//    }


}
