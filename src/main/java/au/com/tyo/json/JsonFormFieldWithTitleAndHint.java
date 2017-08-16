package au.com.tyo.json;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldWithTitleAndHint extends JsonFormFieldWithTitle {

    @Key
    public String hint;

    public JsonFormFieldWithTitleAndHint(String key, String type, String title, String hint) {
        super(key, type, title);
        this.hint = hint;
    }

}
