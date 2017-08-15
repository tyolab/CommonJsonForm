package au.com.tyo.json;

import java.util.List;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldCheckBox extends JsonFormFieldOptions {

    public JsonFormFieldCheckBox(String key, String hint) {
        super(key, "check_box", hint);
    }

    public JsonFormFieldOption addOption(String key, String text, boolean value) {
        return addOption(key, text, String.valueOf(value));
    }

    public JsonFormFieldOption addOption(String key, String text, String value) {
        JsonFormFieldOption option = new JsonFormFieldOptionCheckBox(key, text, value);

        return addOption(option);
    }

    public JsonFormFieldOption addOption(String key, String text) {
        return addOption(key, text, false);
    }

    public void check(List<String> list) {
        if (null == list)
            return;

        if (null != options)
            for (JsonFormFieldOption option : options) {
                JsonFormFieldOptionCheckBox checkBox = (JsonFormFieldOptionCheckBox) option;
                if (list.contains(checkBox.text))
                    checkBox.value = "true";
            }
    }
}
