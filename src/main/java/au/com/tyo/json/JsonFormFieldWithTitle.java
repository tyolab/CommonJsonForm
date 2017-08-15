package au.com.tyo.json;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldWithTitle extends JsonFormField {

    @Key
    public String title;

    public JsonFormFieldWithTitle(String key, String type, String title) {
        super(key, type);
        this.title = title;
    }

}
