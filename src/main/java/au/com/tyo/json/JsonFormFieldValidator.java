package au.com.tyo.json;

import com.google.api.client.util.Key;

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
     * The error information dosen't look good in material edit text widget
     *
     * @return
     */
    public static JsonFormFieldValidator createNumericValidator() {
        return new JsonFormFieldValidator("v_numeric", "true", "");  // Number only
    }

    /**
     * The error information dosen't look good in material edit text widget
     *
     * @return
     */
    public static JsonFormFieldValidator createRequiredValidator() {
        return new JsonFormFieldValidator("v_required", "true", ""); // This field is required
    }

//    public static JsonFormFieldValidator createAllCapsValidator() {
//        return new JsonFormFieldValidator(V_ALLCAPS, "true");
//    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
