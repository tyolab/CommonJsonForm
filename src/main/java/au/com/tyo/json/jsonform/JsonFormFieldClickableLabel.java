package au.com.tyo.json.jsonform;

import au.com.tyo.json.Constants;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 14/9/17.
 */

public class JsonFormFieldClickableLabel extends JsonFormFieldButton {

    public JsonFormFieldClickableLabel(String key, int pickType, String text) {
        super(key, "", pickType);
        this.text = text;
        this.required = VALUE_NULLABLE;
        this.type = Constants.JSON_FORM_WIDGET_KEY_CLICKABLE_LABEL;
    }
}
