package cahing.reader.api.raseedi.prof.raseedapireader.Model.RoomDB;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import java.util.List;

import cahing.reader.api.raseedi.prof.raseedapireader.Model.AdsEntity;

/**
 * Created by Prof-Mohamed Atef on 28/05/2019.
 * implementation of Observables
 */

public class LiveDataRepo {
    private static LiveDataRepo liveDataRepoInstance;
    private final AppDatabase mDatabase;

    private MediatorLiveData<List<AdsEntity>> mObservableAds;

    public LiveDataRepo(final AppDatabase database) {
        mDatabase = database;
        mObservableAds = new MediatorLiveData<>();

        mObservableAds.addSource(mDatabase.adsDao().getAllAds(),
                adsEntities -> {
                    if (mDatabase.getDatabaseCreated().getValue() != null) {
                        mObservableAds.postValue(adsEntities);
                    }
                });
    }

    public static LiveDataRepo getLiveDataRepoInstance(final AppDatabase database){
        if (liveDataRepoInstance == null) {
            synchronized (LiveDataRepo.class){
                if (liveDataRepoInstance==null){
                    liveDataRepoInstance=new LiveDataRepo(database);
                }
            }
        }
        return liveDataRepoInstance;
    }

    public LiveData<List<AdsEntity>> loadAds(){
        return mDatabase.adsDao().getAllAds();
    }
}