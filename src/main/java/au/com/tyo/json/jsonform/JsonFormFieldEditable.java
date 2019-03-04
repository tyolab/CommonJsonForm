package au.com.tyo.json.jsonform;

import com.google.api.client.util.Key;

public class JsonFormFieldEditable extends JsonFormField {

    @Key
    public boolean editable;

    public JsonFormFieldEditable(String key, String type, boolean required) {
        super(key, type, required);
    }

    public JsonFormFieldEditable(String key) {
        super(key);
    }
}
