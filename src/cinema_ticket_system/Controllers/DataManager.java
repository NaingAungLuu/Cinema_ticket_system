package cinema_ticket_system.Controllers;

import cinema_ticket_system.DataObjects.Movie;
import cinema_ticket_system.DataObjects.MovieCategory;
import cinema_ticket_system.DataObjects.User;
import cinema_ticket_system.Utils.Utils;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;


public abstract class DataManager {

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
                    i++;
                }
            }catch (Exception error){System.out.println("Resultset Error" + error);}

            model.fireTableDataChanged();

    }

    public static void refreshMovieData(DefaultTableModel model)
    {
        ResultSet rs = null;
        for(int i = model.getRowCount()-1 ; i>= 0 ; i--)
        {
            model.removeRow(i);
        }
        String query = "SELECT categoryName ,movieName , theatreNo , showTimes , movieType FROM `cinema`.`tblcategory` , `cinema`.`tblmovie` WHERE\n" +
                "`tblmovie`.`categoryID` = `tblcategory`.`categoryID`";
        try {
            rs = (ResultSet) executeQuery(query , true);
            while(rs.next())
            {
                Vector row;
                row = new Vector(4);
                row.add(rs.getString("movieName"));
                row.add(rs.getString("theatreNo"));
                row.add(rs.getString("showTimes"));
                row.add(rs.getString("movieType"));
                row.add(rs.getString("categoryName"));
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.fireTableDataChanged();
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

        String query = "INSERT INTO `cinema`.`tblMovie` SET movieName = '" + movie.getMovieName()
                        + "' , categoryID = (SELECT categoryID FROM" +
                        " `cinema`.`tblCategory` WHERE categoryName = '"+ movie.getCategoryName()
                        + "') , theatreNo = " +  movie.getTheatreNo()
                        + " , movieType = '" + movie.getMovieType()
                        +"' , showTimes = '"
                        + movie.getShowTime() + "'";

        try
        {
            executeQuery(query , false);
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void updateMovie(Movie movie)
    {
        String query = "UPDATE `cinema`.`tblMovie` SET `movieName` = '"+ movie.getMovieName()
                        + "' , `categoryID` = (SELECT categoryID FROM `cinema`.`tblCategory` WHERE `categoryName` = '" + movie.getCategoryName()
                        + "') , `theatreNo` = '" + movie.getTheatreNo()
                        + "' , `movieType` = '" + movie.getMovieType()
                        + "' , `showTimes` = '" + movie.getShowTime()
                        + "' WHERE (`movieID` = '" + movie.getMovieId() + "');";

        try {
            executeQuery(query , false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int getMovieId(String movieName)
    {
        String query = "SELECT movieId FROM `cinema`.`tblMovie` WHERE `movieName` = '" + Utils.cleanString(movieName) + "' ;";
        System.out.println(query);
        int result = 0;
        try {
            ResultSet rs = (ResultSet) executeQuery(query , true);
            while(rs.next())
            {
                result = rs.getInt("movieID");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean deleteMovie(String movieName) throws Exception {

        String sql = "DELETE FROM `cinema`.`tblMovie` WHERE (`movieName` = '" + movieName + "');";
        boolean result = (Boolean) executeQuery(sql , false);
        System.out.println("Deleted movie " + movieName);
        return result;
    }

    public static void updateUser(User user) {
        String sql = "UPDATE `cinema`.`tblusers` SET `userID` = " + user.getUserID()
                                                +" ,`userName` = '" + user.getUserName()
                                                +"' ,`password` = '" + user.getPassword()
                                                +"' ,`userType` = '" + user.getUserType() +"' WHERE (`userID3` = " + user.getUserID()+ ")";
        System.out.println(user.getUserID());
        try {
            executeQuery(sql, false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static User getUser(int userID)
    {

        String sql = "SELECT userID , userName , password , userType FROM tblUsers WHERE"
                + " userID = '" + userID + "'" ;
        String[] result = new String[4];
        try{
            ResultSet rs = (ResultSet) executeQuery(sql , true);
            while(rs.next())
            {
                result[0] = rs.getString("userID");
                result[1] = rs.getString("userName");
                result[2] = rs.getString("password");
                result[3] = rs.getString("userType");
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }
        return new User(Integer.parseInt(result[0]) , result[1] , result[2] , result[3]);
    }

    public static ArrayList<MovieCategory> getCategories()
    {
        ArrayList<MovieCategory> categories = new ArrayList<>();
        String query = "SELECT * FROM `cinema`.`tblCategory`";
        try {
            ResultSet rs = (ResultSet) executeQuery(query , true);
            int i = 0;
            while(rs.next())
            {
                String categoryName = rs.getString("categoryName");
                int categoryID = rs.getInt("categoryID");
                MovieCategory movieCategory = new MovieCategory(categoryID , categoryName);
                categories.add(i , movieCategory);
                System.out.println(categories.get(i).getCategoryName());
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i = 0 ; i < categories.size() ; i++)
        {
            System.out.println(categories.get(i).getCategoryName() + categories.get(i).getCategoryID());
        }
        return categories;
    }

}
