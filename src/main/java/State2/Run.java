package State2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.Date;

public class Run {
    public static void main(String[] args) {

        System.out.println("pls enter national code:");
        Scanner scanner=new Scanner(System.in);
        String input=scanner.next();


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username",
                    "password");
            System.out.println("Connection established.");

            String sql = "SELECT PERSONNELID FROM PERSONNEL WHERE NATIONALCODE =input";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, 1);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int PERSONNELID = result.getInt("PERSONNELID");
                System.out.println("id: " + PERSONNELID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String sql = "SELECT DATE FROM VACATION WHERE id = PERSONNELID";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, 1);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Date DATE = result.getDate("DATE");

                System.out.println("DATE: " + DATE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
