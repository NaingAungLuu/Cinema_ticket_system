package cinema_ticket_system.Controllers;

import cinema_ticket_system.DataObjects.Movie;
import com.mysql.cj.protocol.Resultset;
import cinema_ticket_system.DataObjects.Movie;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.Vector;
import java.util.Properties;


public class DataManager {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/cinema";
    static final String USER = "root";
    static final String PASSWORD = "password";
    private static Connection conn = null;
    private static Statement stm = null;

    public static final Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public static void initiateConnection() throws ClassNotFoundException , SQLException
    {
        conn = MainClass.connection;
        System.out.println("Getting Connection.....");
        stm = conn.createStatement();
        System.out.println("Creating Statement");
    }

    public static Object executeQuery(String query, boolean isQuery) throws Exception
    {
        if(isQuery)
        {
            return stm.executeQuery(query);
        }
        else
        {
            return stm.execute(query);
        }
    }

    public static String[] getLoginInfo(String username)
    {
        String sql = "SELECT userName , password , userType FROM tblUsers WHERE"
                + " userName = '" + username + "'" ;
        String[] result = new String[3];
        try{
            ResultSet rs = (ResultSet) executeQuery(sql , true);
            while(rs.next())
            {
                result[0] = rs.getString("userName");
                result[1] = rs.getString("password");
                result[2] = rs.getString("userType");
                System.out.println(result[0]);
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }
        return result;
    }

    public static void refreshUserData(DefaultTableModel model)
    {
        ResultSet rs = null;
        model.fireTableDataChanged();
        for(int i = model.getRowCount()-1 ; i >= 0; i--)
            {
                model.removeRow(i);
            }
            String sql = "SELECT * FROM tblUsers";
            try {
                rs = (ResultSet) executeQuery(sql, true);
                int i = 0;
                while (rs.next()) {
                    Vector row;
                    row = new Vector(2);
                    row.add(rs.getString("userName"));
                    row.add(rs.getString("userID"));
                    model.addRow(row);
                    System.out.println("Current row count " + i);
                    i++;
                }
            }catch (Exception error){System.out.println("Resultset Error" + error);}

            model.fireTableDataChanged();
            System.out.println("Error free!!");

    }

    public static boolean addUser(String userName ,String password , String id , String userType)throws Exception
    {
        String sql = "INSERT INTO `Cinema`.`tblUsers` (`userID` , `userName` , `password` , `userType`) VALUES ('"
                + id + "' , '" + userName + "' , '" + password + "' , '" + userType + "');";
        return (Boolean) executeQuery(sql , false);
    }

    public static boolean deleteUser(int idToDelete) throws Exception
    {
        String sql = "DELETE FROM `Cinema`.`tblUsers` WHERE (`userID` = '" +  idToDelete + "');";
        boolean result = (Boolean) executeQuery(sql , false);
        System.out.println("deletion success");
        return result;

    }


    public static void addMovie(Movie movie) {
        String sql = "INSERT INTO `cinema`.`tblMovie` (`movieName`, `categoryID`, `theatreNo`, `movieType`) VALUES ('"
                    + movie.getMovieName() + "' , '" + movie.getCategory() + "' , '" + movie.getTheatreNo()
                    + "' , '" + movie.getMovieType() + "')";
        try
        {
            executeQuery(sql , false);
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
