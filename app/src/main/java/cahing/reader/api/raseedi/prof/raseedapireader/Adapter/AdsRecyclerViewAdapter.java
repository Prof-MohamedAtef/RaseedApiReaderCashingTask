package cahing.reader.api.raseedi.prof.raseedapireader.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cahing.reader.api.raseedi.prof.raseedapireader.Activities.WebViewActivity;
import cahing.reader.api.raseedi.prof.raseedapireader.Model.AdsEntity;
import cahing.reader.api.raseedi.prof.raseedapireader.R;

/**
 * Created by Prof-Mohamed Atef on 28/05/2019.
 * used to populate Recycler View with ListOfAds
 */

public class AdsRecyclerViewAdapter extends RecyclerView.Adapter<AdsRecyclerViewAdapter.ViewHOlder> implements Serializable{

    Context mContext;
    List<AdsEntity> feedItemList;
    boolean TwoPane;
    private String BaseImage;
    public static String AdUrl="AdURL";

    public AdsRecyclerViewAdapter(Context mContext, List<AdsEntity> feedItemList, boolean twoPane) {
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
                            if (feedItem.getUrl()!=null){
                                final AdsEntity finalFeedItem = feedItem;
                                holder.frame.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        String url = finalFeedItem.getUrl();
                                        Intent intent = new Intent(mContext, WebViewActivity.class);
                                        intent.putExtra(AdUrl, url);
                                        mContext.startActivity(intent);
                                    }
                                });
                            }
                        }
                    } else {
                        holder.Title.setText("");
                    }

                    /*

                     */
        }
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    class ViewHOlder extends RecyclerView.ViewHolder {
        private final ImageView Image;
        private final TextView Title;
        private final FrameLayout frame;

        public ViewHOlder(View converview) {
            super(converview);
            this.Image = (ImageView) converview.findViewById(R.id.ad_image);
            this.Title=(TextView)converview.findViewById(R.id.ad_title);
            this.frame=(FrameLayout)converview.findViewById(R.id.ad_container);
        }
    }
}