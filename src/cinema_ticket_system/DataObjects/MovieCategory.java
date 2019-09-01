package cinema_ticket_system.DataObjects;

public class MovieCategory {
    private  int categoryID;
    private   String categoryName;

    public MovieCategory(int categoryID , String categoryName)
    {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }


    public  int getCategoryID() {
        return categoryID;
    }

    public  void setCategoryID(final int categoryID) {
        this.categoryID = categoryID;
    }

    public  String getCategoryName() {
        return categoryName;
    }

    public  void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }
}
