package cinema_ticket_system.GUIs.Admin;
import cinema_ticket_system.Controllers.GUI;
import cinema_ticket_system.Controllers.MainClass;
import cinema_ticket_system.GUIs.Sales.Sales_Tickets;
import cinema_ticket_system.Utils.Utils;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Admin_Menu_Fragment extends JPanel {
    public static JFrame window = new JFrame("Admin");
    Admin_Menu_Fragment.ButtonHandler buttons = new ButtonHandler() ;
    static JButton btnAddMovieArt = new JButton("+");
    static JButton btnManageUsers = new JButton("Manage Users");
    static JButton btnManageSeatPlan = new JButton("Manage Seat Plan");
    static JButton btnManagemovies = new JButton("Manage Movies");
    static JButton btnReport = new JButton("Reports");

    JPanel pnlManageMovies = new JPanel();
    JPanel pnlManageSeatPlan = new JPanel();
    JPanel pnlManageUsers = new JPanel();
    JPanel pnlReport = new JPanel();

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

        JLabel icnManageMovies = new JLabel();
        ImageIcon imgManageMovies = new ImageIcon("video-camera.png");
        icnManageMovies.setIcon(Utils.scaleImage(imgManageMovies , 40 , 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0 , 10 , 10  , 0);
        pnlManageMovies.setBounds(0 , 120 , 250 , 70);
        pnlManageMovies.setLayout(new GridBagLayout());
        pnlManageMovies.setBackground(Color.decode("#242B40"));
        btnManagemovies.setFont(new Font("Roboto" , Font.PLAIN , 16));
        btnManagemovies.setBackground(Color.decode("#242B40"));
        btnManagemovies.setForeground(Color.decode("#75CBE6"));
        btnManagemovies.setOpaque(false);
        btnManagemovies.setContentAreaFilled(false);
        btnManagemovies.setBorderPainted(false);
//        btnManagemovies.setBounds(0 , 0 , 200 , 50);//used to be 25 , 110 , 200 , 50)
        btnManagemovies.addActionListener(buttons);
        pnlManageMovies.add(icnManageMovies , gbc);
        pnlManageMovies.add(btnManagemovies);

        //Constructor for "Manage Seat Plan" Button

        JLabel icnManageSeatPlan = new JLabel();
        ImageIcon imgManageSeatPlan = new ImageIcon("price-tag.png");
        icnManageSeatPlan.setIcon(Utils.scaleImage(imgManageSeatPlan , 40 , 40));
        GridBagConstraints gbcSeatPlan = new GridBagConstraints();
        gbcSeatPlan.insets = new Insets(0 , 10 , 10  , 0);
        pnlManageSeatPlan.setBounds(0 , 190 , 250 , 70);
        pnlManageSeatPlan.setLayout(new GridBagLayout());
        pnlManageSeatPlan.setBackground(Color.decode("#242B40"));
        btnManageSeatPlan.setFont(new Font("Roboto" , Font.PLAIN , 16));
        btnManageSeatPlan.setBackground(Color.decode("#242B40"));
        btnManageSeatPlan.setForeground(Color.decode("#75CBE6"));
        btnManageSeatPlan.setOpaque(false);
        btnManageSeatPlan.setContentAreaFilled(false);
        btnManageSeatPlan.setBorderPainted(false);
        btnManageSeatPlan.addActionListener(buttons);
        pnlManageSeatPlan.add(icnManageSeatPlan , gbcSeatPlan);
        pnlManageSeatPlan.add(btnManageSeatPlan);

        //Contructor for "Manage Users" Button

        JLabel icnManageUsers = new JLabel();
        ImageIcon imgManageUsers = new ImageIcon("boy.png");
        icnManageUsers.setIcon(Utils.scaleImage(imgManageUsers , 40 , 40));
        icnManageUsers.setBounds(0 , 10 , 40 , 40);
        GridBagConstraints gbcManageUsers = new GridBagConstraints();
        gbcManageUsers.insets = new Insets(0 , 10 , 10  , 0);
        pnlManageUsers.setBounds(0 , 260 , 250 , 70);
        pnlManageUsers.setLayout(new GridBagLayout());
        pnlManageUsers.setBackground(Color.decode("#242B40"));
        btnManageUsers.setFont(new Font("Roboto" , Font.PLAIN , 16));
        btnManageUsers.setBackground(Color.decode("#242B40"));
        btnManageUsers.setForeground(Color.decode("#75CBE6"));
        btnManageUsers.setOpaque(false);
        btnManageUsers.setContentAreaFilled(false);
        btnManageUsers.setBorderPainted(false);
        //btnManageUsers.setBounds(0 , 180 , 250 , 50);
        btnManageUsers.addActionListener(buttons);
        pnlManageUsers.add(icnManageUsers , gbcManageUsers);
        pnlManageUsers.add(btnManageUsers);

        //Constructor for "Report" Button
        JLabel icnReport = new JLabel();
        ImageIcon imgReport = new ImageIcon("newspaper.png");
        icnReport.setIcon(Utils.scaleImage(imgReport , 40 , 40));
        icnReport.setBounds(0 , 10 , 40 , 40);
        GridBagConstraints gbcReport = new GridBagConstraints();
        gbc.insets = new Insets(0 , 10 , 10  , 0);
        pnlReport.setBounds(0 , 330 , 250 , 70);
        pnlReport.setLayout(new GridBagLayout());
        pnlReport.setBackground(Color.decode("#242B40"));
        btnReport.setFont(new Font("Roboto" , Font.PLAIN , 16));
        btnReport.setBackground(Color.decode("#242B40"));
        btnReport.setForeground(Color.decode("#75CBE6"));
        btnReport.setOpaque(false);
        btnReport.setContentAreaFilled(false);
        btnReport.setBorderPainted(false);
        btnReport.addActionListener(buttons);
        pnlReport.add(icnReport , gbcReport);
        pnlReport.add(btnReport);


        setLayout(null);
        setBackground(Color.decode("#242B40"));
        setBounds(0 , 0 , 250  , 1000);
        add(lblUser_name);
        add(pnlManageMovies);
        add(pnlManageSeatPlan);
        add(pnlManageUsers);
        add(pnlReport);

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
            else if(e.getSource() == btnReport)
            {
                selectedIndex = 4;
                try {
                    GUI.show(GUI.ADMIN_REPORT , new Object[]{4});
                } catch (final UnsupportedLookAndFeelException e1) {
                    e1.printStackTrace();
                }
            }
            JPanel[] sideButtons = new JPanel[]{pnlManageMovies , pnlManageSeatPlan, pnlManageUsers};
            for(int i = 0 ; i< sideButtons.length ; i++)
            {
                sideButtons[i].setBackground(Color.decode("#242B40"));
                if((i+1) == selectedIndex)
                {
                    sideButtons[i].setBackground(Color.decode("#181f2e"));
                }
            }
            updateGUI();
            System.out.println("menu selected " + selectedIndex);
        }

    }
}
