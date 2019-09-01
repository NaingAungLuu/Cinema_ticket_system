package cinema_ticket_system.GUIs.Admin;
import cinema_ticket_system.Controllers.GUI;
import cinema_ticket_system.Controllers.MainClass;
import cinema_ticket_system.GUIs.Sales.Sales_Tickets;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import static cinema_ticket_system.GUIs.Admin.Admin_Manage_Users.btnReport;

public class Admin_Menu_Fragment extends JPanel {
    public static JFrame window = new JFrame("Admin");
    public static JButton btnLogOut = new JButton("Log Out");
    static JPanel SidePanel = new JPanel();
    Admin_Menu_Fragment.ButtonHandler buttons = new ButtonHandler() ;
    static JButton btnAddMovieArt = new JButton("+");
    static JButton btnManageUsers = new JButton("Manage Users");
    static JButton btnManageSeatPlan = new JButton("Manage Seat Plan");
    static JButton btnManagemovies = new JButton("Manage Movies");
    static JButton btnAddMovie = new JButton("Add");
    static JButton btnEdit = new JButton("Edit");
    String strMovieName = "Aquaman";
    String strMovieType = "2D";
    String strTheatreNo = "1 , 2";
    String strMovieTime = "9:00am , 11:30am , 1.30pm , 3:00pm \n , 5:00pm , 7:00pm";
    JLabel lblMovieName = new JLabel(this.strMovieName);
    JLabel lblMovieType = new JLabel(this.strMovieType);
    JLabel lblTheatreNo  = new JLabel(this.strTheatreNo);
    JLabel lblMovieTimes = new JLabel(this.strMovieTime);
    public static JPanel content = new JPanel();
    static String showtimes = "9:00am , 11:30am , 1.30pm , 3:00pm \n , 5:00pm , 7:00pm";
    static String[][] data = {{"Aquaman" , "1 , 2" , Admin_Menu_Fragment.showtimes, "3D"} ,
            {"How To Train Your Dragon \n (The Hidden World)" , "3" , Admin_Menu_Fragment.showtimes, "2D"} ,
            {"Oh My Ghost 6" , "4" , Admin_Menu_Fragment.showtimes, "2D"} };
    static String[] numbers = {"Movie Name" , "Theatre No." , "Show Times" , "Type"};
    static JTable Jt = new JTable(Admin_Menu_Fragment.data, Admin_Menu_Fragment.numbers);

    static JPanel panel;

    public Admin_Menu_Fragment()
    {


        //Constructor for JLabels
        //Admin_main label
        final JLabel lblUser_name = new JLabel(MainClass.getUserName() , SwingConstants.CENTER);
        lblUser_name.setFont(new Font("Roboto" ,Font.PLAIN , 20));
        lblUser_name.setForeground(Color.decode("#75CBE6"));
        lblUser_name.setBackground(Color.white);
        lblUser_name.setBounds( 30 , 50 , 200, 50);


        //Constructor for "Manage movies" Button
        btnManagemovies.setFont(new Font("Roboto" , Font.PLAIN , 16));
        btnManagemovies.setBackground(Color.decode("#242B40"));
        btnManagemovies.setForeground(Color.decode("#75CBE6"));
        btnManagemovies.setOpaque(false);
        btnManagemovies.setContentAreaFilled(false);
        btnManagemovies.setBorderPainted(false);
        btnManagemovies.setBounds(25 , 110 , 200 , 50);
        btnManagemovies.addActionListener(buttons);

        //Constructor for "Manage Seat Plan" Button
        btnManageSeatPlan.setFont(new Font("Roboto" , Font.PLAIN , 16));
        btnManageSeatPlan.setBackground(Color.decode("#242B40"));
        btnManageSeatPlan.setForeground(Color.decode("#75CBE6"));
        btnManageSeatPlan.setOpaque(false);
        btnManageSeatPlan.setContentAreaFilled(false);
        btnManageSeatPlan.setBorderPainted(false);
        btnManageSeatPlan.setBounds(5 , 145 , 250 , 50);
        btnManageSeatPlan.addActionListener(buttons);

        //Contructor for "Manage Users" Button
        btnManageUsers.setFont(new Font("Roboto" , Font.PLAIN , 16));
        btnManageUsers.setBackground(Color.decode("#242B40"));
        btnManageUsers.setForeground(Color.decode("#75CBE6"));
        btnManageUsers.setOpaque(false);
        btnManageUsers.setContentAreaFilled(false);
        btnManageUsers.setBorderPainted(false);
        btnManageUsers.setBounds(0 , 180 , 250 , 50);
        btnManageUsers.addActionListener(buttons);

        //Constructor for "Report" Button
        final JButton btnReport = new JButton("Reports");
        btnReport.setFont(new Font("Roboto" , Font.PLAIN , 16));
        btnReport.setBackground(Color.decode("#242B40"));
        btnReport.setForeground(Color.decode("#75CBE6"));
        btnReport.setOpaque(false);
        btnReport.setContentAreaFilled(false);
        btnReport.setBorderPainted(false);
        btnReport.setBounds(25 , 215 , 200 , 50);
        btnReport.addActionListener(buttons);


        setLayout(null);
        setBackground(Color.decode("#242B40"));
        setBounds(0 , 0 , 250  , 1000);
        add(lblUser_name);
        add(btnManagemovies);
        add(btnManageSeatPlan);
        add(btnManageUsers);
        add(btnReport);

    }

    public void updateGUI()
    {
        updateUI();
    }




    public class ButtonHandler implements ActionListener{
        public void actionPerformed(final ActionEvent e)
        {
            int selectedIndex = 0;
            if(e.getSource() == btnManageSeatPlan)
            {
                selectedIndex = 2;
                try {
                    GUI.show(GUI.ADMIN_MANAGE_SEAT_PLAN , new Object[]{1});
                } catch (final UnsupportedLookAndFeelException e1) {
                    e1.printStackTrace();
                }
            }
            else if(e.getSource() == btnManagemovies)
            {
                selectedIndex =1;
                try {
                    GUI.show(GUI.ADMIN_MANAGE_MOVIES , new Object[]{2});
                } catch (final UnsupportedLookAndFeelException e1) {
                    e1.printStackTrace();
                }
            }
            else if(e.getSource() == btnManageUsers)
            {
                selectedIndex = 3;
                try {
                    GUI.show(GUI.ADMIN_MANAGE_USERS , new Object[]{3});
                } catch (final UnsupportedLookAndFeelException e1) {
                    e1.printStackTrace();
                }
            }
            JButton[] sideButtons = new JButton[]{btnManagemovies , btnManageSeatPlan, btnManageUsers  , btnReport};
            for(int i = 0 ; i< sideButtons.length ; i++)
            {
                sideButtons[i].setForeground(Color.decode("#75CBE6"));
                if((i+1) == selectedIndex)
                {
                    sideButtons[i].setForeground(Color.white);
                }
            }
            updateGUI();
            System.out.println("menu selected " + selectedIndex);
        }

    }
}
