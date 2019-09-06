package cinema_ticket_system.GUIs.Admin;
import cinema_ticket_system.Controllers.MovieEditFormDelegate;
import cinema_ticket_system.Controllers.MovieShowTimeDelegate;
import cinema_ticket_system.DataObjects.Movie;
import cinema_ticket_system.Utils.Utils;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Admin_Manage_Movies_Edit implements MovieShowTimeDelegate {
    public static JFrame window = new JFrame();
    String showtimes[] = {"9:00am" , "11:30am" , "1.30pm" , "3:00pm" , "5:00pm" , "7:00pm"};
    static JButton btnShowTime = new JButton("Show Times");
    static JButton btnSave = new JButton("Save");
    static JPanel content = new JPanel();
    private static Admin_Manage_Movies_Edit objInstance ;
    private static String[] selectedTime= {"Time 1 " , "Time 2" , "Time 3"};

    private static JTextArea txtMovieName = new JTextArea();
    private static JComboBox<String> cboTheatreNo = new JComboBox<>();
    private static JRadioButton rdo2d = new JRadioButton("2D" , false);
    private static JRadioButton rdo3d = new JRadioButton("3D" , true);
    ButtonGroup btnGp = new ButtonGroup();
    public static int movieId = 0;

    private static Movie updateMovieData = new Movie();
    private Admin_Manage_Movies_Edit_Show_Times mShowTimeDialog;
    private MovieEditFormDelegate mDelegate;

    public static Admin_Manage_Movies_Edit getObjInstance(MovieEditFormDelegate mDelegate)
    {
        if(objInstance == null)
        {
            objInstance = new Admin_Manage_Movies_Edit(mDelegate);
        }
        objInstance.window.setVisible(true);
        return objInstance;
    }

    public static void setMovieId(int MovieID)
    {
        movieId = MovieID;
    }

    public static Movie getUpdateData()
    {
        updateMovieData.setMovieName(Utils.cleanString(txtMovieName.getText()));
        updateMovieData.setCategoryName("Action");
        updateMovieData.setTheatreNo(cboTheatreNo.getSelectedIndex()+1);
        updateMovieData.setMovieType(rdo3d.isSelected() ? "3D" : "2D");
        updateMovieData.setMovieId(movieId);
        updateMovieData.setCategoryName("Action");
        return  updateMovieData;
    }

    private Admin_Manage_Movies_Edit(MovieEditFormDelegate delegate)
    {


        txtMovieName.setBounds(40 , 30, 350 , 50 );
        txtMovieName.setBackground(Color.decode("#D5D3D3"));
        txtMovieName.setFont(new Font("Arial" , Font.PLAIN , 16 ));
        txtMovieName.setLineWrap(true);
        txtMovieName.setMargin(new Insets(2 , 5 , 2 , 5 ));

        btnShowTime.setBackground(Color.decode("#D5D3D3"));
        btnShowTime.setContentAreaFilled(false);
        btnShowTime.setBounds(38 , 90 , 200 , 40);
        btnShowTime.setOpaque(true);
        btnShowTime.setBorder(new LineBorder(Color.decode("#D5D3D3") , 2));
        btnShowTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                getShowTimesDialog();
            }
        });


        btnSave.setBounds(255 , 125 , 135 , 40);
        btnSave.setBackground(Color.decode("#FF6767"));
        btnSave.setForeground(Color.WHITE);
        btnSave.setContentAreaFilled(false);
        btnSave.setBorder(new LineBorder(Color.decode("#242B40") , 2));
        btnSave.setOpaque(true);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                delegate.onSave(window);
            }
        });
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


        cboTheatreNo.setBackground(Color.decode("#D5D3D3"));
        cboTheatreNo.setBounds(38 , 140 , 200 , 20 );
        cboTheatreNo.addItem("Theatre 1 , 2");
        cboTheatreNo.addItem("Theatre 3");
        cboTheatreNo.addItem("Theatre 4");


        btnGp.add(rdo2d);
        btnGp.add(rdo3d);
        rdo2d.setBounds(240 , 90 , 60 , 30);
        rdo3d.setBounds(300 , 90 , 60 , 30);
        rdo2d.setFont(new Font("Nadeem" , Font.BOLD , 20 ) );
        rdo3d.setFont(new Font("Nadeem" , Font.BOLD , 20));
        rdo2d.setForeground(Color.white);
        rdo3d.setForeground(Color.white);

        //Constructor for JPanel
        content.setLayout(null);
        content.setBackground(Color.decode("#242B40"));
        content.add(txtMovieName);
        content.add(btnShowTime);
        content.add(cboTheatreNo);
        content.add(rdo2d);
        content.add(rdo3d);
        content.add(btnSave);

        //Constructor for Edit JFrame
        window.setContentPane(content);
        window.setSize(430 , 220);
        window.setLocation(450 , 300);
        window.setVisible(true);
        window.setLocationRelativeTo(null);

    }
    private void getShowTimesDialog()
    {
        mShowTimeDialog = Admin_Manage_Movies_Edit_Show_Times.getObjInstance(this);
    }

    @Override
    public void onTapSave(JFrame frame) {
        updateMovieData.setShowTime(mShowTimeDialog.getShowTimeData());
        frame.dispose();
    }

}
