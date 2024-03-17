package State2.service;


import Dao.VacationDao;

import State2.entity.Personnel;
import State2.entity.Vacation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class VacationService {
    static VacationDao vacationDao = new VacationDao();
    public static boolean addVacation(Vacation v){
        try {

            vacationDao.save(v);
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }
    }

    public static Set<Vacation> showVacations(String ncCode){
        return vacationDao.get(ncCode);

    }
    public static Set<Vacation> getAll(){
        return vacationDao.getAll();

    }

    public static void updateVacation(Vacation v, String in15,Date datee,Date datee1){
//        Storage storage=Storage.getInstance();
        System.out.println("service running");
        vacationDao.update(v, in15,datee,datee1);

    }
    public static void deleteVacation(Vacation vd,Date s){
        vacationDao.delete(vd,s);

    }
    public static Set<Vacation> getVacations(String id) {
        Set<Vacation> vacas = vacationDao.get(id);

        return vacas;
    }

    public static Boolean validateAddVacation(Vacation v){
        if(v==null){
            System.out.println("vacation is null");
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
