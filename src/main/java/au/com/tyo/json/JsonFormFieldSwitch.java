package au.com.tyo.json;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldSwitch extends JsonFormFieldTitledLabel {

    public JsonFormFieldSwitch(String key, String type, String title) {
        super(key, type, title, "");
    }

    public JsonFormFieldSwitch(String key, String title) {
        super(key, Constants.JSON_FORM_WIDGET_KEY_SWITCH, title, "");
    }
}
