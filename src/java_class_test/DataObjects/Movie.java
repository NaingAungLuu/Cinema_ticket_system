package java_class_test.DataObjects;

public class Movie {
    private int movieId;
    private String movieName;
    private int categoryID;
    private int theatreNo;
    private String movieType;
    private String showTime;

    public Movie(String movieName , int category , int theatreNo, String movieType,String showTime)
    {
        this.movieName = movieName;
        this.categoryID = category;
        this.theatreNo = theatreNo;
        this.movieType = movieType;
        this.showTime = showTime;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getCategory() {
        return this.categoryID;
    }

    public void setCategory(int category) {
        this.categoryID = category;
    }

    public int getTheatreNo() {
        return this.theatreNo;
    }

    public void setTheatreNo(int theatreNo) {
        this.theatreNo = theatreNo;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getShowTime() {
        return this.showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
