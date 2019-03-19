package au.com.tyo.json.jsonform;

import com.google.api.client.util.Key;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldOptions extends JsonFormField {

    public static final String ATTRIBUTE_NAME_TITLE_LAYOUT = "title_layout";

    @Key
    public String label = "";

    @Key
    public List<JsonFormFieldOption> options;

    @Key
    public int title_layout = -1;

    public JsonFormFieldOptions(String key, String hint) {
        super(key);
        this.label = hint;
    }

    protected JsonFormFieldOption addOption(JsonFormFieldOption option) {
        if (options == null)
            options = new ArrayList<>();
        options.add(option);
        return option;
    }

    public JsonFormFieldOption addOption(String key, String text, String value) {
        JsonFormFieldOption optionField = addOption(key, text);
        optionField.value = value;
        return optionField;
    }

    public JsonFormFieldOption addOption(String key, String text) {
        JsonFormFieldOption option = new JsonFormFieldOption(key, text);
        return addOption(option);
    }

    public void check(List<String> list) {
        throw new IllegalStateException("Only check box can use this method");
    }

}
