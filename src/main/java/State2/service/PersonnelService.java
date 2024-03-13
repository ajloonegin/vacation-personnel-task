package State2.service;

import Dao.PersonnelDao;

import State2.entity.Personnel;

import java.util.*;



public class PersonnelService {

    static PersonnelDao personnelDao = new PersonnelDao();
    //canedit
    //cansave
    //validation
    //nationalcode format checker
    //canread-is a personnel?


//add personnel to storage
    public static boolean addPersonnel(Personnel p){
        try {
            personnelDao.save(p);
            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }
    }


    //search personnel of storage
    public static Personnel searchPersonnel(String ncCode){
        return personnelDao.get(ncCode);

    }
    public static Set<Personnel> getAll(){
        return personnelDao.getAll();

    }
    public static void updatePersonnel(Personnel p, String[] params){

        personnelDao.update(p, params);

    }
    public static void deletePersonnel(Personnel pd){
//        Storage storage=Storage.getInstance();

        personnelDao.delete(pd);

    }
    public static Personnel getPersonnel(String id) {
        Personnel pers = personnelDao.get(id);

        return pers;
    }



    public static boolean validateAddPersonnel(Personnel p){
       if(p==null){
            System.out.println("p is null!");
            return false;
       }
       return true;

    }

    public static boolean validateNationalCode(String nc){

        int check = Character.getNumericValue(nc.charAt(9));
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(nc.charAt(i)) * (10 - i);
        }
        int remainder = sum % 11;
        if(nc==null || !nc.matches("^\\d{10}$")) {
            System.out.println("National code is not valid");
            return false;
        }else if ((remainder < 2 && check == remainder) || (remainder >= 2 && check + remainder == 11)){

            return true ;
        }else{
            System.out.println("National code is not valid");
            return false;
        }


    }
    public static boolean runProgram(Boolean ans){

        if(ans.equals(true)){
            return true;
        }else if(ans.equals(false)){
            return false;
        }
        else{
            System.out.println("input isn't true or false ");
            return false;
        }

    }










}
