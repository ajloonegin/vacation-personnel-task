package State2.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    private static final String JDBC_URL="jdbc:h2:tcp://localhost/~/test";
    private static final String JDBC_DRIVER="org.h2.Driver";
    private static final String USERNAME="Negin";
    private static final String PASS="havij";
    public static Connection con=null;

    static{
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        if(con==null || con.isClosed()){
            System.out.println("Connecting to database...");
            con=DriverManager.getConnection(JDBC_URL,USERNAME,PASS);
        }
        return con;
    }
    public void closeConnection() throws SQLException{
        con.close();
        System.out.println("Connection Close");
    }

}
