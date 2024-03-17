package Dao;

import State2.db.Database;

import State2.entity.Personnel;
import State2.entity.Vacation;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class VacationDao {

    public  Set<Vacation> get(String nc) {
        Set<Vacation> vacationsOfPersonnel=new HashSet<>();
        String sql = "SELECT NATIONALCODE,DATE FROM VACATION WHERE NATIONALCODE = ?";


        try (Connection conn = Database.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nc);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String NATIONALCODE = result.getString("NATIONALCODE");
                java.sql.Date DATE = result.getDate("DATE");

                Vacation vacationFound=new Vacation(NATIONALCODE,DATE);
                vacationsOfPersonnel.add(vacationFound);
            }
            result.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return vacationsOfPersonnel;
    }


    public Set<Vacation> getAll() {
        Set<Vacation> vacationsOfPersonnel=new HashSet<>();
        String sql = "SELECT * FROM VACATION";

        try (Connection conn = Database.getConnection()){
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                String NATIONALCODE = result.getString("NATIONALCODE");
                java.sql.Date DATE = result.getDate("DATE");

                Vacation vacation=new Vacation(NATIONALCODE,DATE);
                vacationsOfPersonnel.add(vacation);


            }
            result.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vacationsOfPersonnel;

    }


    public void save(Vacation v) {

        String sql = "INSERT INTO VACATION (NATIONALCODE, DATE) VALUES (?,?)";

        try (Connection conn = Database.getConnection()){

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, v.getNationalCode());
            statement.setDate(2, new java.sql.Date(v.getDate().getTime()));

            statement.executeUpdate();
            System.out.println("Personnel created.");
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
;
    }

    public void update(Vacation v, String in15,Date datee,Date datee1) {

        String sql = "UPDATE VACATION SET NATIONALCODE = ?, DATE = ? WHERE NATIONALCODE = ? AND DATE = ?";
        try (Connection conn = Database.getConnection()){

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, in15);
            statement.setDate(2, new java.sql.Date(datee.getTime()));
            statement.setString(3, v.getNationalCode());
            statement.setDate(4, new java.sql.Date(datee1.getTime()));
            statement.executeUpdate();
            System.out.println("table updated.");

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void delete(Vacation vd,Date s) {
        String sql = "DELETE FROM VACATION WHERE NATIONALCODE = ? AND DATE = ?";

        try (Connection conn = Database.getConnection()){


            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, vd.getNationalCode());
            statement.setDate(2, (new java.sql.Date(s.getTime())));
            statement.executeUpdate();
            System.out.println("Record in table deleted.");

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
