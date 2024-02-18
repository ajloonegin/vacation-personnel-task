package State2;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Run {
    public static void main(String[] args) {

        System.out.println("pls enter national code:");
        Scanner scanner=new Scanner(System.in);
        String input=scanner.next();


        try {
            Connection conn = Database.getConnection();
            for(int i=1;i<=5;i++){
                System.out.println(i+" ");
                Thread.sleep(1000);
            }
            String sqlQuery1 = "SELECT PERSONNELID FROM PERSONNEL WHERE NATIONALCODE =input";
            Statement stmt1 = conn.createStatement();
            ResultSet rs1 = stmt1.executeQuery(sqlQuery1);
            while (rs1.next()) {
                int PERSONNELID = rs1.getInt("PERSONNELID");
                System.out.println("id: " + PERSONNELID);
            }
            String sqlQuery2 = "SELECT DATE FROM VACATION WHERE id = PERSONNELID";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt1.executeQuery(sqlQuery2);
            while (rs2.next()) {
                Date DATE = rs2.getDate("DATE");
                System.out.println("id: " + DATE);
            }
            new Database().closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        void timer() {
//            for(int i=1;i<=5;i++){
//                System.out.println(i+" ");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }






    }
}
