package au.com.tyo.json;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldTitledLabel extends JsonFormFieldWithTitle {

    @Key
    public String text = REQUIRED;

    public JsonFormFieldTitledLabel(String key, String type, String title) {
        super(key, type, title);
    }

    public JsonFormFieldTitledLabel(String key, String title) {
        this(key, Constants.JSON_FORM_WIDGET_KEY_LABEL, title);
    }
}
