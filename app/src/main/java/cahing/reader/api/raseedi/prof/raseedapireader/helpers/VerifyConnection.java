package cahing.reader.api.raseedi.prof.raseedapireader.helpers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Prof-Mohamed Atef on 28/05/2019.
 */

public class VerifyConnection {
    private Context mContext;
    public  VerifyConnection(Context context){
        this.mContext=context;
    }

    public boolean isInternetConnected;

    public boolean checkConnection() {
        return isInternetConnected=isConnected();
    }

    public boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) this.mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork!=null){
            return isInternetConnected= activeNetwork.isConnected();
        }else
            return isInternetConnected=false;
    }


}
