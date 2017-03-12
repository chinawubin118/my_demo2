package com.lotte.mydemo2.model.bean;

/**
 * Created by wubin on 2016/1/16.
 */
public class PlaygroundImg {
    private String id;//图片id
    private String imgPath;//原图路径
    private String imgPathSmall;//缩略图路径

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgPathSmall() {
        return imgPathSmall;
    }

    public void setImgPathSmall(String imgPathSmall) {
        this.imgPathSmall = imgPathSmall;
    }
}
