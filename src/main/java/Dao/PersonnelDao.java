package Dao;

import State2.db.Database;

import State2.entity.Personnel;
import State2.entity.Vacation;

import java.sql.*;
import java.util.*;


public class PersonnelDao{


    public Personnel get(String nc) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sqlQuery="SELECT * FROM PERSONNEL";

        try {
            conn = Database.getConnection();
            stmt = conn.createStatement();
            rs=stmt.executeQuery(sqlQuery);
            while(rs.next()){

                if(rs.getString("NATIONALCODE").equals(nc)){
                    String NATIONALCODE=rs.getString("NATIONALCODE");
                    String FIRSTNAME=rs.getString("FIRSTNAME");
                    String LASTNAME=rs.getString("LASTNAME");
                    String CITYNAME=rs.getString("CITYNAME");

                    System.out.println("personnel found");
                    Personnel personnelFound=new Personnel(NATIONALCODE,FIRSTNAME,LASTNAME,CITYNAME);
                    return personnelFound;
                }

            }
            rs.close();
            stmt.close();
            conn.close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }

//        for(Personnel p: Storage.getInstance().getPersonnels()){
//            if(p.getNationalCode().equals(nc)){
//                System.out.println("personnel found");
//                return p;
//            }
//        }
//        return null;
    }


    public Set<Personnel> getAll() {
        Connection conn = null;
        Statement statement = null;
        ResultSet result = null;
        String sql="SELECT * FROM PERSONNEL";
        Set<Personnel> Personnels=new HashSet<>();
        try {
            conn = Database.getConnection();
            statement = conn.prepareStatement(sql);
            result = statement.executeQuery(sql);
            if (result.next()) {
                String NATIONALCODE = result.getString("NATIONALCODE");
                String FIRSTNAME = result.getString("FIRSTNAME");
                String LASTNAME = result.getString("LASTNAME");
                String CITYNAME = result.getString("CITYNAME");

                Personnel personnel=new Personnel(NATIONALCODE,FIRSTNAME,LASTNAME,CITYNAME);
                Personnels.add(personnel);


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

        return Personnels;


    }


    public void save(Personnel p) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String sql="INSERT INTO PERSONNEL (NATIONALCODE, FIRSTNAME, LASTNAME, CITYNAME) VALUES (?,?,?,?)";

        try {
            conn = Database.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, p.getNationalCode());
            statement.setString(2, p.getFirstName());
            statement.setString(3, p.getLastName());
            statement.setString(4, p.getCityName());
            statement.setInt(3, 123);
            statement.executeUpdate();
            System.out.println("Personnel created.");

            result.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
                statement.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }

//        Storage.getInstance().getPersonnels().add();


    }



    public void update(Personnel p, String[] params) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String sql = "UPDATE PERSONNEL SET NATIONALCODE = ?, FIRSTNAME = ?, LASTNAME = ? , CITYNAME = ? WHERE NATIONALCODE = ?";
        try {
            conn = Database.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, params[0]);
            statement.setString(2, params[1]);
            statement.setString(3, params[2]);
            statement.setString(4, params[3]);
            statement.setString(5, p.getNationalCode());
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






//
//        p.setNationalCode(Objects.requireNonNull(
//                    params[0], "firstName cannot be null"));
//        p.setFirstName(Objects.requireNonNull(
//                    params[1], "firstName cannot be null"));
//        p.setLastName(Objects.requireNonNull(
//                    params[2], "lastName cannot be null"));
//        p.setCityName(Objects.requireNonNull(
//                    params[3], "cityName cannot be null"));
//
//        System.out.println("Personnel updated");
//        System.out.println("new list of Personnel:"+Storage.getInstance().getPersonnels());


    }


    public void delete(Personnel pd) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String sql = "DELETE FROM PERSONNEL WHERE NATIONALCODE = ?";
        try {
            conn = Database.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, pd.getNationalCode());
            statement.executeUpdate();
            System.out.println("Record from table deleted.");
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



//
//        Storage.getInstance().getPersonnels().remove(pd);
//        System.out.println("Personnel deleted");
//        System.out.println("new personnel list:"+Storage.getInstance().getPersonnels());
    }




}
