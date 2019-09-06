package cinema_ticket_system.DataObjects;

public class Movie extends DataObject{
    private static int movieId;
    private static String movieName;
    private static int categoryID;
    private static String categoryName;
    private static int theatreNo;
    private static String movieType;
    private static String showTime;
    private static String moviePosterPath;

    public static String getCategoryName() {
        return Movie.categoryName;
    }

    public static void setCategoryName(final String categoryName) {
        Movie.categoryName = categoryName;
    }




    public Movie(String movieName , String categoryName , int theatreNo, String movieType, String showTime)
    {
        this.movieName = movieName;
        this.categoryName = categoryName;
        this.theatreNo = theatreNo;
        this.movieType = movieType;
        this.showTime = showTime;
    }

    public Movie(){}

    public Movie(String movieName , String category)
    {
        this.movieName = movieName;
        this.categoryID = categoryID;
    }

    public boolean isDataConsistent(Movie movie)
    {
        if(movie.getMovieName()!= null
                && movie.getMovieType() != null
                && movie.getShowTime() != null
                && movie.getTheatreNo() != 0
                && movie.getCategoryName() != null)
        {
            return true;
        }
        else
        {
            System.out.println("daata is inconsistent");
            return false;
        }
    }


    public static int getMovieId() {
        return movieId;
    }

    public static void setMovieId(int movieId) {
        Movie.movieId = movieId;
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

    public static String getMoviePosterPath() {
        return Movie.moviePosterPath;
    }

    public static void setMoviePosterPath(final String moviePosterPath) {
        Movie.moviePosterPath = moviePosterPath;
    }
}
