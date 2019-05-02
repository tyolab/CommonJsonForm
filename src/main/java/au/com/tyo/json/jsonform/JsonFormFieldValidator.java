package au.com.tyo.json.jsonform;

import com.google.api.client.util.Key;

import au.com.tyo.json.util.NameValuePair;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 23/8/17.
 */

public class JsonFormFieldValidator extends NameValuePair {

    public static final String V_ALLCAPS = "v_allcaps";

    @Key public String err;

    public JsonFormFieldValidator(String name, String value) {
        this(name, value, null);
    }

    public JsonFormFieldValidator(String name, String value, String err) {
        this.name = name;
        this.value = value;
        this.err = err;
    }

    /**
     * The error information doesn't look good in material edit text widget
     *
     * @return
     */
    public static JsonFormFieldValidator createNumericValidator(String error) {
        return new JsonFormFieldValidator("v_numeric", "true", error);  // Number only
    }

    /**
     * The error information doesn't look good in material edit text widget
     *
     * @return
     */
    public static JsonFormFieldValidator createRequiredValidator(String errorMessage) {
        return new JsonFormFieldValidator("v_required", "true", errorMessage); // This field is required
    }

    /**
     *
     * @param length
     * @param errorMessage
     * @return
     */
    public static JsonFormFieldValidator createMinimumLengthValidator(int length, String errorMessage) {
        return new JsonFormFieldValidator("v_min_length", String.valueOf(length), errorMessage);
    }

    /**
     *
     * @param length
     * @param errorMessage
     * @return
     */
    public static JsonFormFieldValidator createMaximumLengthValidator(int length, String errorMessage) {
        return new JsonFormFieldValidator("v_max_length", String.valueOf(length), errorMessage);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
