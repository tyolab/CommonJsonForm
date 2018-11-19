package au.com.tyo.json;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldWithHint extends JsonFormField {

    @Key
    public String hint;

    public JsonFormFieldWithHint(String key, String hint) {
        super(key);
        this.hint = hint;
    }

}
