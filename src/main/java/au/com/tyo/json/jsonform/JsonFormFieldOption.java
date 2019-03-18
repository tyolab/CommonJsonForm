package au.com.tyo.json.jsonform;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldOption {

    @Key
    public String key;

    @Key
    public String text;

    @Key
    public String value;

    public JsonFormFieldOption(String key, String text) {
        this.key = key;
        this.text = text;
    }

    public JsonFormFieldOption(String key, String text, String value) {
        this.key = key;
        this.text = text;
        this.value = value;
    }
}
