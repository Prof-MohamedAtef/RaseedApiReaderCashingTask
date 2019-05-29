package cahing.reader.api.raseedi.prof.raseedapireader.Retrofit;

import java.util.List;

import cahing.reader.api.raseedi.prof.raseedapireader.Model.AdsEntity;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Prof-Mohamed Atef on 28/05/2019.
 * try to get ads
 */

public interface MyAPiInterface {
    @GET("ads")
    Observable<List<AdsEntity>> getAds();
}
