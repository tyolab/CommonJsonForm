package au.com.tyo.json;

import com.google.api.client.util.Key;


/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldSwitch extends JsonFormFieldTitledLabel {

    @Key
    public String value;

    public JsonFormFieldSwitch(String key, String type, String title) {
        super(key, type, title);
    }

    public JsonFormFieldSwitch(String key, String title) {
        super(key, Constants.JSON_FORM_WIDGET_KEY_SWITCH, title);
    }
}
