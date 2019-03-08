package bwei.com.chenxi20190308.data.utils;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OKHttpUtils {

    private final OkHttpClient client;
    private static OKHttpUtils okHttpUtils;

    private OKHttpUtils(){
        client = new OkHttpClient.Builder().build();
    }

    //暴露一个共有的方法供外部访问
    public static OKHttpUtils getInstance(){
        if (okHttpUtils==null){
            synchronized (OKHttpUtils.class){
                if (okHttpUtils==null){
                    okHttpUtils = new OKHttpUtils();
                }
            }
        }
         return okHttpUtils;
    }


    public void get(String urlString, Callback callback) {
        Request request = new Request.Builder()
                .url(urlString).build();
        client.newCall(request).enqueue(callback);
    }

}
