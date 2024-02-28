//package State2.db;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//public class Database {
////    private static final JDBC_URL="jdbc:h2:~/test";
////    private static final JDBC_DRIVER="org.h2.Driver";
////    private static final USERNAME="Negin";
////    private static final PASS="havij";
//    public static Connection con=null;
//
//    static{
//        try {
//            Class.forName("org.h2.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new ExceptionInInitializerError(e);
//        }
//    }
//
//    public static Connection getConnection() throws SQLException, ClassNotFoundException{
//        if(con==null || con.isClosed()){
//            System.out.println("Connecting to database...");
//            con=DriverManager.getConnection("jdbc:h2:~/test","Negin","havij");
//        }
//        return con;
//    }
//    public void closeConnection() throws SQLException{
//        con.close();
//        System.out.println("Connection Close");
//    }
//
//}
