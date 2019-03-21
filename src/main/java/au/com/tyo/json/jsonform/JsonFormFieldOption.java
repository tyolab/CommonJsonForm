package au.com.tyo.json.jsonform;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldOption extends JsonFormField {

    @Key
    public String text;

    public JsonFormFieldOption(String key, String text) {
        super(key);
        this.text = text;
    }

    public JsonFormFieldOption(String key, String text, String value) {
        super(key);
        this.text = text;
        this.value = value;
    }
}
