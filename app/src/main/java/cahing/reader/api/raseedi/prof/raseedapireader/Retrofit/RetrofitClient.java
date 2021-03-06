package cahing.reader.api.raseedi.prof.raseedapireader.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Prof-Mohamed Atef on 28/05/2019.
 * From which JsonData will be obtained
 * get Instance of the client
 */

public class RetrofitClient {

    private static Retrofit ourInstance=null;
    private static String BASE_URL="https://simswitch.bit68.com/";

    public static Retrofit getInstance() {
        if (ourInstance==null)

            ourInstance=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        return ourInstance;
    }

    private RetrofitClient() {
    }
}
