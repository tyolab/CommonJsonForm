package au.com.tyo.json.jsonform;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldTitledLabel extends JsonFormFieldLabel {

    public JsonFormFieldTitledLabel(String key, String title, String text) {
        super(key, text);
        this.title = title;
    }

    public JsonFormFieldTitledLabel(String key, String title) {
        this(key, title, null);
    }

    public JsonFormFieldTitledLabel(String key) {
        super(key);
    }
}
