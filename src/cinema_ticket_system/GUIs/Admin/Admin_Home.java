package cinema_ticket_system.GUIs.Admin;
import cinema_ticket_system.GUIs.Login_Form;
import cinema_ticket_system.Controllers.MainClass;
import cinema_ticket_system.Controllers.UserInteractions;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Admin_Home extends JPanel{
		public static JFrame window = new JFrame("Admin");
		public static JButton btnLogOut = new JButton("Log Out");
		public static JButton btnManagemovies = new JButton("Manage Movies");
		public static JButton btnManageSeatPlan = new JButton("Manage Seat Plan");
		public static JButton btnManageUsers = new JButton("Manage Users");

		public static ButtonHandler buttons = new ButtonHandler();
			public static void main(String[]args)
			{
				/*Admin_Home adHome = new Admin_Home();
				JButton btnLogin = new JButton("OK");*/
				JFrame frame = new JFrame();
				frame.setContentPane(new Admin_Manage_Movies());
				frame.setTitle("This is the panel with fragment!!!!!");
				frame.setSize(1200 , 700);
				frame.setLocation(100, 100);
				frame.setVisible(true);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			}
			public Admin_Home()
			{
				// "Welcome Admin!" Label
				JLabel lblWelcomeAdmin = new JLabel("Welcome");
				lblWelcomeAdmin.setFont(new Font("Courier" ,Font.PLAIN , 20));
				lblWelcomeAdmin.setForeground(Color.decode("#F7FDFF"));
				lblWelcomeAdmin.setBounds(505 , 50 , 180, 50);
				JLabel lblWelcomeAdminName = new JLabel(MainClass.getUserName()+"!");

				lblWelcomeAdminName.setFont(new Font("Courier" ,Font.PLAIN , 20));
				lblWelcomeAdminName.setForeground(Color.decode("#75CBE6"));
				lblWelcomeAdminName.setBounds(605 , 50 , 500, 50);

				
				//Constructor for JPanel
			 	setLayout(null);
				setBackground(Color.decode("#242B40"));
				setBounds(0 , 0 , 1200 , 700);
				add(btnManagemovies);
				add(btnManageSeatPlan);
				add(btnManageUsers);
				add(lblWelcomeAdmin);
				add(lblWelcomeAdminName);
				add(btnLogOut);

			}

			public static class ButtonHandler implements ActionListener{
				public void actionPerformed(ActionEvent e)
				{
					if(e.getSource() == btnLogOut)
					{
						Login_Form frmLogin = new Login_Form();
						Admin_Home.window.dispose();
					}
					else if(e.getSource() == btnManagemovies)
					{
						Admin_Manage_Movies frmManageMovies = new Admin_Manage_Movies();
						Admin_Home.window.dispose();
						}
					else if(e.getSource() == btnManageSeatPlan)
					{
						Admin_Manage_Seat_Plan frmManageSeatPlane = new Admin_Manage_Seat_Plan();
						Admin_Home.window.dispose();
					}
					else if(e.getSource() == btnManageUsers)
					{
						Admin_Home.window.dispose();
					}
					}

				}
			

}
