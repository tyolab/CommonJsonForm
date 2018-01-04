package au.com.tyo.json;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldRadio extends JsonFormFieldOptions {

    public JsonFormFieldRadio(String key, String hint) {
        super(key, "radio", hint);
    }

    public void check(String check, String alt) {
        value = check;

        if (null != alt && (value == null || ((CharSequence) value).length() == 0))
            value = alt;
    }

    public void check(String check) {
        check(check, null);
    }
}
