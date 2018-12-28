package au.com.tyo.json.form;

import au.com.tyo.json.form.FieldValue;

public class FormField implements FieldHeader, FieldValue {

    public static final String KEY_KEY = "$key";

    public static final String KEY_VALUE = "$value";

    private String title;

    private String key;

    private Object value;

    public FormField(String key, String title, Object value) {
        setKey(key);
        setTitle(title);
        setValue(value);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setKey(String key) {
        //set(KEY_KEY, key);
        this.key = key;
    }

    public String getKey() {
        return key; //getString(KEY_KEY);
    }

    public void setValue(Object value) {
        //set(KEY_VALUE, value);
        this.value = value;
    }

    public Object getValue() {
        return value; // get(KEY_VALUE);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return getValue().toString();
    }

    @Override
    public String getStringValue() {
        return toString();
    }

    public static String toKey(String title) {
        String[] tokens = title.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < tokens.length; ++i) {
            if (null == tokens[i] || tokens[i].length() == 0)
                continue;

            if (i > 0)
                sb.append('-');

            sb.append(tokens[i].toLowerCase());
        }
        return sb.toString();
    }

    public static String toTitle(String key) {
        String[] tokens = key.split("-_");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < tokens.length; ++i) {
            if (null == tokens[i] || tokens[i].length() == 0)
                continue;

            if (i > 0)
                sb.append(' ');

            sb.append(tokens[i].substring(0, 1).toUpperCase());
            sb.append(tokens[i].substring(1));
        }
        return sb.toString();
    }
}
