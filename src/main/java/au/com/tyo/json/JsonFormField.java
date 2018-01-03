package au.com.tyo.json;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormField {

    public static final String REQUIRED = "Required";

    @Key
    public String key;

    @Key
    public String type;

    @Key
    public String visible = "true";

    @Key
    public Object value;

    /**
     * for form validation
     */
    public boolean required = false;

    /**
     * the orientation of field like title, user input
     */
    @Key
    public String orientation;

    /**
     * Other attributes in json
     */
    @Key
    public String attributes;

    public JsonFormField(String key, String type, boolean required) {
        this.key = key;
        this.type = type;
        this.required = required;
    }

    public JsonFormField(String key, String type) {
        this(key, type, false);
    }
}
