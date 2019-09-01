package cinema_ticket_system.GUIs.Admin;
import java.sql.Connection;
import java.sql.Statement;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import cinema_ticket_system.Controllers.DataManager;
import cinema_ticket_system.Controllers.GUI;
import cinema_ticket_system.Controllers.UserInteractions;
import cinema_ticket_system.DataObjects.User;
import cinema_ticket_system.GUIs.Login_Form;


public class Admin_Manage_Users extends JPanel{

    public static JFrame window = new JFrame("Admin");
    public static JButton btnLogOut = new JButton("Log Out");
    public static JButton btnManagemovies = new JButton("Manage Movies");
    public static JButton btnReport = new JButton("Report");
    public static JButton btnManageSeatPlan = new JButton("Manage Seat Plan");
    public static JButton btnManageUsers = new JButton("Manage Users");
    public static JButton btnAdd = new JButton("Add");
    public ButtonHandler buttons = new ButtonHandler();
    public static JButton btnEdit = new JButton("Edit");
    public static JButton btnDelete = new JButton("Delete");
    JTable tblData;
    public static DefaultTableModel model;
    User currentUser = new User();

    JLabel lblUsername = new JLabel("Naing Aung Luu" , SwingConstants.LEFT);
    JLabel lblID = new JLabel("26093");

    HintTextField txtUsername = new HintTextField("Username");
    HintTextField txtPassword = new HintTextField("Password");
    HintTextField txtID = new HintTextField("ID");


