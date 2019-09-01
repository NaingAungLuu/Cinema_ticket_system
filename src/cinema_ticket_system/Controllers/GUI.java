package cinema_ticket_system.Controllers;

import cinema_ticket_system.DataObjects.User;
import cinema_ticket_system.GUIs.Admin.*;
import cinema_ticket_system.GUIs.Login_Form;
import cinema_ticket_system.GUIs.Sales.Sales_Menu_Fragment;
import cinema_ticket_system.GUIs.Sales.Sales_Seats;
import cinema_ticket_system.GUIs.Sales.Sales_Tickets;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicListUI;
import java.awt.*;
import java.awt.event.*;

public class GUI{
    public static final int ADMIN_HOME = 1;
    public static final int ADMIN_MANAGE_MOVIES = 2;
    public static final int ADMIN_MANAGE_SEAT_PLAN = 3;
    public static final int ADMIN_MANAGE_USERS = 4;
    public static final int LOGIN = 5;
    public static final int SALES_MAIN = 6;
    public static final int SALES_TICKETS = 7;
    public static final int SALES_SEATS = 8;
    public static final int ADMIN_MANAGE_MOVIES_FRAGMENT = 9;
    public static final int EDIT_USER_INFO = 10;

    static Dimension login_dim = new Dimension(500 , 400);
    static Dimension default_dim = new Dimension(1200 , 700);
    public static JFrame window = new JFrame();
    static JButton btnLogOut = new JButton();
    static JPanel pnlFrag = new JPanel();
    static JPanel pnlframe = new JPanel();
    static JPanel pnlSidePanel;
    private static String UserName = "Default";
    private static String UserType = "DEFAULT";
    public static final String ADMIN = "ADMIN";
    public static final String STAFF = "STAFF";


    public static void setupSidePanel(String userType)
    {
        pnlFrag.setLayout(null);
        pnlFrag.removeAll();

        //Build UserInterface based on UserType
        if(userType.equals(STAFF))
        {
            pnlSidePanel = new Sales_Menu_Fragment();
            pnlFrag.add(pnlSidePanel);
            System.out.println("Staff panel attached");
            //pnlFrag.add(new Sales_Tickets());
        }
        else if(userType.equals(ADMIN))
        {
            pnlSidePanel = new Admin_Menu_Fragment();
            pnlFrag.add(pnlSidePanel);
            System.out.println("Admin Menu Panel Attached");
        }
        pnlFrag.updateUI();
    }

    public static void initiateUserWindow()
    {
        //Prepare JFrame for GUI presentation
        window.setSize(default_dim);
        //JFrame size is set based on the View ID
        window.setLocation(450 , 300);
        window.setLocation(100, 100);
        window.setTitle("Cinema Ticket Booking System");
        window.setName("Cinema Ticket Booking System");
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setContentPane(pnlFrag);
        window.setVisible(true);

    }

    public static void initiateLoginWindow()
    {
        //Prepare JFrame for GUI presentation
        window.setSize(login_dim);//JFrame size is set based on the View ID
        window.setLocation(450 , 300);
        window.setTitle("Cinema Ticket Booking System");
        window.setName("Cinema Ticket Booking System");
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setContentPane(pnlFrag);
        window.setVisible(true);
    }


    public static void show(int ID , @Nullable Object extra[]) throws UnsupportedLookAndFeelException {
        //Fetch Username and User Types from the main class
        UserName = MainClass.getUserName();
        UserType = MainClass.getUserType();

        pnlFrag.remove(pnlframe);
        pnlFrag.setBackground(Color.decode("#242B40"));

        switch(ID)
        {
            //Login Panels
            case LOGIN :
                        pnlFrag = new Login_Form();
                        break;

            //Admin Panels
            case ADMIN_HOME :

                                pnlframe = new Admin_Home();
                                pnlFrag.add(pnlframe);
                                System.out.println("Admin Home Panel Attached");
                                break;

            case ADMIN_MANAGE_MOVIES:
                                      pnlframe = new Admin_Manage_Movies();
                                      pnlFrag.add(pnlframe);
                                      break;

            case ADMIN_MANAGE_SEAT_PLAN:
                                         pnlframe = new Admin_Manage_Seat_Plan();
                                         pnlFrag.add(pnlframe);
                                         break;

            case ADMIN_MANAGE_USERS:
                                    pnlframe = new Admin_Manage_Users();
                                    pnlFrag.add(pnlframe);
                                    break;

            //Sales Panels
            case SALES_TICKETS :
                                pnlframe = new  Sales_Tickets();
                                pnlFrag.add(pnlframe);
                                break;

            case SALES_SEATS :
                                /**
                                    In this case, The index 0 of "extra" carries the movieID
                                                  and index 1 of "extra" carries the is3D boolean
                                 */
                                pnlframe = new Sales_Seats( Integer.parseInt(extra[0].toString()) , (Boolean) extra[1]);
                                pnlFrag.add(pnlframe);break;


             //Default Panel
            default: System.out.println("Error Occured");
        }

        //Make the JFrame visible
        prepareFrame(ID);
        window.setContentPane(pnlFrag);
        pnlFrag.updateUI();
    }

    private static void prepareFrame(int ID)
    {
        if(ID != LOGIN) {
            pnlSidePanel.updateUI();
            //Adds Log Out Button to the Frame
            btnLogOut.setText("Log Out");
            btnLogOut.setFont(new Font("Courier", Font.PLAIN, 16));
            btnLogOut.setForeground(Color.WHITE);
            btnLogOut.setBackground(Color.decode("#242B40"));
            btnLogOut.setBorder(new LineBorder(Color.decode("#FF6767"), 2));
            btnLogOut.setBounds(1080, 40, 90, 40);
            btnLogOut.setHorizontalAlignment(SwingConstants.CENTER);
            btnLogOut.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    btnLogOut.setBorder(null);
                    btnLogOut.setContentAreaFilled(false);
                    btnLogOut.setOpaque(true);
                    btnLogOut.setBackground(Color.white);
                    btnLogOut.setForeground(Color.decode("#FF6767"));
                }
            });
            btnLogOut.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    btnLogOut.setContentAreaFilled(true);
                    btnLogOut.setOpaque(false);
                    btnLogOut.setBorder(new LineBorder(Color.decode("#FF6767"), 2));
                    btnLogOut.setForeground(Color.decode("#FFFFFF"));
                    btnLogOut.setBackground(Color.decode("#242B40"));
                }
            });


            btnLogOut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        UserInteractions.LogOut();
                    } catch (UnsupportedLookAndFeelException e1) {
                        e1.printStackTrace();
                    }

                    //Add the Log Out Button to the JPanel

                }
            });

            pnlframe.add(btnLogOut);
        }
    }

    public static boolean dialogable = true;
    public static void showUserEditDialog(User user)
    {
        if(dialogable) {
            Admin_Manage_Users_Edit dialog = new Admin_Manage_Users_Edit(user);
            window.setFocusable(false);
            dialogable = false;
        }
    }
    public static boolean showTimeDialogable = true;
    public static void showMovieShowTimesDialog()
    {
      if(showTimeDialogable)
      {

      }
    }

}
