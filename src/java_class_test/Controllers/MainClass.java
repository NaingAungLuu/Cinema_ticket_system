package java_class_test.Controllers;

import java.awt.*;

import javax.swing.*;
import java.sql.Connection;

public class MainClass {

    private static String UserName = "Default";
    private static String UserType = "DEFAULT";
    public static final String ADMIN = "ADMIN";
    public static final String STAFF = "STAFF";
    public static Connection connection;

    public static void main(String[] args) throws Exception
    {
        GUI.initiateLoginWindow();
        GUI.show(GUI.LOGIN , null);
        connection = DataManager.getConnection();
        DataManager.initiateConnection();

    }

    public static void setUser(String username ,String Usertype)
    {
        UserName = username;
        UserType = Usertype;
    }
    public static String getUserName()
    {
        return UserName;
    }
    public static String getUserType()
    {
        return UserType;
    }

}
