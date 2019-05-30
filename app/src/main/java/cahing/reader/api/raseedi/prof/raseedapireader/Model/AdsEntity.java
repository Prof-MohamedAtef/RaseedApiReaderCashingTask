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
    public String solo ;

    @NonNull
    @ColumnInfo(name = "best_offer")
    public String best_offer ;

    @NonNull
    @ColumnInfo(name = "sucess")
    public String sucess ;

    @NonNull
    @ColumnInfo(name = "order")
    public String order ;

    public AdsEntity() {
    }

    public AdsEntity(String picture, String action, String title, String url, String solo, String best_offer, String sucess, String order) {
        this.picture = picture;
        this.action = action;
        this.title = title;
        this.url = url;
        this.solo = solo;
        this.best_offer = best_offer;
        this.sucess = sucess;
        this.order = order;
    }

    @NonNull
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @NonNull
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NonNull
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @NonNull
    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @NonNull
    public String getSolo() {
        return solo;
    }

    public void setSolo(@NonNull String solo) {
        this.solo = solo;
    }

    @NonNull
    public String getBest_offer() {
        return best_offer;
    }

    public void setBest_offer(@NonNull String best_offer) {
        this.best_offer = best_offer;
    }

    @NonNull
    public String getSucess() {
        return sucess;
    }

    public void setSucess(@NonNull String sucess) {
        this.sucess = sucess;
    }
}