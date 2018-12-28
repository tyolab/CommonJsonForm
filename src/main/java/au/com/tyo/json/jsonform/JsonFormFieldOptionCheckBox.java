package au.com.tyo.json.jsonform;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldOptionCheckBox extends JsonFormFieldOption {

    @Key
    public String value = "false";

    public JsonFormFieldOptionCheckBox(String key, String text, String value) {
        super(key, text);
        this.value = value;
    }
}
