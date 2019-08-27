package cinema_ticket_system.Controllers;


import cinema_ticket_system.DataObjects.Movie;
import cinema_ticket_system.GUIs.Admin.Admin_Manage_Users;
import cinema_ticket_system.GUIs.Login_Form;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;

import static cinema_ticket_system.Controllers.GUI.show;
import static cinema_ticket_system.Controllers.GUI.ADMIN_MANAGE_USERS;
import static cinema_ticket_system.Controllers.GUI.show;

public class UserInteractions{



    public static void LogOut() throws UnsupportedLookAndFeelException {
        MainClass.setUser("DEFAULT" , "DEFAULT");
        GUI.initiateLoginWindow();
        show(GUI.LOGIN , null);
        Login_Form.clearTextFields();
    }

    public static void Login(String enteredusername , String enteredPassword) throws Exception {
        String username = "";
        String password = "";
        String userType = "";
        String[] userInfo ;

        try{
            System.out.println("Attemptin Login");
            userInfo = DataManager.getLoginInfo(enteredusername);
            username = userInfo[0];
            password = userInfo[1];
            userType = userInfo[2];
            System.out.println(username);
        }
        catch (Exception e) {

            System.out.println(e);
        }

        //If the user exists in the system....
        if(username != null)
        {
            if(enteredPassword.equals(password))
            {
                //Sending user information to the MainClass
                System.out.println("Logged in as " + username + " (" + userType + ")" +
                        "");
                MainClass.setUser(username , userType);
                GUI.initiateUserWindow();

                if(userType.equals(MainClass.ADMIN))
                {
                    GUI.setupSidePanel(GUI.ADMIN);
                    show(GUI.ADMIN_HOME , null);
                }
                else if(userType.equals(MainClass.STAFF))
                {
                    GUI.setupSidePanel(GUI.STAFF);
                    show(GUI.SALES_TICKETS , null);
                }
            }
            else //Wrong Password Entered .....
            {
                System.out.println("Wrong password entered");
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame() , "Please enter the correct password" , "Wrong Password" , JOptionPane.ERROR_MESSAGE);
            }
        }else //When the user is not found in the system
        {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame() , "User is not found in the system" , "Invalid Username" , JOptionPane.ERROR_MESSAGE);
            Login_Form.txtUsername.setText("");
            Login_Form.txtPassword.setText("");

        }


    }

    public static void addUser(String username , String password , String id , String userType)
    {
        if(!username.isEmpty() && !password.isEmpty() && !id.isEmpty()) {
            try {
                DataManager.addUser(username , password , id , userType);

            }catch (SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame() , "There is already a user with this ID" , "Duplicate Data" , JOptionPane.OK_OPTION);
                DataManager.refreshUserData(Admin_Manage_Users.model);
            }catch(Exception error){
                System.out.println(error);
            }
        }
        else{
            System.out.println("Entered Username = " + username + "\n enteredpassword = " + password + "\nenteredId = " + id + "\nEntered Usertype = " + userType);
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame() , "Please fill in every field" , "Incomplete Information" , JOptionPane.OK_OPTION);
        }
    }

    public static void deleteUser(String username , int idToDelete)throws Exception
    {
       int result = JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(),
                                    "Are you sure you want to delete " + username + " ?",
                                        "Confirm" , JOptionPane.YES_NO_OPTION , JOptionPane.WARNING_MESSAGE);
       if(result == JOptionPane.YES_OPTION)
       {
           DataManager.deleteUser(idToDelete);
       }
    }

    public static String[] getCheckBoxData(ArrayList<JCheckBox> checkBoxes) {

        ArrayList<String> showTimes = new ArrayList<>();

        for(int i = 0 ; i<= checkBoxes.size(); i++)
        {
            if(checkBoxes.get(i).isSelected())
            {
                showTimes.add(checkBoxes.get(i).getText());
            }
        }
        return showTimes.toArray(new String[0]);

    }

    public void addMovie(String movieName , int categoryID , int theatreNo, String movieType,String showTime)
    {
        Movie movie = new Movie(movieName, categoryID , theatreNo , movieType , showTime);
        DataManager.addMovie(movie);
    }

}
