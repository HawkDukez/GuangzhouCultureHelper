package com.lmmnb.guangzhouculturehelper.api.services;

/**
 * Package: com.lmmnb.guangzhouculturehelper.api.services
 * Created by oidiotlin on 18-3-24.
 */

public class Url {
    private static final String domain = "api.gd.delbertbeta.cc";
    private static final String domain2 = "ali.delbertbeta.cc";
    private static final String protocol = "http://";
    private static final String app = "/v1/app";

    private static String catUrl(String url) {
        return String.format("%s%s%s%s", protocol, domain, app, url);
    }

    public static final String test = "http://httpbin.org/get";

    public static final String translate = catUrl("/language/translate");
    public static final String speech = catUrl("/language/speech");
}
