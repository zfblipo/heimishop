package com.lipo.heimishop.beans;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by lipo on 2017/6/7.
 */

public class ImageInfo implements Serializable {

    public String id;
    public String g_id;
    public String thumb;
    public String link;

    public ImageInfo(){

    }

    public ImageInfo(String thumb){
        this.thumb = thumb;
    }

    public ImageInfo(String id, String thumb, String link){
        this.id = id;
        this.thumb = thumb;
        this.link = link;
    }

    public static ImageInfo fromJson(JSONObject json){
        ImageInfo info = new ImageInfo();
        info.id = json.optString("id");
        info.g_id = json.optString("g_id");
        info.thumb = json.optString("thumb");
        info.link = json.optString("link");
        return info;
    }

}
