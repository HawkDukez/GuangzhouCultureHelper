package com.lmmnb.guangzhouculturehelper.api.model;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Package: com.lmmnb.guangzhouculturehelper.api.model
 * Created by oidiotlin on 18-3-24.
 * <p>
 * Model of translation.
 */
public class TranslateModel extends BaseModel {

    @SerializedName("from")
    private String srcText;
    @SerializedName("to")
    private String tgtText;

    public String getSrcText() {
        return srcText;
    }

    public void setSrcText(String srcText) {
        this.srcText = srcText;
    }

    public String getTgtText() {
        return tgtText;
    }

    public void setTgtText(String tgtText) {
        this.tgtText = tgtText;
    }
}
