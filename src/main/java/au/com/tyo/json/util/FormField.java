package au.com.tyo.json.util;

public class FormField extends FormData {

    public static final String KEY_KEY = "$key";

    public static final String KEY_VALUE = "$value";


    public FormField(String key, String title, Object value) {
        setKey(key);
        setTitle(title);
        setValue(value);
    }

    public void setKey(String key) {
        set(KEY_KEY, key);
    }

    public String getKey() {
        return getString(KEY_KEY);
    }

    public void setValue(Object value) {
        set(KEY_VALUE, value);
    }

    public Object getValue() {
        return get(KEY_VALUE);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return getValue().toString();
    }

}
