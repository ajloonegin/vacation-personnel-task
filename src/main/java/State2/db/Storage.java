//package State2.db;
//
//import State2.entity.Personnel;
//import State2.entity.Vacation;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class Storage {
//
//    private static Storage storage=new Storage();
//    private Set<Personnel> personnels;
//    private Set<Vacation> vacations;
//    {
//        this.personnels= new HashSet<>();
//        this.vacations= new HashSet<>();
//        personnels.add(new Personnel("0610272616","Ali","gholami","Arak"));
//        personnels.add(new Personnel("0610272613","hossein","rahimi","karaj"));
//        personnels.add(new Personnel("0610272352","sadaf","alizadeh","bushehr"));
//        personnels.add(new Personnel("0610223542","akbar","sadeghi","tehran"));
//
//
//        try {
//            vacations.add(new Vacation("0610272616",new SimpleDateFormat("dd/MM/yyyy").parse("06/07/2000")));
//            vacations.add(new Vacation("0610223542",new SimpleDateFormat("dd/MM/yyyy").parse("07/05/2020")));
//            vacations.add(new Vacation("0610272616",new SimpleDateFormat("dd/MM/yyyy").parse("09/12/2018")));
//            vacations.add(new Vacation("0610223542",new SimpleDateFormat("dd/MM/yyyy").parse("30/09/2011")));
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    private Storage() {
//
//    }
//
//    public Set<Personnel> getPersonnels() {
//        return personnels;
//    }
//
//    public Set<Vacation> getVacations() {
//        return vacations;
//    }
//    public static Storage getInstance(){
//        return storage;
//    }
//
//    @Override
//    public String toString() {
//        return "Storage:"+"{"+personnels+","+vacations+"}";
//    }
//
////    public boolean doneAddPersonnel(){
////
////
////    }
////    public boolean doneAddVacation(){
////
////    }
//
//
//
//}

