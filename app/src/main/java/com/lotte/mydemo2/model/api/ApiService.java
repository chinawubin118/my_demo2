package com.lotte.mydemo2.model.api;

import com.beanu.arad.http.BaseModel;
import com.google.gson.JsonObject;
import com.lotte.mydemo2.model.bean.Playground;
import com.lotte.mydemo2.model.bean.School;
import com.lotte.mydemo2.model.bean.SmsCode;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by QCXY
 * Description:青橙校园接口
 */
public interface ApiService {

    /**
     * 获取七牛的token(不规范的接口)
     */
    @GET("phoneMobile.do?act=getQNToken")
    Observable<JsonObject> refreshQNToken();

    /**
     * 上传用户的头像
     */
    @FormUrlEncoded
    @POST("phoneMobile.do?act=updateUserIcon")
    Observable<JsonObject> uploadUserAvatar(@Field("userId") String userId, @Field("fileImage") String fileImage);

    /**
     * 上传个人相册，单张上传
     */
    @FormUrlEncoded
    @POST("phoneMobile.do?act=uploadImg")
    Observable<BaseModel<String>> uploadUserPhoto(@Field("userId") String userId, @Field("imgurl") String imgUrl);

    /**
     * 个人中心动态列表
     */
    @FormUrlEncoded
    @POST("phoneMobile.do?act=myInterestingList")
    Observable<BaseModel<List<Playground>>> getUserPlaygroundList(@Field("userId") String userId,
                                                                  @Field("alias") String alias,
                                                                  @Field("currentPage") int currentPage,
                                                                  @Field("rowCountPerPage") int rowCountPerPage);

    /**
     * 获取短信验证码
     */
    @FormUrlEncoded
    @POST("phoneMobile.do?act=getCode")
    Observable<BaseModel<SmsCode>> requestCode(@Field("phoneNum") String phoneNum, @Field("type") String type);

    /**
     * 说说列表
     */
    @FormUrlEncoded
    @POST("phoneMobile.do?act=nearInterestingList")
    Observable<BaseModel<List<Playground>>> requestShuoshuoList(@Field("userId") String userId,
                                                                @Field("schoolId") String schoolId,
                                                                @Field("keyStr") String keyStr,
                                                                @Field("type") String type,
                                                                @Field("sex") String sex,
                                                                @Field("isNew") String isNew,
                                                                @Field("mapx") double mapx,
                                                                @Field("mapy") double mapy,
                                                                @Field("currentPage") int currentPage,
                                                                @Field("rowCountPerPage") int rowCountPerPage);

    /**
     * 说说 点赞
     */
    @FormUrlEncoded
    @POST("phoneMobile.do?act=updateInLike")
    Observable<JsonObject> likeShuoshuo(@Field("userId") String userId, @Field("id") String objId);

    /**
     * 获取学校列表
     *
     * @param provinceName 省份名称
     * @param schoolName   查询名称
     * @return
     */
    @FormUrlEncoded
    @POST("phoneMobile.do?act=getSchoolList")
    Observable<BaseModel<List<School>>> getSchoolList(@Field("provinceName") String provinceName, @Field("schoolName") String schoolName);

    /**
     * 测试登录
     */
    @FormUrlEncoded
    @POST("demo1/servlet/LoginServlet")
    Observable<JsonObject> loginToMyServer(@Field("username") String username, @Field("password") String password);
}





