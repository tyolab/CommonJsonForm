package au.com.tyo.json;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldTitledLabel extends JsonFormFieldLabel {

    @Key
    public String title;

    public JsonFormFieldTitledLabel(String key, String type, String title, String text) {
        super(key, type, text);
        this.title = title;
    }

    public JsonFormFieldTitledLabel(String key, String title, String text) {
        this(key, Constants.JSON_FORM_WIDGET_KEY_LABEL, title, text);
    }
}
