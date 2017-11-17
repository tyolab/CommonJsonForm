package au.com.tyo.json;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 14/9/17.
 */

public class JsonFormFieldClickableLabel extends JsonFormFieldButton {

    public JsonFormFieldClickableLabel(String key, int pickType, String text) {
        super(key, Constants.JSON_FORM_WIDGET_KEY_CLICKABLE_LABEL, "", pickType);
        this.text = text;
        this.required = false;
    }
}
