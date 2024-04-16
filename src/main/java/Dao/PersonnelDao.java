package Dao;

import State2.db.Database;

import State2.entity.Personnel;
import State2.entity.Vacation;

import java.sql.*;
import java.util.*;


public class PersonnelDao{


    public Personnel get(String nc) {
        String sqlQuery = "SELECT * FROM PERSONNEL";

        try (Connection conn = Database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                if (rs.getString("NATIONALCODE").equals(nc)) {
                    String NATIONALCODE = rs.getString("NATIONALCODE");
                    String FIRSTNAME = rs.getString("FIRSTNAME");
                    String LASTNAME = rs.getString("LASTNAME");
                    String CITYNAME = rs.getString("CITYNAME");

                    System.out.println("personnel found");
                    Personnel personnelFound = new Personnel(NATIONALCODE, FIRSTNAME, LASTNAME, CITYNAME);
                    return personnelFound;
                }

            }
            rs.close();
            stmt.close();
            System.out.println("Not Found");

            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Set<Personnel> getAll() {
        String sql="SELECT * FROM PERSONNEL";
        Set<Personnel> Personnels=new HashSet<>();
        try (Connection conn = Database.getConnection()){
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String NATIONALCODE = result.getString("NATIONALCODE");
                String FIRSTNAME = result.getString("FIRSTNAME");
                String LASTNAME = result.getString("LASTNAME");
                String CITYNAME = result.getString("CITYNAME");

                Personnel personnel=new Personnel(NATIONALCODE,FIRSTNAME,LASTNAME,CITYNAME);
                Personnels.add(personnel);
            }
            result.close();
            statement.close();



        } catch (Exception e) {
            e.printStackTrace();
        }
        return Personnels;

    }


    public void save(Personnel p) {
        String sql = "INSERT INTO PERSONNEL (NATIONALCODE, FIRSTNAME, LASTNAME, CITYNAME) VALUES (?,?,?,?)";

        try (Connection conn = Database.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, p.getNationalCode());
            statement.setString(2, p.getFirstName());
            statement.setString(3, p.getLastName());
            statement.setString(4, p.getCityName());
            statement.executeUpdate();
            System.out.println("Personnel created.");

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void update(Personnel p, String[] params) {

        String sql = "UPDATE PERSONNEL SET NATIONALCODE = ?, FIRSTNAME = ?, LASTNAME = ? , CITYNAME = ? WHERE NATIONALCODE = ?";
        try (Connection conn = Database.getConnection()){

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, params[0]);
            statement.setString(2, params[1]);
            statement.setString(3, params[2]);
            statement.setString(4, params[3]);
            statement.setString(5, p.getNationalCode());
            statement.executeUpdate();
            System.out.println("table updated.");

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void delete(Personnel pd) {

        String sql = "DELETE FROM PERSONNEL WHERE NATIONALCODE = ?";
        try (Connection conn = Database.getConnection()) {

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, pd.getNationalCode());
            statement.executeUpdate();
            System.out.println("Record from table deleted.");

            statement.close();

        } catch (Exception e) {

            e.printStackTrace();
        }




    }

}
