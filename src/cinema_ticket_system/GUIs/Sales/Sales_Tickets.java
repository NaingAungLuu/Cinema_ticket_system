package cinema_ticket_system.GUIs.Sales;
import cinema_ticket_system.Controllers.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class Sales_Tickets extends JPanel{
    public static final String btnLOGOUT = "btnLogOut";
    public static final String btnTICKETS = "btnTickets";
    public static JFrame window = new JFrame("Tickets");
    public static ImageIcon imgMovieOne ;
    public static JPanel content = new JPanel();

    public static ImageIcon scaleImage (ImageIcon icon, int w, int h)
    {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if(icon.getIconWidth() > w)
        {
            nw = w;
            nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if(nh > h)
        {
            nh = h;
            nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_SMOOTH));
    }

    public Sales_Tickets()
    {
        /**
         *
            Movie 1
         *
         */
        final JLabel imgMovie1 = new JLabel();
        ImageIcon imgMovieone = new ImageIcon("movie1.jpg");
        imgMovie1.setIcon(scaleImage(imgMovieone , 269 , 381));
        imgMovie1.setHorizontalAlignment(JLabel.CENTER);
        imgMovie1.setBounds(280, 100 , 269 , 381);
        imgMovie1.setBorder(new LineBorder(Color.white , 2));
        JLabel lblMovie1Name = new JLabel("Aquaman");
        lblMovie1Name.setBounds(280, 501, 100 , 30);
        lblMovie1Name.setFont(new Font("Courier" , Font.PLAIN , 20));
        lblMovie1Name.setForeground(Color.white);
        JLabel lblMovie1Theatre = new JLabel("Theatre 1 , 2");
        lblMovie1Theatre.setBounds(280, 551, 150 , 30);
        lblMovie1Theatre.setForeground(Color.white);
        lblMovie1Theatre.setFont(new Font("Courier" , Font.PLAIN , 18));

        imgMovie1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    GUI.show(GUI.SALES_SEATS , new Object[]{1,true});
                } catch (UnsupportedLookAndFeelException e1) {
                    e1.printStackTrace();
                }
            }
        });
        imgMovie1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                imgMovie1.setBorder(new LineBorder(Color.decode("#75CBE6") , 3));

            }}
        );
        imgMovie1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                imgMovie1.setBorder(new LineBorder(Color.white , 1));
            }});

        /**
         *
            Movie 2
         *
         */
        final JLabel imgMovie2 = new JLabel();
        ImageIcon imgMovietwo = new ImageIcon("movie2.jpg");
        imgMovie2.setIcon(scaleImage(imgMovietwo , 269 , 381));
        imgMovie2.setHorizontalAlignment(JLabel.CENTER);
        imgMovie2.setBounds(569 , 100 , 269 , 381);
        imgMovie2.setBorder(new LineBorder(Color.white , 1));
        JLabel lblMovie2Name = new JLabel("Oh My Ghost");
        lblMovie2Name.setBounds(569 , 501, 150 , 30);
        lblMovie2Name.setFont(new Font("Courier" , Font.PLAIN , 20));
        lblMovie2Name.setForeground(Color.white);
        JLabel lblMovie2Theatre = new JLabel ("Theatre 3");
        lblMovie2Theatre.setBounds(569 , 551, 150 , 30);
        lblMovie2Theatre.setFont(new Font("Courier" , Font.PLAIN , 18));
        lblMovie2Theatre.setForeground(Color.white);

        imgMovie2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    GUI.show(GUI.SALES_SEATS , new Object[]{2,true});
                } catch (UnsupportedLookAndFeelException e1) {
                    e1.printStackTrace();
                }
            }
        });
        imgMovie2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                imgMovie2.setBorder(new LineBorder(Color.decode("#75CBE6") , 3));
            }
        });
        imgMovie2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                imgMovie2.setBorder(new LineBorder(Color.white , 1));
            }
        });


        /**
         *
            Movie 3
         *
         */
        final JLabel imgMovie3 = new JLabel();
        ImageIcon imgMoviethree = new ImageIcon("movie3.jpg");
        imgMovie3.setIcon(scaleImage(imgMoviethree , 269 , 381));
        imgMovie3.setHorizontalAlignment(JLabel.CENTER);
        imgMovie3.setBounds(858 , 100 , 269 , 381);
        imgMovie3.setBorder(new LineBorder(Color.white , 1));
        JLabel lblMovie3Name = new JLabel("How to train your dragon");
        lblMovie3Name.setBounds(858, 501, 400 , 30);
        lblMovie3Name.setFont(new Font("Courier" , Font.PLAIN , 20));
        lblMovie3Name.setForeground(Color.white);
        JLabel lblMovie3Theatre = new JLabel("Theatre 4");
        lblMovie3Theatre.setBounds(858, 551, 400 , 30);
        lblMovie3Theatre.setFont(new Font("Courier" , Font.PLAIN , 18));
        lblMovie3Theatre.setForeground(Color.white);

        imgMovie3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    GUI.show(GUI.SALES_SEATS , new Object[]{3,false});
                } catch (UnsupportedLookAndFeelException e1) {
                    e1.printStackTrace();
                }
            }
        });
        imgMovie3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                imgMovie3.setBorder(new LineBorder(Color.decode("#75CBE6") , 3));
            }
        });
        imgMovie3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                imgMovie3.setBorder(new LineBorder(Color.white , 1));
            }
        });


        setLayout(null);
        setBackground(Color.decode("#242B40"));
        setBounds(0 , 0 , 1200 , 700);
        add(lblMovie1Name);
        add(lblMovie1Theatre);
        add(imgMovie1);
        add(lblMovie2Name);
        add(imgMovie2);
        add(lblMovie2Theatre);
        add(lblMovie3Theatre);
        add(lblMovie3Name);
        add(imgMovie3);

    }


}
