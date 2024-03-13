package State2;


import Dao.PersonnelDao;
import State2.db.Database;
import State2.entity.Personnel;
import State2.entity.Vacation;
import State2.service.PersonnelService;
import State2.service.VacationService;


import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;




public class View {
    public static void main(String[] args) {

        boolean isNewOp;

        do {

            System.out.println("pls Select operation:");
            //add personnel to db
            System.out.println("1: Insert personnel");
            //read personnel
            System.out.println("2: Find personnel");
            //add vaation to db
            System.out.println("3: Entry vacation for a personnel");
            //read vaction
            System.out.println("4: Show vacation of personnel");
            //update personnel list
            System.out.println("5: Update a record of personnel");
            System.out.println("6: Update a record of vacation");
            System.out.println("7 :delete list of Personnels");
            System.out.println("8 :delete list of vacations");
            System.out.println("9: Exit");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println("enter national code");
                    Scanner s1 = new Scanner(System.in);
                    String nc = s1.nextLine();
                    if(PersonnelService.validateNationalCode(nc)){
                        System.out.println("enter first name");
                        Scanner s2 = new Scanner(System.in);
                        String fn = s2.nextLine();
                        System.out.println("enter last name");
                        Scanner s3 = new Scanner(System.in);
                        String ln = s3.nextLine();
                        System.out.println("enter city name");
                        Scanner s4 = new Scanner(System.in);
                        String cn = s4.nextLine();
                        Personnel p12=new Personnel(nc, fn, ln, cn);
                        if(PersonnelService.validateAddPersonnel(p12)){
                            PersonnelService.addPersonnel(p12);
                            System.out.println("Pesrsonnel added");
                            PersonnelService.getAll();
                        }
                    }
                    break;
                case 2:
                    System.out.println("enter national code of personnel");
                    Scanner s5 = new Scanner(System.in);
                    String nc5 = s5.nextLine();
                    if(PersonnelService.validateNationalCode(nc5)){
                        Personnel pf=PersonnelService.searchPersonnel(nc5);
                        System.out.println(pf);
                    }
                    break;
                case 3:
                    System.out.println("enter national code of personnel");
                    Scanner s6 = new Scanner(System.in);
                    String nc6 = s6.nextLine();
                    if(PersonnelService.validateNationalCode(nc6)){
                        System.out.println("enter date of vacation with dd/MM/yyyy format");
                        Scanner s7 = new Scanner(System.in);
                        String dateStr = s7.next();
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                        Date date = null;
                        try {
                            date = sdf1.parse(dateStr);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        Vacation vv=new Vacation(nc6,date);
                        if(VacationService.validateAddVacation(vv)){
                            VacationService.addVacation(vv);
                        }

                    }
                    break;
                case 4:
                    System.out.println("insert national code of personnel:");
                    Scanner s8 = new Scanner(System.in);
                    String nc8 = s8.nextLine();
                    if(PersonnelService.validateNationalCode(nc8)){
                        Set<Vacation> res=VacationService.showVacations(nc8);
                    }

                    break;
                case 5:
                    System.out.println("Insert national code of personnel:");
                    Scanner s9 = new Scanner(System.in);
                    String nc9 = s9.nextLine();
                    if(PersonnelService.validateNationalCode(nc9)){
                        System.out.println("Enter new National code");
                        Scanner s10 = new Scanner(System.in);
                        String in1 = s10.nextLine();
                        if(PersonnelService.validateNationalCode(in1)){
                            System.out.println("Enter new firstName");
                            Scanner s11 = new Scanner(System.in);
                            String in2 = s11.nextLine();
                            System.out.println(" Enter new lastName");
                            Scanner s12 = new Scanner(System.in);
                            String in3 = s12.nextLine();
                            System.out.println(" Enter new cityName");
                            Scanner s13 = new Scanner(System.in);
                            String in4 = s13.nextLine();
                            Personnel pu= PersonnelService.getPersonnel(nc9);
                            PersonnelService.updatePersonnel(pu,new String[]{in1,in2,in3, in4});
                        }

                    }

                    break;
                case 6:
                    System.out.println("Insert national code of vacation:");
                    Scanner s14 = new Scanner(System.in);
                    String nc14 = s14.nextLine();
                    if(PersonnelService.validateNationalCode(nc14)) {
                        System.out.println("Enter new National code");
                        Scanner s15 = new Scanner(System.in);
                        String in15 = s15.nextLine();
                        if (PersonnelService.validateNationalCode(in15)) {
                            System.out.println("Enter old Date");
                            Scanner s16 = new Scanner(System.in);
                            String dateStrin = s16.nextLine();

                            SimpleDateFormat sdf12 = new SimpleDateFormat("dd/MM/yyyy");
                            Date datee1;
                            try {
                                datee1 = sdf12.parse(dateStrin);
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("Enter new Date");
                            Scanner s26 = new Scanner(System.in);
                            String dateStri = s26.nextLine();
                            SimpleDateFormat sdf11 = new SimpleDateFormat("dd/MM/yyyy");
                            Date datee2;
                            try {
                                datee2 = sdf11.parse(dateStri);
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                            Set<Vacation> vu = VacationService.getVacations(nc14);
                            for (Vacation v : vu) {
                                System.out.println(v.getDate());
                                System.out.println(datee1);
                                if (v.getDate().equals(datee1)) {
                                    VacationService.updateVacation(v, in15, datee2);

                                }else{
                                    System.out.println("nashod");
                                }
                            }

                        }
                    }
                    break;
                case 7:
                    System.out.println("Insert national code of Personnel:");
                    Scanner s17 = new Scanner(System.in);
                    String nc17 = s17.nextLine();
                    if(PersonnelService.validateNationalCode(nc17)){
                        Personnel pd= PersonnelService.getPersonnel(nc17);
                        PersonnelService.deletePersonnel(pd);
                    }

                    break;
                case 8:
                    System.out.println("Insert national code of Vacation:");
                    Scanner s18 = new Scanner(System.in);
                    String nc18 = s18.nextLine();
                    System.out.println("Enter Date of vacation");
                    Scanner s27 = new Scanner(System.in);
                    String dateString = s27.next();
                    SimpleDateFormat sdf13 = new SimpleDateFormat("dd/MM/yyyy");
                    Date datee3 = null;
                    try {
                        datee3 = sdf13.parse(dateString);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    if(PersonnelService.validateNationalCode(nc18)){
                        Set<Vacation> vd= VacationService.getVacations(nc18);
                        for (Vacation v : vd) {
                            if (v.getDate().equals(datee3)) {
                                VacationService.deleteVacation(v);

                            }
                            else {
                                System.out.println("this record doesn't exist");
                            }
                        }


                    }
                    break;
                case 9:
                    isNewOp=false;
                    break;
                default:
                    System.out.println("invalid number");

            }

            System.out.println("run program again?(true/false):");
            Scanner w=new Scanner(System.in);
            Boolean answer=w.nextBoolean();
            isNewOp=PersonnelService.runProgram(answer);


        } while (isNewOp == true);


    }

}



