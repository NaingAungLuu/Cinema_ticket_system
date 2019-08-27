package cinema_ticket_system.DataObjects;

public class User extends DataObject{
    private static int userID;
    private static String userName;
    private static String password;
    private static String userType;

    public User()
    {

    }

    public User(int userID , String userName , String password)
    {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
    }

    public User(int userID , String userName , String password , String userType)
    {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }

    public static int getUserID() {
        return User.userID;
    }

    public static void setUserID(final int userID) {
        User.userID = userID;
    }

    public static String getUserName() {
        return User.userName;
    }

    public static void setUserName(final String userName) {
        User.userName = userName;
    }

    public static String getPassword() {
        return User.password;
    }

    public static void setPassword(final String password) {
        User.password = password;
    }

    public static String getUserType() {
        return User.userType;
    }

    public static void setUserType(final String userType) {
        User.userType = userType;
    }
}
