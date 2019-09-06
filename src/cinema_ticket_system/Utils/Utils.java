package cinema_ticket_system.Utils;

import javax.swing.*;
import java.awt.*;

public class Utils {
    public static String cleanString(String text)
    {
        if(text.contains("'"))
        {
            text = text.substring(0, text.indexOf("'"))
                    + "''"
                    + text.substring(text.indexOf("'") + 1);
        }
        return text;
    }

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
}
