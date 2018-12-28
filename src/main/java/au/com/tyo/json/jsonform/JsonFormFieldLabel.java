package au.com.tyo.json.jsonform;

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

    public JsonFormFieldLabel(String key, String text) {
        super(key);
        this.text = text;
        this.required = VALUE_NULLABLE;
    }

}
