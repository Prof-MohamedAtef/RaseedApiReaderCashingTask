package cahing.reader.api.raseedi.prof.raseedapireader.Activities;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.List;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import cahing.reader.api.raseedi.prof.raseedapireader.Adapter.AdsRecyclerViewAdapter;
import cahing.reader.api.raseedi.prof.raseedapireader.Model.AdsEntity;
import cahing.reader.api.raseedi.prof.raseedapireader.Model.ViewModel.AdsViewModel;
import cahing.reader.api.raseedi.prof.raseedapireader.R;
import cahing.reader.api.raseedi.prof.raseedapireader.Retrofit.MyAPiInterface;
import cahing.reader.api.raseedi.prof.raseedapireader.Retrofit.RetrofitClient;
import cahing.reader.api.raseedi.prof.raseedapireader.helpers.VerifyConnection;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    MyAPiInterface myAPiInterface;
    CompositeDisposable compositeDisposable;
    private Disposable disposable;
    private long DELAY=1000;
    private long PERIOD=5000;
    private AdsViewModel adsViewModel;

    @Override
    protected void onStop() {
        super.onStop();
        compositeDisposable.clear();
    }

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Init API
        Retrofit retrofit= RetrofitClient.getInstance();
        myAPiInterface=retrofit.create(MyAPiInterface.class);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        VerifyConnection verifyConnection=new VerifyConnection(getApplicationContext());
        if (verifyConnection.isConnected()){
            fetchAds();
        }else {
            // get data from database
            // will be added to develop branch
            // will also be added to feature branch -- added
            // will depend on ViewModel beyond LiveData
            getAdsFromDB();
        }
    }

    private void getAdsFromDB() {
        adsViewModel= ViewModelProviders.of( this).get(AdsViewModel.class);
        if (adsViewModel!=null){
            adsViewModel.getmObserverMediatorLiveDataAdsList().observe(this, new Observer<List<AdsEntity>>() {
                @Override
                public void onChanged(@Nullable List<AdsEntity> adsEntities) {
                    if (adsEntities!=null){
                        if (adsEntities.size()>0){
                            populateRecyclerView(adsEntities);
                        }
                    }
                }
            });
        }

    }

    private void fetchAds() {
        compositeDisposable= new CompositeDisposable();
        compositeDisposable.add(myAPiInterface.getAds()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<List<AdsEntity>>() {
            @Override
            public void accept(List<AdsEntity> adsEntities) throws Exception {

                populateRecyclerView(adsEntities);
            }
        }));
    }

    private void populateRecyclerView(List<AdsEntity> adsEntities) {
        AdsRecyclerViewAdapter adapter=new AdsRecyclerViewAdapter(getApplicationContext(),adsEntities,false);
        recyclerView.setAdapter(adapter);
    }
}