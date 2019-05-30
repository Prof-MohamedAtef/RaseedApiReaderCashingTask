package cahing.reader.api.raseedi.prof.raseedapireader.Model.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import cahing.reader.api.raseedi.prof.raseedapireader.Model.AdsEntity;
import cahing.reader.api.raseedi.prof.raseedapireader.Model.Executers.BasicApp;
import cahing.reader.api.raseedi.prof.raseedapireader.helpers.Config;

/**
 * Created by Prof-Mohamed Atef on 30/05/2019.
 */

public class AdsViewModel extends AndroidViewModel {

    private final MediatorLiveData<List<AdsEntity>> mObserverMediatorLiveDataAdsList;

    public AdsViewModel(@NonNull Application application) {
        super(application);
        Config.application=application;
        this.mObserverMediatorLiveDataAdsList = new MediatorLiveData<>();
        this.mObserverMediatorLiveDataAdsList.setValue(null);
        LiveData<List<AdsEntity>> adsEntityList=((BasicApp)application).getRepository().loadAds();
        mObserverMediatorLiveDataAdsList.addSource(adsEntityList,mObserverMediatorLiveDataAdsList::setValue);
    }

    public MediatorLiveData<List<AdsEntity>> getmObserverMediatorLiveDataAdsList(){
        return mObserverMediatorLiveDataAdsList;
    }
}
