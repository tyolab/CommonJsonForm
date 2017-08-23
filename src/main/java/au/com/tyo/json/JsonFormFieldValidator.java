package au.com.tyo.json;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 23/8/17.
 */

public class JsonFormFieldValidator {
    @Key public String name;
    @Key public String value;
    @Key public String err;

    public JsonFormFieldValidator(String name, String value, String err) {
        this.name = name;
        this.value = value;
        this.err = err;
    }

    public static JsonFormFieldValidator createNumericValidator() {
        return new JsonFormFieldValidator("v_numeric", "true", "Must be in digits(0..9)");
    }
}
