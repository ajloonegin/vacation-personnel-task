package Dao;

import State2.db.Database;

import State2.entity.Personnel;
import State2.entity.Vacation;

import java.sql.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class VacationDao {

    public  Set<Vacation> get(String nc) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String sql = "SELECT NATIONALCODE,DATE FROM VACATION WHERE NATIONALCODE = ?";
        Set<Vacation> vacationsOfPersonnel=new HashSet<>();
        try {
            conn = Database.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, nc);
            result = statement.executeQuery();
            if (result.next()) {
                String NATIONALCODE = result.getString("NATIONALCODE");
                java.sql.Date DATE = result.getDate("DATE");

                Vacation vacationFound=new Vacation(NATIONALCODE,DATE);
                vacationsOfPersonnel.add(vacationFound);


            }
            result.close();
            statement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                result.close();
                statement.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
        return vacationsOfPersonnel;


//        Set<Vacation> vacationsOfPersonnel=new HashSet<>();
//        String sqlQuery="SELECT * FROM VACATION;
//        Statement stmt= null;
//        try {
//
//            stmt = conn.createStatement();
//            ResultSet rs=stmt.executeQuery(sqlQuery);
//            while(rs.next()){
//
//                if(rs.getString("NATIONALCODE").equals(nc)){
//                    String NATIONALCODE=rs.getString("NATIONALCODE");
//                    String DATE=rs.getString("DATE");
//
//                    System.out.println("vacation found");
//                    Vacation vacationFound=new Vacation(NATIONALCODE,DATE);
//                    vacationsOfPersonnel.add(vacationFound);
//                    return vacationsOfPersonnel;
//                }
//
//            }
//            return null;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


//        Set<Vacation> vacationsOfPersonnel=new HashSet<>();
//        for(Vacation v: Storage.getInstance().getVacations()){
//            if(v.getNationalCode().equals(nc)){
//                vacationsOfPersonnel.add(v);
//
//            }
//        }
//        return vacationsOfPersonnel;
    }


    public Set<Vacation> getAll() {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String sql = "SELECT * FROM VACATION";
        Set<Vacation> vacationsOfPersonnel=new HashSet<>();
        try {
            conn = Database.getConnection();
            statement = conn.prepareStatement(sql);
            result = statement.executeQuery();
            if (result.next()) {
                String NATIONALCODE = result.getString("NATIONALCODE");
                java.sql.Date DATE = result.getDate("DATE");

                Vacation vacation=new Vacation(NATIONALCODE,DATE);
                vacationsOfPersonnel.add(vacation);


            }
            result.close();
            statement.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                result.close();
                statement.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }

        return vacationsOfPersonnel;
    }


    public void save(Vacation v) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String sql = "INSERT INTO VACATION (NATIONALCODE, DATE) VALUES (?,?)";

        try {
            conn = Database.getConnection();

            statement = conn.prepareStatement(sql);
            statement.setString(1, v.getNationalCode());
            statement.setDate(2, (java.sql.Date) v.getDate());

            statement.executeUpdate();
            System.out.println("Personnel created.");
            result.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                result.close();
                statement.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
//        Storage.getInstance().getVacations().add(v);
//        System.out.println("vacation added");
//        System.out.println(Storage.getInstance().getVacations());
    }

    public void update(Vacation v, String in15,Date datee) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String sql = "UPDATE PERSONNEL SET NATIONALCODE = ?, DATE = ? WHERE NATIONALCODE = ?";
        try {
            conn = Database.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, in15);
            statement.setDate(2, (java.sql.Date) datee);
            statement.setString(3, v.getNationalCode());
            statement.executeUpdate();
            System.out.println("table updated.");
            result.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                result.close();
                statement.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
//        v.setNationalCode(Objects.requireNonNull(
//                in15, "firstName cannot be null"));
//        v.setDate(Objects.requireNonNull(
//                datee, "date cannot be null"));
//
//        System.out.println("vacation is updated");
//        System.out.println("new vacation list"+Storage.getInstance().getVacations());
    }


    public void delete(Vacation vd) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            String sql = "DELETE FROM VACATION WHERE NATIONALCODE = ?";
            conn = Database.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, vd.getNationalCode());
            statement.executeUpdate();
            System.out.println("Record in table deleted.");
            result.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                result.close();
                statement.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }




//        Storage.getInstance().getVacations().remove(vd);
//        System.out.println("vacation deleted");
//        System.out.println("new vacation list:"+Storage.getInstance().getVacations());
    }


}
