package murphy.christopher.popularmoviesstage1.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 * Implement Singleton Pattern in this class
 */

public class RetrofitUtil{

    private static Retrofit retrofitInstance;
    static {
        setRetrofitInstance();
    }

    private static void setRetrofitInstance(){
        if (retrofitInstance == null) {
            retrofitInstance = new retrofit2.Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }
    public static Retrofit getRetrofitInstance(){
        return retrofitInstance;
    }
}
