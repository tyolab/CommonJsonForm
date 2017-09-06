package au.com.tyo.json;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormField {

    public static final String REQUIRED = "REQUIRED";

    @Key
    public String key;

    @Key
    public String type;

    public JsonFormField(String key, String type) {
        this.key = key;
        this.type = type;
    }

}
