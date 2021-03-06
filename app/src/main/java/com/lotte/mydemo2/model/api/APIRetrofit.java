package com.lotte.mydemo2.model.api;

import com.lotte.mydemo2.Constant;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jam on 16-5-17
 * Description:
 */
public class APIRetrofit {

    private static ApiService SERVICE;

    public static ApiService getDefault() {
        if (SERVICE == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
//                    .addInterceptor(new HeaderInterceptor())
                    .addInterceptor(logging)
                    .build();

            SERVICE = new Retrofit.Builder()
//                    .baseUrl(Constant.RETROFIT_URL)
                    .baseUrl(Constant.MY_SERVER)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .build().create(ApiService.class);
        }
        return SERVICE;
    }

//    //接口加密
//    static class HeaderInterceptor implements Interceptor {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//
//            Request original = chain.request();
//
//            HttpUrl httpUrl = original.url();
//
//            //可排序的map
//            TreeMap<String, String> params = new TreeMap<>(new Comparator<String>() {
//
//                @Override
//                public int compare(String o, String t1) {
//                    return o.compareTo(t1);
//                }
//            });
//
//            //1.把get中参数加入进去
//            for (int i = 0; i < httpUrl.querySize(); i++) {
//                params.put(httpUrl.queryParameterName(i), httpUrl.queryParameterValue(i));
//            }
//
//            //2.把post中的参数加入进去
//            if (original.body() instanceof FormBody) {
//                FormBody body = (FormBody) original.body();
//                for (int i = 0; i < body.size(); i++) {
//                    params.put(body.name(i), body.value(i));
//                }
//            }
//
//            //3.开始拼接加密的字符串
//            String urlPath = httpUrl.url().getPath() + "?";
//            Iterator iterator = params.keySet().iterator();
//            while (iterator.hasNext()) {
//                String key = (String) iterator.next();
//                String value = params.get(key);
//                urlPath = urlPath + key + "=" + value + "&";
//            }
//
//            //4.把uuid和时间戳加上
//            urlPath = urlPath + original.header("uuid") + "&" + original.header("timestamp");
//
//            KLog.d("排序后" + urlPath);
//            String sign = MD5Util.md5String(urlPath);
//            KLog.d("MD5:" + sign);
//
//            Request.Builder requestBuilder = original.newBuilder()
//                    .header("sign", sign);
//            Request request = requestBuilder.build();
//            return chain.proceed(request);
//        }
//    }
}
