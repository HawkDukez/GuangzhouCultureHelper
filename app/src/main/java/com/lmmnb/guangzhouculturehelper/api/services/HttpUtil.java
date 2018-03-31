package com.lmmnb.guangzhouculturehelper.api.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Package: com.lmmnb.guangzhouculturehelper.api.services
 * Created by oidiotlin on 18-3-26.
 */

public class HttpUtil {
    private static OkHttpClient client = new OkHttpClient();


    /**
     * GET Request.
     *
     * @param url URL of the request
     * @return raw json string in the response
     */
    public static String get(final String url) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response;
        String jsonStr = null;
        try {
            response = client.newCall(request).execute();
            jsonStr = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonStr;
    }

    /**
     * POST Request.
     * Request body required.
     *
     * @param url  URL of the request
     * @param body post body of the request
     * @return raw json string in the response
     */
    public static String post(final String url, final RequestBody body) {
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response;
        String jsonStr = null;
        try {
            response = client.newCall(request).execute();
            jsonStr = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonStr;
    }
}
