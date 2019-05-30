package cahing.reader.api.raseedi.prof.raseedapireader.Model.RoomDB.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import cahing.reader.api.raseedi.prof.raseedapireader.Model.AdsEntity;

/**
 * Created by Prof-Mohamed Atef on 28/05/2019.
 * queries are written in the Dao Interface
 */

@Dao
public interface AdsDao {
    @Insert
    long InsertAds(AdsEntity adsEntity);

    @Query("SELECT * FROM Ads ORDER BY 'order' ASC")
    LiveData<List<AdsEntity>> getAllAds();

    @Query("DELETE FROM Ads")
    abstract int deleteAllAds();
}
