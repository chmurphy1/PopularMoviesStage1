package murphy.christopher.popularmoviesstage1.util;

/*
 * The purpose of this class is for the
 * creation of constants.  Anything language
 * dependent should not goi in here.
 */
public class Constants {

    public static final String BASE_URL = "http://api.themoviedb.org/";
    public static final String MOVIE_URL_W185 = "http://image.tmdb.org/t/p/w185/";

    public static final int TOP_RATED = 1;
    public static final int POPULAR_MOVIES = 0;

    //This should be moved into a property file later for
    //localization
    public static final String DATE_FORMAT = "MMMM d, yyyy";
}
