package com.lmmnb.guangzhouculturehelper.api.apis;

import com.lmmnb.guangzhouculturehelper.api.services.HttpUtil;
import com.lmmnb.guangzhouculturehelper.api.services.Url;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Package: com.lmmnb.guangzhouculturehelper.api.apis
 * Created by oidiotlin on 18-3-27.
 */

public class Test {
    public static String getIp() {
        String json = HttpUtil.get(Url.test);
        String ip = null;
        try {
            JSONObject obj = new JSONObject(json);
            ip = (String) obj.get("origin");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ip;
    }
}
