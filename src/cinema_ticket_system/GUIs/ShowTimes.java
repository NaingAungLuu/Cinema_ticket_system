package cinema_ticket_system.GUIs;

import cinema_ticket_system.Utils.Utils;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalTime;

public class ShowTimes extends JFrame {

    DatePickerSettings startDateSettings;
    DatePicker startDatePicker;
    DatePickerSettings endDateSettings;
    DatePicker endDatePicker;
    TimePickerSettings timePickerSettings;
    TimePicker timePicker;
    JLabel lblStartDate = new JLabel("Start Date : ");
    JLabel lblEndDate = new JLabel("End Date : ");
    JLabel lblShowTimes = new JLabel("Show Times : ");

    double baseWidth = 800;
    double baseHeight = 500;

    private static ShowTimes objInstance;

    public static ShowTimes getObjectInstance()
    {
        if(objInstance == null)
        {
            objInstance = new ShowTimes();
        }
        return objInstance;
    }

    public static void main(String[] args)
    {
        ShowTimes.getObjectInstance();
    }


    private ShowTimes(){
        double widthRatio = getWidth()/baseWidth;
        double heightRatio = getHeight()/baseHeight;

        JPanel pnlMain = new JPanel();
        //setting up right panel
        JPanel pnlDateTime = new JPanel();
        pnlDateTime.setBounds(400 , 0 , 400 , 500);
        pnlDateTime.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        pnlDateTime.setBackground(Color.decode("#181f2e"));

        //Start date label
        lblStartDate.setBounds(20 , 0 , 100 , 40);
        lblStartDate.setFont(new Font("Courier", Font.PLAIN, 14));
        lblStartDate.setForeground(Color.decode("#75CBE6"));
        cons.gridx = 0;
        cons.gridy = 0;
        cons.insets = new Insets(0 , 20 , 0 , 20);
        pnlDateTime.add(lblStartDate , cons);

        //Start Date Picker
        startDateSettings = new DatePickerSettings();
        startDatePicker = new DatePicker(startDateSettings);
        startDatePicker.setBounds(120, 50 ,310 , 40);
        startDatePicker.setDateToToday();
        JButton startDatePickerButton = startDatePicker.getComponentToggleCalendarButton();
        startDatePickerButton.setText("");
        startDatePickerButton.setIcon(Utils.scaleImage(new ImageIcon("calendar.png") , 25 , 25));
        startDatePickerButton.setBackground(Color.decode("#181f2e"));
        startDatePickerButton.setForeground(Color.WHITE);
        startDatePickerButton.setSize(50 , 50);
        startDatePickerButton.setContentAreaFilled(false);
        startDatePickerButton.setBorder(new LineBorder(Color.decode("#242B40") , 2));
        startDatePickerButton.setOpaque(true);
        startDatePickerButton.setPreferredSize(new Dimension(50 , 30));
        cons.gridx = 1;
        cons.gridy = 0;
        cons.insets = new Insets(20 , 10 , 20 , 20);
        pnlDateTime.add(startDatePicker, cons);

        //Start date label
        lblEndDate.setBounds(20 , 0 , 100 , 40);
        lblEndDate.setFont(new Font("Courier", Font.PLAIN, 14));
        lblEndDate.setForeground(Color.decode("#75CBE6"));
        cons.gridx = 0;
        cons.gridy = 1;
        cons.insets = new Insets(0 , 20 , 0 , 20);
        pnlDateTime.add(lblEndDate , cons);

        //End Date Picker
        endDateSettings = new DatePickerSettings();
        endDatePicker = new DatePicker(endDateSettings);
        endDatePicker.setBounds(120, 50 ,310 , 40);
        endDatePicker.setDateToToday();
        JButton endDatePickerButton = endDatePicker.getComponentToggleCalendarButton();
        endDatePickerButton.setText("");
        endDatePickerButton.setIcon(Utils.scaleImage(new ImageIcon("calendar.png") , 25 , 25));
        endDatePickerButton.setBackground(Color.decode("#181f2e"));
        endDatePickerButton.setForeground(Color.WHITE);
        endDatePickerButton.setSize(50 , 50);
        endDatePickerButton.setContentAreaFilled(false);
        endDatePickerButton.setBorder(new LineBorder(Color.decode("#242B40") , 2));
        endDatePickerButton.setOpaque(true);
        endDatePickerButton.setPreferredSize(new Dimension(50 , 30));


        cons.gridx = 1;
        cons.gridy = 1;
        cons.insets = new Insets(20 , 10 , 20 , 20);
        pnlDateTime.add(endDatePicker , cons);

        timePickerSettings = new TimePickerSettings();
        timePickerSettings.initialTime = LocalTime.of(15, 00);
        timePicker = new TimePicker(timePickerSettings);
        JButton timePickerButton = timePicker.getComponentToggleTimeMenuButton();
        timePickerButton.setText("");
        timePickerButton.setIcon(Utils.scaleImage(new ImageIcon("alarm-clock.png") , 25 , 25));
        timePickerButton.setContentAreaFilled(false);
        timePickerButton.setBackground(Color.decode("#181f2e"));
        timePickerButton.setBorder(new LineBorder(Color.decode("#242B40") , 2));
        timePickerButton.setOpaque(true);
        Dimension newTimeButtonSize = new Dimension(50, 30);
        timePickerButton.setPreferredSize(newTimeButtonSize);

        cons.gridx = 1;
        cons.gridy = 2;
        cons.insets = new Insets(20 , 10 , 20 , 20);
        pnlDateTime.add(timePicker , cons);

        //show time label
        lblShowTimes.setBounds(20 , 0 , 100 , 40);
        lblShowTimes.setFont(new Font("Courier", Font.PLAIN, 14));
        lblShowTimes.setForeground(Color.decode("#75CBE6"));
        cons.gridx = 0;
        cons.gridy = 2;
        cons.insets = new Insets(0 , 0 , 0 , 10);
        pnlDateTime.add(lblShowTimes , cons);

        JButton btnAddShowTime = new JButton("Add");
        btnAddShowTime.setPreferredSize(new Dimension(100 , 50));
        btnAddShowTime.setContentAreaFilled(false);
        btnAddShowTime.setBackground(Color.decode("#FF6767"));
        btnAddShowTime.setBorder(new LineBorder(Color.decode("#242B40") , 2));
        btnAddShowTime.setOpaque(true);
        cons.gridx = 1;
        cons.gridy = 4;
        cons.fill = GridBagConstraints.HORIZONTAL;
        pnlDateTime.add(btnAddShowTime);


        pnlMain.setLayout(null);
        pnlMain.setBackground(Color.decode("#242B40"));
        pnlMain.add(pnlDateTime);

        //Prepare JFrame for GUI presentation
        setSize(800 , 500);
        //JFrame size is set based on the View ID
        setLocation(450 , 300);
        setLocation(100, 100);
        setTitle("Cinema Ticket Booking System");
        setName("Cinema Ticket Booking System");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(pnlMain);
        setVisible(true);
    }


}
