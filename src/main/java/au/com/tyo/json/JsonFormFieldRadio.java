package au.com.tyo.json;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldRadio extends JsonFormFieldOptions {

    @Key
    public String value = "";

    public JsonFormFieldRadio(String key, String hint) {
        super(key, "radio", hint);
    }

    public void check(String check, String alt) {
//        if (null != check && null != options)
//            for (JsonFormFieldOption option : options) {
//                if (check.equals(option.key)) {
//                    value = option.key;
//                    return;
//                }
//            }
        value = check;

        if (null != alt && (value == null || value.length() == 0))
            value = alt;
    }

    public void check(String check) {
        check(check, null);
    }
}
