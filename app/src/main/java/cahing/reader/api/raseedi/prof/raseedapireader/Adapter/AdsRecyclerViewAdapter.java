package cahing.reader.api.raseedi.prof.raseedapireader.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import cahing.reader.api.raseedi.prof.raseedapireader.Model.AdsEntity;
import cahing.reader.api.raseedi.prof.raseedapireader.R;

/**
 * Created by Prof-Mohamed Atef on 28/05/2019.
 */

public class AdsRecyclerViewAdapter extends RecyclerView.Adapter<AdsRecyclerViewAdapter.ViewHOlder> implements Serializable{

    Context mContext;
    ArrayList<AdsEntity> feedItemList;
    boolean TwoPane;
    private String BaseImage;

    public AdsRecyclerViewAdapter(Context mContext, ArrayList<AdsEntity> feedItemList, boolean twoPane) {
        this.mContext = mContext;
        this.feedItemList = feedItemList;
        TwoPane = twoPane;
    }

    @NonNull
    @Override
    public AdsRecyclerViewAdapter.ViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ad_list_item, null);
        RecyclerView.ViewHolder viewHolder = new AdsRecyclerViewAdapter.ViewHOlder(view);
        return (AdsRecyclerViewAdapter.ViewHOlder) viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdsRecyclerViewAdapter.ViewHOlder holder, final int position) {
        AdsEntity feedItem=null;
        feedItem = feedItemList.get(position);
        if (feedItem != null) {
            if (feedItem.getTitle()!= null) {
                holder.Title.setText(feedItem.getTitle());
                        if (feedItem.getPicture()!=null){
                            BaseImage= feedItem.getPicture();
                            Picasso.with(mContext).load(BaseImage)
                                    .error(R.drawable.reload)
                                    .into(holder.Image);
                        }
                    } else {
                        holder.Title.setText("");
                    }
        }
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    class ViewHOlder extends RecyclerView.ViewHolder {
        private final ImageView Image;
        private final TextView Title;

        public ViewHOlder(View converview) {
            super(converview);
            this.Image = (ImageView) converview.findViewById(R.id.ad_image);
            this.Title=(TextView)converview.findViewById(R.id.ad_title);
        }
    }
}