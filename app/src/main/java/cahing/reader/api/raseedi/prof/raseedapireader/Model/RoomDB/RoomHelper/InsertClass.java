package cahing.reader.api.raseedi.prof.raseedapireader.Model.RoomDB.RoomHelper;

import android.content.Context;

import java.util.List;

import cahing.reader.api.raseedi.prof.raseedapireader.Activities.MainActivity;
import cahing.reader.api.raseedi.prof.raseedapireader.Model.AdsEntity;
import cahing.reader.api.raseedi.prof.raseedapireader.Model.RoomDB.AppDatabase;
import cahing.reader.api.raseedi.prof.raseedapireader.Model.RoomDB.Functions.InsertAsyncTask;
import io.reactivex.functions.Consumer;

/**
 * Created by Prof-Mohamed Atef on 30/05/2019.
 */

public class InsertClass {

    public void MakeInsert(AppDatabase mDatabase, List<AdsEntity> adsEntities, MainActivity mainActivity, Context mContext) {
        InsertAsyncTask insertAsyncTask=new InsertAsyncTask(mDatabase,adsEntities,mainActivity, mContext);
        //execute in the Background Thread
        insertAsyncTask.execute();
    }
}
