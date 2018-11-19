package au.com.tyo.json;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 14/9/17.
 */

public class JsonFormFieldDatePicker extends JsonFormFieldButton {

    public long max = -1;
    public long min = -1;

    public JsonFormFieldDatePicker(String key, String title) {
        this(key, title, PICK_DATE);
    }

    public JsonFormFieldDatePicker(String key, String title, int pickType) {
        this(key, title, pickType, REQUIRED);
    }

    public JsonFormFieldDatePicker(String key, String title, int pickType, String hint) {
        super(key, title, pickType, hint);
    }
}
