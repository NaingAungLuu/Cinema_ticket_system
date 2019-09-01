package cinema_ticket_system.GUIs;
import cinema_ticket_system.Controllers.GUI;
import cinema_ticket_system.Controllers.MainClass;
import cinema_ticket_system.Controllers.UserInteractions;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import javax.swing.border.LineBorder;
public class Login_Form extends JPanel{
	public static String str = "Hello World!";
	public static String button_text = "OK";
	public static boolean status = false;
	public static String password;
	public static JPasswordField txtPassword = new JPasswordField();
	public static JTextField txtUsername = new JTextField();
	public static JFrame window = new JFrame("Login Form");
	 static JButton btnLogin = new JButton("Log In");
	public JPanel content = new JPanel();

	public static final String ADMIN = "ADMIN";
	public static final String STAFF = "STAFF";

	public static void main(String[]args)
	{	
		Login_Form login = new Login_Form();
	}
	private void Login()
	{

	}


	public Login_Form()  
	{
		//Constructor for Labels
				//Cinema n	me label

				JLabel lblCinemaname = new JLabel("Galaxy");
				lblCinemaname.setBackground(Color.decode("#242B40"));
				lblCinemaname.setForeground(Color.decode("#FF6767"));
				lblCinemaname.setBounds(110 , 50 , 200 , 50);
				lblCinemaname.setFont(new Font("Rockwell" , Font.PLAIN , 36));
				JLabel lblCinemaname1 = new JLabel("Cinemas");
				lblCinemaname1.setForeground(Color.decode("#E3E3E3"));
				lblCinemaname1.setBackground(Color.decode("#242B40"));
				lblCinemaname1.setBounds(250 , 52 , 200 , 50);
				lblCinemaname1.setFont(new Font("Rockwell" , Font.PLAIN , 36));
				//Username label
				JLabel lblLogin = new JLabel("Username");
				lblLogin.setBackground(Color.decode("#242B40"));
				lblLogin.setForeground(Color.WHITE);
				lblLogin.setBounds(100, 150, 200, 20);
				lblLogin.setFont(new Font("Arial" , Font.BOLD , 20));
				//Password label
				JLabel lblPassword = new JLabel("Password");
				lblPassword.setBackground(Color.decode("#242B40"));
				lblPassword.setForeground(Color.WHITE);
				lblPassword.setBounds(100, 200, 200, 20);
				lblPassword.setFont(new Font("Arial" , Font.BOLD , 20));
				
				//Constructors for TextField
				//Username Textfield
				txtUsername.setBounds(210 , 149 , 200 , 30 );
				//txtUsername.setBorder(new LineBorder(Color.decode("#e91e63") , 1));
				
				//Password Textfield
				txtPassword.setBounds(210 , 199 , 200 , 30 );
				txtPassword.setEchoChar('*');
				password = txtPassword.getPassword().toString();
				txtPassword.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						super.keyPressed(e);
						if(e.getKeyCode() == KeyEvent.VK_ENTER)
						{
							System.out.println("Attempting Login from password field");
							try {
								UserInteractions.Login(txtUsername.getText() , String.valueOf(txtPassword.getPassword()));
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					}
				});


				//Constructor for Buttons
				//Login Button
				btnLogin.setBounds(150 , 270 , 180 , 45);

				btnLogin.setBackground(Color.decode("#FF6767"));
				btnLogin.setForeground(Color.white);
				btnLogin.setFont(new Font("Arial" , Font.BOLD , 20 ));
				btnLogin.setContentAreaFilled(false);
				btnLogin.setBorder(new LineBorder(Color.decode("#242B40") , 2));
				btnLogin.setOpaque(true);
				btnLogin.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							UserInteractions.Login(txtUsername.getText() , String.valueOf(txtPassword.getPassword()));
							System.out.println("Attempting login");
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});

				//btnLogin.setBounds((window.getWidth()/2)-(btnLogin.getWidth()/2) , 270 , 180 , 45);

				//Constructor for Panel("CONTENT")
				setLayout(null);
				setBackground(Color.decode("#242B40"));
				add(lblLogin);
				add(lblPassword);
				add(txtUsername);
				add(txtPassword);
				add(btnLogin);
				add(lblCinemaname);
				add(lblCinemaname1);


				txtUsername.grabFocus();

	}
	public static void clearTextFields()
	{
		txtUsername.setText("");
		txtPassword.setText("");

	}
}
