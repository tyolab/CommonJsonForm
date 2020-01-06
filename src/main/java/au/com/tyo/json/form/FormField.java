package au.com.tyo.json.form;

import au.com.tyo.json.Config;
import au.com.tyo.json.jsonform.JsonFormField;

public class FormField extends FormData implements FieldHeader, FieldValue {

    public static final String KEY_KEY = "$key";

    public static final String KEY_VALUE = "$value";

    private String title;

    private String key;

    private Object value;

    private String type;

    private int clickable = 0;
    private boolean enabled;

    private int layout;

    private boolean withSeparator;

    private String subtitle;

    public FormField(String key, String title, Object value) {
        setKey(key);
        setTitle(title);
        setValue(value);
        setEnabled(true);
        setLayout(-1);
        setWithSeparator(Config.formWithSeparator);
    }

    public String getTitle() {
        return title;
    }

    public FormField setTitle(String title) {
        this.title = title;

        return this;
    }

    public FormField setKey(String key) {
        //set(KEY_KEY, key);
        this.key = key;

        return this;
    }

    public String getKey() {
        return key; //getString(KEY_KEY);
    }

    public FormField setValue(Object value) {
        //set(KEY_VALUE, value);
        this.value = value;

        return this;
    }

    public Object getValue() {
        return value; // get(KEY_VALUE);
    }

    public FormField setType(String type) {
        this.type = type;

        return this;
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

    public String getType() {
        return type;
    }

    public int isClickable() {
        return clickable;
    }

    public FormField setClickable(int clickable) {
        this.clickable = clickable;

        return this;
    }

    public FormField setEnabled(boolean enabled) {
        this.enabled = enabled;

        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public int getLayout() {
        return layout;
    }

    public FormField setLayout(int layout) {
        this.layout = layout;

        return this;
    }

    public boolean hasSeparator() {
        if (value instanceof JsonFormField)
            return ((JsonFormField) value).separator_under;
        return withSeparator;
    }

    public FormField setWithSeparator(boolean withSparator) {
        this.withSeparator = withSparator;

        return this;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public FormField setSubtitle(String subtitle) {
        this.subtitle = subtitle;

        return this;
    }
}
