package au.com.tyo.json;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 27/7/17.
 */

public class JsonFormFieldLabel extends JsonFormField {

    @Key
    @Deprecated
    public String text;

    @Key
    public String textStyle;

    public JsonFormFieldLabel(String key, String type, String text) {
        super(key, type);
        this.text = text;
        this.required = false;
    }

}
