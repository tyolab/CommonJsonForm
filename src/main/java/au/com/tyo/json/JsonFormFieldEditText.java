package au.com.tyo.json;

import com.google.api.client.util.Key;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldEditText extends JsonFormFieldWithTitleAndHint {

    @Key
    public String value;

    @Key
    public List<JsonFormFieldValidator> validators;

    public JsonFormFieldEditText(String key, String type, String title, String hint) {
        super(key, type, title, hint);
    }

    public JsonFormFieldEditText(String key, String title, String hint) {
        this(key, Constants.JSON_FORM_WIDGET_KEY_TITLED_EDIT_TEXT, title, hint);
    }

    public JsonFormFieldEditText(String key, String title) {
        this(key, title, REQUIRED);
    }

    public void addValidator(JsonFormFieldValidator validator) {
        if (null == validators)
            validators = new ArrayList<>();
        validators.add(validator);
    }
}
