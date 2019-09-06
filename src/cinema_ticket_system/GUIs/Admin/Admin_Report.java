package cinema_ticket_system.GUIs.Admin;

import cinema_ticket_system.Controllers.MainClass;
import cinema_ticket_system.GUIs.Login_Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

        import cinema_ticket_system.GUIs.Login_Form;
        import cinema_ticket_system.Controllers.MainClass;
        import cinema_ticket_system.Controllers.UserInteractions;
import cinema_ticket_system.Utils.Utils;

import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;

public class Admin_Report extends JPanel {
    public static JFrame window = new JFrame("Admin");
    public static JButton btnLogOut = new JButton("Log Out");
    public static JButton btnManagemovies = new JButton("Manage Movies");
    public static JButton btnManageSeatPlan = new JButton("Manage Seat Plan");
    public static JButton btnManageUsers = new JButton("Manage Users");

    public Admin_Report()
    {
        // "Welcome Admin!" Label
        JLabel lblWelcomeAdmin = new JLabel("Sorry");
        lblWelcomeAdmin.setFont(new Font("Courier" ,Font.PLAIN , 20));
        lblWelcomeAdmin.setForeground(Color.decode("#F7FDFF"));
        lblWelcomeAdmin.setBounds(505 , 350 , 180, 50);
        JLabel lblWelcomeAdminName = new JLabel(MainClass.getUserName()+"!");
        lblWelcomeAdminName.setFont(new Font("Courier" ,Font.PLAIN , 20));
        lblWelcomeAdminName.setForeground(Color.decode("#75CBE6"));
        lblWelcomeAdminName.setBounds(605 , 350 , 500, 50);

        JLabel lblResponse = new JLabel("This page is under construction");
        lblResponse.setFont(new Font("Courier" ,Font.PLAIN , 20));
        lblResponse.setForeground(Color.decode("#75CBE6"));
        lblResponse.setBounds(450 , 400 , 500, 50);

        JLabel icnReport = new JLabel();
        ImageIcon imgReport = new ImageIcon("tools.png");
        icnReport.setIcon(Utils.scaleImage(imgReport , 200 , 200));
        icnReport.setBounds(535 , 100 , 200 , 200);

        //Constructor for JPanel
        setLayout(null);
        setBackground(Color.decode("#242B40"));
        setBounds(0 , 0 , 1200 , 700);
        add(icnReport);
        add(lblResponse);
        add(btnManagemovies);
        add(btnManageSeatPlan);
        add(btnManageUsers);
        add(lblWelcomeAdmin);
        add(lblWelcomeAdminName);
        add(btnLogOut);

    }


}
