package cinema_ticket_system.GUIs.Admin;
import cinema_ticket_system.Controllers.MovieShowTimeDelegate;
import cinema_ticket_system.Controllers.UserInteractions;
import com.github.lgooddatepicker.components.DateTimePicker;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Admin_Manage_Movies_Edit_Show_Times{

    static JPanel content = new JPanel();
    static JFrame window  = new JFrame();
    static JButton btnSave = new JButton("Save");
    ButtonHandler buttons = new ButtonHandler();
    static String[] showtimes = {"9:00am" , "11:30am" , "1.30pm" , "3:00pm" , "5:00pm" , "7:00pm"};
    static ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
    public DateTimePicker dateTimePicker;

    private static Admin_Manage_Movies_Edit_Show_Times objInstance;

    public static void main(String[] arg)
    {
        Admin_Manage_Movies_Edit_Show_Times frmshowtimes = new Admin_Manage_Movies_Edit_Show_Times(null);
    }

    public static Admin_Manage_Movies_Edit_Show_Times getObjInstance(MovieShowTimeDelegate delegate)
    {
        if(objInstance == null)
        {
            objInstance = new Admin_Manage_Movies_Edit_Show_Times(delegate);
        }
        objInstance.window.setVisible(true);
        return objInstance;

    }


    private Admin_Manage_Movies_Edit_Show_Times(MovieShowTimeDelegate delegate)
    {
        //Constructor for JCheckBoxes

        int i = 0;
        for(String showtime : showtimes)
        {
            String text = "\t\t" + showtime;
            JCheckBox chk = new JCheckBox();
            chk.setName("chk" + i);
            chk.setBounds(50 , 16+(i*40) , text.length()*15 , 40);
            chk.setText(text);
            chk.setForeground(Color.white);
            chk.setFont(new Font("Arial" , Font.BOLD , 20));
            content.add(chk);
            checkBoxes.add(chk);
            i++;
        }

        //Constructor for Show times panel
        btnSave.setBounds(50 , 270 , 135 , 50);
        btnSave.setBackground(Color.decode("#FF6767"));
        btnSave.setForeground(Color.WHITE);
        btnSave.setContentAreaFilled(false);
        btnSave.setBorder(new LineBorder(Color.decode("#242B40") , 2));
        btnSave.setOpaque(true);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                delegate.onTapSave(window);
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


        content.setLayout(null);
        content.setBackground(Color.decode("#242B40"));
        content.add(btnSave);


        //Constructor for Edit JFrame
        window.setContentPane(content);
        window.setSize(230 , 370);
        window.setLocation(450 , 300);
        window.setVisible(true);
        window.setLocationRelativeTo(null);



    }

    public String getShowTimeData()
    {
        String showTimeData = "";
        for(int i = 0 ; i<checkBoxes.size() ; i++)
        {
            showTimeData += (checkBoxes.get(i).isSelected()) ? showtimes[i]+"," : "";
            System.out.println(showTimeData);
        }
        return showTimeData;
    }


    public static class ButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == btnSave)
            {
                window.dispose();
                window.setAlwaysOnTop(false);
                Admin_Manage_Movies_Edit.window.setEnabled(true);
                UserInteractions.getCheckBoxData(checkBoxes);
            }

        }
    }

}