    public Admin_Manage_Users() {

        String[][] Data = {};
        ArrayList<String[]> userData = new ArrayList<>();
        ArrayList<String> Columns = new ArrayList<>();
        Columns.add("User Name");
        Columns.add("ID");
        String[] ColumnNames = {"User Name", "ID"};
        Vector row = null;



        model = new DefaultTableModel(Data , ColumnNames){
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return false;
            }
        };
        tblData = new JTable(model);
        tblData.setPreferredScrollableViewportSize(new Dimension(800 , 300));
        tblData.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tblData);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(300 ,100 , 800 , 300);
        scrollPane.setViewportView(tblData);

        tblData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblData.getColumnModel().getColumn(0).setMinWidth(100);
        tblData.setAutoCreateRowSorter(false);
        tblData.getTableHeader().setReorderingAllowed(false);
        tblData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblData.setRowHeight(25);
        tblData.setFont(new Font("Roboto", Font.PLAIN, 15));
        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selectedRow = tblData.getSelectedRow();
                if(selectedRow >= 0)
                {
                    String userID = tblData.getValueAt(selectedRow , 1).toString();
                    lblUsername.setText(tblData.getValueAt(selectedRow , 0).toString());
                    lblID.setText(tblData.getValueAt(selectedRow , 1).toString());
                    currentUser = DataManager.getUser(Integer.parseInt(userID));
                }

            }
        });
        final Color originColor = new Color(232 , 232 , 232);
        tblData.getTableHeader().setResizingAllowed(false);
        tblData.getColumnModel().getColumn(0).setPreferredWidth(scrollPane.getWidth()/2);
        tblData.getColumnModel().getColumn(1).setPreferredWidth(scrollPane.getWidth()/2);
        tblData.setBackground(originColor);
        tblData.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table,
                                                           Object value, boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                Color alternateColor = new Color(164 , 185 , 191);

                Component c = super.getTableCellRendererComponent(table,
                        value, isSelected, hasFocus, row, column);
                if(isSelected)
                {
                    c.setBackground(Color.decode("#FF6767"));
                    c.setForeground(Color.white);
                }
                else {
                    c.setBackground(row % 2 == 0 ? originColor : alternateColor);
                    c.setForeground(Color.decode("#303030"));
                }
                return c;
            }
        });


        try {
            DataManager.refreshUserData(model);

        }catch (Exception e){

        }

        //Constructor for TextAreas
        //Add_Username
        txtUsername.setBounds(300 , 420 , 350 , 30);
        txtUsername.setFont(new Font("Nadeem" , Font.PLAIN , 16));
        txtUsername.setMargin(new Insets(5 , 10 , 1 , 0));
        txtUsername.setBorder(BorderFactory.createLineBorder(Color.decode("#FF6767") , 1 ));

        //Add_Password
        txtPassword.setBounds(300 , 460 , 350 , 30);
        txtPassword.setFont(new Font("Nadeem" , Font.PLAIN , 16));
        txtPassword.setMargin(new Insets(5 , 10 , 1 , 0));
        txtPassword.setBorder(BorderFactory.createLineBorder(Color.decode("#FF6767") , 1 ));

        //Add_ID
        txtID.setBounds(300 , 500 , 350 , 30);
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
        rdoAdmin.setBounds(300 , 530 , 100 , 50);
        rdoAdmin.setFont(new Font("Roboto" , Font.PLAIN, 17));

        rdoStaff.setForeground(Color.decode("#75CBE6"));
        rdoStaff.setBounds(400 , 530 , 100 , 50);
        rdoStaff.setFont(new Font("Roboto" , Font.PLAIN, 17));
        rdoStaff.setBackground(Color.decode("#242B40"));


        //Constructor for JLabels
        //Admin_main label
        JLabel Admin_main = new JLabel("Admin");
        Admin_main.setFont(new Font("Roboto" , Font.PLAIN, 26));
        Admin_main.setForeground(Color.decode("#75CBE6"));
        Admin_main.setBounds(85, 50, 100, 50);


        //Users In Database label
        JLabel Users_in_database = new JLabel("Users In Database");
        Users_in_database.setFont(new Font("Roboto" , Font.PLAIN, 20));
        Users_in_database.setForeground(Color.decode("#75CBE6"));
        Users_in_database.setBounds(300, 50, 250, 50);

        //Cinema Name Label
        JLabel lblCinemaname = new JLabel("Galaxy");
        lblCinemaname.setForeground(Color.decode("#FF6767"));
        lblCinemaname.setBounds(1000, 620, 200, 50);
        lblCinemaname.setFont(new Font("Rockwell", Font.PLAIN, 18));
        JLabel lblCinemaname1 = new JLabel("Cinemas");
        lblCinemaname1.setForeground(Color.decode("#E3E3E3"));
        lblCinemaname1.setBounds(1080, 620, 200, 50);
        lblCinemaname1.setFont(new Font("Rockwell", Font.PLAIN, 18));

        //Edit Username label
        lblUsername.setBounds(850 , 420 , 350 , 30);
        lblUsername.setForeground(Color.white);
        lblUsername.setFont(new Font("Courier" , Font.PLAIN , 24));

        JLabel lblNametag = new JLabel("Username - ");
        lblNametag.setBounds(750 , 420 , 100 , 30);
        lblNametag.setFont(new Font("Courier" , Font.PLAIN , 22));
        lblNametag.setForeground(Color.white);
        //Edit ID tag label
        JLabel lblIDtag = new JLabel("ID - ");
        lblIDtag.setBounds(850 , 460 , 100 , 30);
        lblIDtag.setFont(new Font("Courier" , Font.PLAIN , 22));
        lblIDtag.setForeground(Color.white);





        //Edit ID
        lblID.setBounds(900 , 460 , 200 , 30);
        lblID.setFont(new Font("Courier" , Font.PLAIN , 22));
        lblID.setForeground(Color.white);


        //Constructor for "Add" Button
        btnAdd.setBounds(530 , 540 , 120 , 35);
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
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String userType = rdoAdmin.isSelected() ? "ADMIN" : "STAFF";
                    UserInteractions.addUser(txtUsername.getTextData() , txtPassword.getTextData() , txtID.getTextData() , userType);
                    System.out.println("Successfully Added");
                    DataManager.refreshUserData(model);
                }
                catch (Exception error){ System.out.println("btnAdd " +error);}
            }
        });

        //Constructor for "Edit" Button
        btnEdit.setBounds(850 , 510 , 90 , 30);
        btnEdit.setBackground(Color.decode("#FF6767"));
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setContentAreaFilled(false);
        btnEdit.setBorder(new LineBorder(Color.decode("#242B40") , 2));
        btnEdit.setOpaque(true);
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnEdit.setBackground(Color.white);
                btnEdit.setForeground(Color.decode("#FF6767"));
            }
        });
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnEdit.setBackground(Color.decode("#FF6767"));
                btnEdit.setForeground(Color.white);
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI.showUserEditDialog(currentUser);
            }
        });

        //Constructor for "Delete" Button
        btnDelete.setBounds(950 , 510 , 90 , 30);
        btnDelete.setBackground(Color.decode("#FFB031"));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setBorder(new LineBorder(Color.decode("#242B40") , 2));
        btnDelete.setOpaque(true);
        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnDelete.setBackground(Color.white);
                btnDelete.setForeground(Color.decode("#FFB031"));
            }
        });
        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnDelete.setBackground(Color.decode("#FFB031"));
                btnDelete.setForeground(Color.white);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UserInteractions.deleteUser(model.getValueAt(tblData.getSelectedRow(), 0).toString(),
                            Integer.parseInt(model.getValueAt(tblData.getSelectedRow(), 1).toString()));
                    model.removeRow(tblData.getSelectedRow());
                    DataManager.refreshUserData(model);
                    model.fireTableDataChanged();

                }catch (Exception err){System.out.println(err);}
            }
        });


        setLayout(null);
        setBackground(Color.decode("#181f2e"));
        setBounds(0 , 0 , 1200 , 700);
        setFocusable(true);
        add(Admin_main);
        add(btnManagemovies);
        add(btnManageSeatPlan);
        add(btnManageUsers);
        add(btnReport);
        add(lblCinemaname1);
        add(lblCinemaname);
        add(btnLogOut);
        add(Users_in_database);
        add(scrollPane);
        add(txtUsername);
        add(txtPassword);
        add(txtID);
        add(btnAdd);
        add(lblUsername);
        add(lblNametag);
        add(lblIDtag);
        add(lblID);
        add(btnEdit);
        add(btnDelete);
        add(rdoAdmin);
        add(rdoStaff);



    }

    public class HintTextField extends JTextField implements FocusListener
    {
        private String hint;
        private boolean showingHint;

        public HintTextField (String hint)
        {
            super(hint);
            this.hint = hint;
            showingHint = true;
            addFocusListener(this);
        }

        @Override
        public void focusGained(FocusEvent e) {
            if(getText().equals(hint))
            {
                setText("");
                showingHint = false;
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if(getText().length() == 0)
            {
                setText(hint);
                showingHint = true;
            }
        }
        public String getTextData()
        {
            String text = this.getText();
            if(text.equals(hint))
            {
                text = "";
            }
           return text;
        }
    }

    public class ButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == btnLogOut)
            {
                Login_Form frmLogin = new Login_Form();
                Admin_Manage_Users.window.dispose();
            }
            else if(e.getSource() == btnManagemovies)
            {
                Admin_Manage_Movies frmManageMovies = new Admin_Manage_Movies();
                Admin_Manage_Users.window.dispose();
            }
            else if(e.getSource() == btnManageSeatPlan)
            {
                Admin_Manage_Seat_Plan frmManageSeatPlane = new Admin_Manage_Seat_Plan();
                Admin_Manage_Users.window.dispose();
            }
            else if(e.getSource() == btnAdd)
            {
                String username = txtUsername.getTextData();
                String password = txtPassword.getTextData();
                String id = txtID.getTextData();


                model.fireTableDataChanged();


            }
            else if(e.getSource() == btnDelete)
            {
                int idToDelete = Integer.parseInt((String) model.getValueAt(tblData.getSelectedRow(), 1));
                String sql = "DELETE FROM `Cinema`.`tblUsers` WHERE (`userID` = '" +  idToDelete + "');";
                System.out.println("You are about to delete user " + idToDelete);
                try {
                    Connection conn = DataManager.getConnection();
                    Statement stm = conn.createStatement();
                    stm.execute(sql);
                } catch (Exception err){
                    System.out.println(err);
                }
            }
            else if(e.getSource() == btnEdit)
            {

            }
        }

    }


}
