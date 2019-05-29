package cahing.reader.api.raseedi.prof.raseedapireader.Model.RoomDB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import cahing.reader.api.raseedi.prof.raseedapireader.Model.AdsEntity;
import cahing.reader.api.raseedi.prof.raseedapireader.Model.RoomDB.Dao.AdsDao;

/**
 * Created by Prof-Mohamed Atef on 28/05/2019.
 */

@Database(entities = {AdsEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{
    private static AppDatabase INSTANCE;
    private static String DATABASE_NAME="Ads-database";

    public abstract AdsDao adsDao();


}
