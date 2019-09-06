package cinema_ticket_system.GUIs.Admin;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import cinema_ticket_system.GUIs.Login_Form;
import cinema_ticket_system.Controllers.UserInteractions;

public class Admin_Manage_Seat_Plan extends JPanel{
		public static JFrame window = new JFrame("Admin");
		public static JButton btnLogOut = new JButton("Log Out");
		public static JButton btnManagemovies = new JButton("Manage Movies");
		static JButton btnManageSeatPlan = new JButton("Manage Seat Plan");
		static JButton btnManageUsers = new JButton("Manage Users");
		public static JTextArea txtClassA = new JTextArea("6500");
		public static JTextArea txtClassB = new JTextArea("5500");
		public static JTextArea txtClassC = new JTextArea("4500");
		public static JTextArea txtCoupleSeat = new JTextArea("12000");
			public static void main(String[]args)
			{
				Admin_Manage_Seat_Plan frmAdminManageSeatPlan = new Admin_Manage_Seat_Plan();
				JButton btnLogin = new JButton("OK");
			}
			public Admin_Manage_Seat_Plan()
			{
				
				
				//Constructor for JRadioButtons
				JRadioButton rdo3D = new JRadioButton("3D" , true);
				JRadioButton rdo2D = new JRadioButton("2D" , false);
				ButtonGroup btnGp = new ButtonGroup();
				btnGp.add(rdo2D);
				btnGp.add(rdo3D);
				rdo3D.setBounds(495 , 50 , 100 , 30);
				rdo2D.setBounds(595 , 50 , 100 , 30);
				rdo3D.setForeground(Color.decode("#FFFFFF"));
				rdo2D.setForeground(Color.decode("#FFFFFF"));
				rdo3D.setBackground(Color.decode("#242B40"));
				rdo2D.setBackground(Color.decode("#242B40"));

				rdo3D.setFont(new Font("Nadeem" , Font.PLAIN , 26));
				rdo2D.setFont(new Font("Nadeem" , Font.PLAIN , 26));
				//lblWelcomeAdmin.setBounds(505 , 50 , 180, 50);
			
				//lblWelcomeAdminName.setBounds(605 , 50 , 100, 50);
				
				//Constructor for JTextAreas
				//Class A Seat

				txtClassA.setBounds(465 , 140 , 200 , 30);

				//Class B Seat

				txtClassB.setBounds( 465 , 230 , 200 , 30);

				//Class C Seat

				txtClassC.setBounds(465 , 320 , 200 , 30);

				//Couple Seat

				txtCoupleSeat.setBounds(465 , 410 , 200 , 30);

				//Constructor for JLabels
				//Admin_main label
				JLabel Admin_main = new JLabel("Admin");
				Admin_main.setFont(new Font("Courier" ,Font.PLAIN , 26));
				Admin_main.setForeground(Color.decode("#75CBE6"));
				Admin_main.setBounds(85 , 50 , 100, 50);
				
				//Constructor for Class Seat Price
				JLabel lblClassA = new JLabel("Class A Seat Price");
				lblClassA.setFont(new Font("Nadeem" , Font.PLAIN ,16));
				lblClassA.setBounds(465 , 90 , 200 , 50);
				lblClassA.setForeground(Color.white);
				
				JLabel lblClassB = new JLabel("Class B Seat Price");
				lblClassB.setFont(new Font("Nadeem" , Font.PLAIN , 16));
				lblClassB.setBounds(465 , 180 , 200 , 50);
				lblClassB.setForeground(Color.white);

				JLabel lblClassC = new JLabel("Class C Seat Price");
				lblClassC.setFont(new Font("Nadeem" , Font.PLAIN , 16));
				lblClassC.setBounds(465 , 270 , 200 , 50);
				lblClassC.setForeground(Color.white);

				JLabel lblCoupleSeat = new JLabel("Couple Seat Price");
				lblCoupleSeat.setFont(new Font("Nadeem" , Font.PLAIN , 16));
				lblCoupleSeat.setBounds(465 , 360 , 200 , 50);
				lblCoupleSeat.setForeground(Color.white);

				//Cinema Name Label
				JLabel lblCinemaname = new JLabel("Galaxy");
				lblCinemaname.setForeground(Color.decode("#FF6767"));
				lblCinemaname.setBounds(1000 , 620 , 200 , 50);
				lblCinemaname.setFont(new Font("Rockwell" , Font.PLAIN , 18));
				JLabel lblCinemaname1 = new JLabel("Cinemas");
				lblCinemaname1.setForeground(Color.decode("#E3E3E3"));
				lblCinemaname1.setBounds(1080 , 620 , 200 , 50);
				lblCinemaname1.setFont(new Font("Rockwell" , Font.PLAIN , 18));
				


				//Constructor for Save Button
				final JButton btnSave = new JButton("Save");
				btnSave.setBounds(550 , 490 , 100 , 40);
				btnSave.setBackground(Color.decode("#FF6767"));
				btnSave.setForeground(Color.WHITE);
				btnSave.setContentAreaFilled(false);
				btnSave.setBorder(new LineBorder(Color.decode("#242B40") , 2));
				btnSave.setOpaque(true);
				btnSave.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						super.mouseEntered(e);
						btnSave.setBackground(Color.white);
						btnSave.setForeground(Color.decode("#FF6767"));
					}
				});
				btnSave.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseExited(MouseEvent e) {
						super.mouseExited(e);
						btnSave.setBackground(Color.decode("#FF6767"));
						btnSave.setForeground(Color.white);
					}
				});

				//Constructor for JPanel
				setLayout(null);
				setBackground(Color.decode("#181f2e"));
				setBounds(0 , 0 , 1200 , 720);
				add(Admin_main);
				add(rdo3D);
				add(rdo2D);
				add(lblCinemaname1);
				add(lblCinemaname);
				add(btnLogOut);
				add(lblClassA);
				add(lblClassB);
				add(txtClassA);
				add(txtClassB);
				add(lblClassC);
				add(txtClassC);
				add(txtCoupleSeat);
				add(lblCoupleSeat);
				add(btnSave);
				//Constructor for JFrame
			}
}
