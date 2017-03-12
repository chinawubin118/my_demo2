package com.lotte.mydemo2.model.bean;

import java.util.List;

/**
 * Created by wubin on 2016/1/16.
 */
public class Playground {
    private int sex;//0男,1女
    private int isComments;//是否有新的留言 0否 1是
    private String schoolName;
    private int likeTimes;
    private int isAnonymous;//是否匿名0否 1是
    private int messageTimes;
    private String id;//说说id
    private String createtime;
    private String distance;
    private String mobilePhone;//发布人手机号
    private String nickName;//发布人昵称
    private String userId;//发布人userId
    private String grade;//发布人等级
    private String headPortrait;//发布人头像
    private String title;//说说标题
    private String anonymousName;//匿名名称
    private int isLike;//是否点击过关注 0 没有 1点击过了
    private List<PlaygroundImg> imgList;//图片对象
    private int isAuthentication;//是否认证 0 否 1申请认证 2认证成功
    private int isTop;//是否置顶 0否 1是
    private String type;//ask  or casual
    private List<CommentItem> commentsList;

    public int getIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

    public int getIsAuthentication() {
        return isAuthentication;
    }

    public void setIsAuthentication(int isAuthentication) {
        this.isAuthentication = isAuthentication;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getIsComments() {
        return isComments;
    }

    public void setIsComments(int isComments) {
        this.isComments = isComments;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getLikeTimes() {
        return likeTimes;
    }

    public void setLikeTimes(int likeTimes) {
        this.likeTimes = likeTimes;
    }

    public int getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(int isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public int getMessageTimes() {
        return messageTimes;
    }

    public void setMessageTimes(int messageTimes) {
        this.messageTimes = messageTimes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnonymousName() {
        return anonymousName;
    }

    public void setAnonymousName(String anonymousName) {
        this.anonymousName = anonymousName;
    }

    public int getIsLike() {
        return isLike;
    }

    public void setIsLike(int isLike) {
        this.isLike = isLike;
    }

    public List<PlaygroundImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<PlaygroundImg> imgList) {
        this.imgList = imgList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CommentItem> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<CommentItem> commentsList) {
        this.commentsList = commentsList;
    }
}
