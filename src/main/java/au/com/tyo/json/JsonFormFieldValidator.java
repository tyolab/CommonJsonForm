package au.com.tyo.json;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 23/8/17.
 */

public class JsonFormFieldValidator {

    public static final String V_ALLCAPS = "v_allcaps";

    @Key public String name;
    @Key public String value;
    @Key public String err;

    public JsonFormFieldValidator(String name, String value) {
        this(name, value, null);
    }

    public JsonFormFieldValidator(String name, String value, String err) {
        this.name = name;
        this.value = value;
        this.err = err;
    }

    public static JsonFormFieldValidator createNumericValidator() {
        return new JsonFormFieldValidator("v_numeric", "true", "Number only");
    }

    public static JsonFormFieldValidator createRequiredValidator() {
        return new JsonFormFieldValidator("v_required", "true", "This field is required");
    }

    public static JsonFormFieldValidator createAllCapsValidator() {
        return new JsonFormFieldValidator(V_ALLCAPS, "true");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JsonFormFieldValidator that = (JsonFormFieldValidator) o;

        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
