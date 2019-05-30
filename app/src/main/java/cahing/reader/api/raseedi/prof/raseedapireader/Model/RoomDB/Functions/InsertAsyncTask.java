package cahing.reader.api.raseedi.prof.raseedapireader.Model.RoomDB.Functions;

import android.app.Activity;
import android.app.ProgressDialog;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import cahing.reader.api.raseedi.prof.raseedapireader.Activities.MainActivity;
import cahing.reader.api.raseedi.prof.raseedapireader.Model.AdsEntity;
import cahing.reader.api.raseedi.prof.raseedapireader.Model.RoomDB.AppDatabase;
import cahing.reader.api.raseedi.prof.raseedapireader.R;

/**
 * Created by Prof-Mohamed Atef on 30/05/2019.
 * For Data Manipulation in the Background Thread
 */

public class InsertAsyncTask extends AsyncTask<Void, Void, Boolean>{

    private final String LOG_TAG = InsertAsyncTask.class.getSimpleName();

    private final onInsertCompleted onInsertCompletion;
    private final List<AdsEntity> adsList;
    private final AppDatabase database;
    private final Context mContext;
    private final ProgressDialog dialog;
    private final AdsEntity oneAdEntity;
    private Activity activity;
    private LiveData<List<AdsEntity>> adsRoomList;
    private String NULL_KEY="null";
    private List<AdsEntity> adsList_x;

    public InsertAsyncTask(AppDatabase mDatabase, List<AdsEntity> adsEntities, onInsertCompleted onInsertCompleted, Context context) {
        this.database=mDatabase;
        this.adsList=adsEntities;
        this.onInsertCompletion=onInsertCompleted;
        this.mContext=context;
        dialog = new ProgressDialog(context);
        oneAdEntity=new AdsEntity();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        try {
            dialog.setOwnerActivity((Activity) mContext);
            activity = dialog.getOwnerActivity();
            if (dialog != null && dialog.isShowing()) {
                this.dialog.dismiss();
            }else {
                if (dialog!=null){
                    dialog.dismiss();
                    this.dialog.setMessage(mContext.getResources().getString(R.string.loading));
                    if (!activity.isFinishing()){
                        this.dialog.show();
                    }
                }else {
                    this.dialog.setMessage(mContext.getResources().getString(R.string.loading));
                    if (!activity.isFinishing()){
                        this.dialog.show();
                    }
                }
            }
        }catch (Exception e){
            Log.v(LOG_TAG, "Problem in ProgressDialogue");
        }
    }

    @Override
    protected void onPostExecute(Boolean b) {
        super.onPostExecute(b);
        if (b!=null){
            if (onInsertCompletion!=null){
                // return inserted data to UI Thread
                onInsertCompletion.onInsertComplete(adsList_x);
            }
        }
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        final boolean[] Inserted = {false};
        adsRoomList=database.adsDao().getAllAds();
        if (onInsertCompletion!=null){
            adsRoomList.observe((LifecycleOwner) onInsertCompletion, adsEntities -> {
                // try to delete if there is any previous data in D.B
                deleteInsertOperation(Inserted, adsEntities,onInsertCompletion);
            });
        }
        return Inserted[0];
    }

    private void deleteInsertOperation(boolean[] inserted, List<AdsEntity> adsEntities, onInsertCompleted onInsertCompletion) {
        if (onInsertCompletion!=null){
            if (adsEntities!=null&&adsEntities.size()>0&&!adsEntities.isEmpty()){
                // delete first if database has recorded data
                int deleted=database.adsDao().deleteAllAds();
                if (deleted>0){
                    // insert after deletion of records
                    inserted[0]=InsertAdsList();
                    if (inserted[0]){
                        inserted[0]=true;
                        adsRoomList.removeObservers((LifecycleOwner) onInsertCompletion);
                    }else {
                        inserted[0]=false;
                    }
                }else {
                    inserted[0]=InsertAdsList();
                    if (inserted[0]){
                        inserted[0]=true;
                        adsRoomList.removeObservers((LifecycleOwner) onInsertCompletion);
                    }else {
                        inserted[0]=false;
                    }
                }
            }else {
                // If no data in Ads Table, it will Insert directly
                inserted[0]=InsertAdsList();
                if (inserted[0]){
                    inserted[0]=true;
                    adsRoomList.removeObservers((LifecycleOwner) onInsertCompletion);
                }else {
                    inserted[0]=false;
                }
            }
        }
    }

    private boolean InsertAdsList() {
        long x=0;
        for (AdsEntity adsEntity:this.adsList){
            if (adsEntity.getUrl()!=null){
                oneAdEntity.setUrl(adsEntity.getUrl());
            }else {
                oneAdEntity.setUrl(NULL_KEY);
            }
            if (adsEntity.getPicture()!=null){
                oneAdEntity.setPicture(adsEntity.getPicture());
            }else {
                oneAdEntity.setPicture(NULL_KEY);
            }
            if (adsEntity.getTitle()!=null){
                oneAdEntity.setTitle(adsEntity.getTitle());
            }else {
                oneAdEntity.setTitle(NULL_KEY);
            }
            if (adsEntity.getAction()!=null){
                oneAdEntity.setAction(adsEntity.getAction());
            }else {
                oneAdEntity.setAction(NULL_KEY);
            }
            if (adsEntity.getOrder()!=null){
                oneAdEntity.setOrder(adsEntity.getOrder());
            }else {
                oneAdEntity.setOrder(NULL_KEY);
            }
            if (adsEntity.getSolo()!=null){
                oneAdEntity.setSolo(adsEntity.getSolo());
            }else {
                oneAdEntity.setSolo(NULL_KEY);
            }
            if (adsEntity.getBest_offer()!=null){
                oneAdEntity.setBest_offer(adsEntity.getBest_offer());
            }else {
                oneAdEntity.setBest_offer(NULL_KEY);
            }
            if (adsEntity.getSucess()!=null){
                oneAdEntity.setSucess(adsEntity.getSucess());
            }else {
                oneAdEntity.setSucess(NULL_KEY);
            }
            if (adsList!=null&&database!=null){
                x=database.adsDao().InsertAds(oneAdEntity);
            }
        }
        if (x>0){
            adsList_x=adsList;
            return true;
        }else {
            return false;
        }
    }

    public interface onInsertCompleted{
        void onInsertComplete(List<AdsEntity> list);
    }
}