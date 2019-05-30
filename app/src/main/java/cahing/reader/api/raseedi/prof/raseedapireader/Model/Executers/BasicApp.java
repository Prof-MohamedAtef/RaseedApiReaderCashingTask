package cahing.reader.api.raseedi.prof.raseedapireader.Model.Executers;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import cahing.reader.api.raseedi.prof.raseedapireader.Model.RoomDB.AppDatabase;
import cahing.reader.api.raseedi.prof.raseedapireader.Model.RoomDB.LiveDataRepo;

/**
 * Created by Prof-Mohamed Atef on 28/05/2019.
 */

public class BasicApp extends Application {
    private AppExecutors mAppExecutors;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(getBaseContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this, mAppExecutors);
    }

    public LiveDataRepo getRepository(){
        return LiveDataRepo.getLiveDataRepoInstance(getDatabase());
    }
}
