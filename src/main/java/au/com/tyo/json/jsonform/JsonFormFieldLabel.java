package au.com.tyo.json.jsonform;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 27/7/17.
 */

public class JsonFormFieldLabel extends JsonFormFieldWithTitle {

    @Key
    @Deprecated
    public String text;

    @Key
    public String textStyle;

    @Key
    public boolean scrollable;

    public JsonFormFieldLabel(String key, String text) {
        super(key);
        this.text = text;
        this.required = VALUE_NULLABLE;
        this.editable = false;
    }

    public JsonFormFieldLabel(String key) {
        this(key, null);
    }
}
