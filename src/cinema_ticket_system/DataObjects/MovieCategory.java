package cinema_ticket_system.DataObjects;

public class MovieCategory {
    private static  int categoryID;
    private static  String categoryName;

    public MovieCategory(int categoryID , String categoryName)
    {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }


    public static int getCategoryID() {
        return MovieCategory.categoryID;
    }

    public static void setCategoryID(final int categoryID) {
        MovieCategory.categoryID = categoryID;
    }

    public static String getCategoryName() {
        return MovieCategory.categoryName;
    }

    public static void setCategoryName(final String categoryName) {
        MovieCategory.categoryName = categoryName;
    }
}
