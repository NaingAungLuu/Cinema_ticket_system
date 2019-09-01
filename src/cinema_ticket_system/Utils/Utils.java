package cinema_ticket_system.Utils;

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
}
