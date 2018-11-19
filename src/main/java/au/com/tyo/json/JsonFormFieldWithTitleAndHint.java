package au.com.tyo.json;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldWithTitleAndHint extends JsonFormFieldWithTitle {

    @Key
    public String hint;

    public JsonFormFieldWithTitleAndHint(String key, String title, String hint) {
        super(key, title);
        this.hint = hint;

        if (hint.equals(REQUIRED))
            required = VALUE_REQUIRED;
    }

}
