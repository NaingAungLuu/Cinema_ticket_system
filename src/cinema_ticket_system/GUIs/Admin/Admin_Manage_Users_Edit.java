package cinema_ticket_system.GUIs.Admin;

import cinema_ticket_system.Controllers.DataManager;
import cinema_ticket_system.Controllers.GUI;
import cinema_ticket_system.Controllers.UserInteractions;
import cinema_ticket_system.DataObjects.User;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.*;

public class Admin_Manage_Users_Edit {

    public Admin_Manage_Users_Edit(User user)
    {
        JFrame window = new JFrame();
        window.setSize(390 , 220);//JFrame size is set based on the View ID
        window.setLocation(450 , 300);
        window.setTitle("Edit User Info");
        window.setName("Edit User Info");
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JTextField txtUsername = new JTextField(user.getUserName());
        JTextField txtPassword = new JTextField(user.getPassword());
        JTextField txtID = new JTextField(String.valueOf(user.getUserID()));
        //Constructor for TextAreas
        //Add_Username
        txtUsername.setBounds(20 , 20 , 350 , 30);
        txtUsername.setFont(new Font("Nadeem" , Font.PLAIN , 16));
        txtUsername.setMargin(new Insets(5 , 10 , 1 , 0));
        txtUsername.setBorder(BorderFactory.createLineBorder(Color.decode("#FF6767") , 1 ));

        //Add_Password
        txtPassword.setBounds(20 , 60 , 350 , 30);
        txtPassword.setFont(new Font("Nadeem" , Font.PLAIN , 16));
        txtPassword.setMargin(new Insets(5 , 10 , 1 , 0));
        txtPassword.setBorder(BorderFactory.createLineBorder(Color.decode("#FF6767") , 1 ));

        //Add_ID
        txtID.setBounds(20 , 100 , 350 , 30);
        txtID.setFont(new Font("Nadeem" , Font.PLAIN , 16));
        txtID.setMargin(new Insets(5 , 10 , 1 , 0));
        txtID.setBorder(BorderFactory.createLineBorder(Color.decode("#FF6767") , 1 ));

        //Constructin JRadio Buttons for choosing user-type while adding a user
        final JRadioButton rdoAdmin = new JRadioButton("ADMIN");
        JRadioButton rdoStaff = new JRadioButton("STAFF");
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(rdoAdmin);
        btnGroup.add(rdoStaff);
        rdoStaff.setSelected(true);
        // 300 , 500 , 350 , 30
        rdoAdmin.setForeground(Color.decode("#75CBE6"));
        rdoAdmin.setBackground(Color.decode("#242B40"));
        rdoAdmin.setBounds(20 , 130 , 100 , 50);
        rdoAdmin.setFont(new Font("Roboto" , Font.PLAIN, 17));

        rdoStaff.setForeground(Color.decode("#75CBE6"));
        rdoStaff.setBounds(120 , 130 , 100 , 50);
        rdoStaff.setFont(new Font("Roboto" , Font.PLAIN, 17));
        rdoStaff.setBackground(Color.decode("#242B40"));

        JButton btnAdd = new JButton("Save");

        btnAdd.setBounds(250 , 150 , 120 , 35);
        btnAdd.setBackground(Color.decode("#FF6767"));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setContentAreaFilled(false);
        btnAdd.setBorder(new LineBorder(Color.decode("#242B40") , 2));
        btnAdd.setOpaque(true);
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnAdd.setBackground(Color.white);
                btnAdd.setForeground(Color.decode("#FF6767"));
            }
        });
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnAdd.setBackground(Color.decode("#FF6767"));
                btnAdd.setForeground(Color.white);
            }
        });
        btnAdd.addActionListener(e -> {
            String userType = rdoAdmin.isSelected() ?  "ADMIN" : "STAFF";
            DataManager.updateUser(new User(Integer.parseInt(txtID.getText()) , txtUsername.getText() , txtPassword.getText() , userType));
            window.dispose();
            System.out.println("Edit window disposed");
            DataManager.refreshUserData(Admin_Manage_Users.model);
            GUI.window.setEnabled(true);
            GUI.window.requestFocus();
            GUI.dialogable = true;
        });

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#242B40"));
        panel.add(btnAdd);
        panel.add(txtUsername);
        panel.add(txtPassword);
        panel.add(txtID);
        panel.add(rdoAdmin);
        panel.add(rdoStaff);

        window.setContentPane(panel);
        window.setFocusable(true);
        window.setVisible(true);
    }
}
