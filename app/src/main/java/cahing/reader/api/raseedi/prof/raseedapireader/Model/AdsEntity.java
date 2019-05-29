package cahing.reader.api.raseedi.prof.raseedapireader.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.net.IDN;

/**
 * Created by Prof-Mohamed Atef on 28/05/2019.
 * Pojo class used as getter/setter and DB Table for Cashing using Room
 */

@Entity(tableName = "Ads")
public class AdsEntity implements Serializable{

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    public int ID;

    @NonNull
    @ColumnInfo(name = "picture")
    public String picture ;

    @NonNull
    @ColumnInfo(name = "action")
    public String action;

    @NonNull
    @ColumnInfo(name = "title")
    public String title ;

    @NonNull
    @ColumnInfo(name = "url")
    public String url ;

    @NonNull
    @ColumnInfo(name = "solo")
    public boolean solo ;

    @NonNull
    @ColumnInfo(name = "best_offer")
    public boolean best_offer ;

    @NonNull
    @ColumnInfo(name = "sucess")
    public boolean sucess ;

    @NonNull
    @ColumnInfo(name = "order")
    public int order ;

    public AdsEntity() {
    }

    public AdsEntity(String picture, String action, String title, String url, boolean solo, boolean best_offer, boolean sucess, int order) {
        this.picture = picture;
        this.action = action;
        this.title = title;
        this.url = url;
        this.solo = solo;
        this.best_offer = best_offer;
        this.sucess = sucess;
        this.order = order;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isSolo() {
        return solo;
    }

    public void setSolo(boolean solo) {
        this.solo = solo;
    }

    public boolean isBest_offer() {
        return best_offer;
    }

    public void setBest_offer(boolean best_offer) {
        this.best_offer = best_offer;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}