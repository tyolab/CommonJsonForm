package au.com.tyo.json;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormField implements Comparable<JsonFormField> {

    public static final String REQUIRED = "Required";

    public static final int VALUE_NULLABLE = -1;
    public static final int VALUE_OPTIONAL = 0;
    public static final int VALUE_REQUIRED = 1;

    /**
     *
     */
    protected static String widgetType = null;

    public static void setWidgetType(String widgetType) {
        JsonFormField.widgetType = widgetType;
    }

    @Key
    public String key;

    @Key
    public String type;

    @Key
    public String visible = "true";

    @Key
    public Object value;

    /**
     * for form validation
     */
    public int required = VALUE_NULLABLE; // -1 nullable, 0 optional, 1 required

    /**
     * the orientation of field like title, user input
     */
    @Key
    public String orientation;

    /**
     * Other attributes in json
     */
    @Key
    public String attributes;

    /**
     * For dipslay order
     */
    public int display_order;

    /**
     * Response to mouse click event
     */
    @Key
    public boolean clickable;

    public JsonFormField(String key, String type, boolean required) {
        this.key = key;
        this.type = type;
        this.required = required ? VALUE_REQUIRED : VALUE_NULLABLE;
        this.clickable = false;

        if (null == type)
            throw new IllegalStateException(this.getClass().getSimpleName() + ": widget type cannot not be null");
    }

    public JsonFormField(String key) {
        this(key, widgetType, false);
    }

    @Override
    public int compareTo(JsonFormField jsonFormField) {
        return Integer.compare(this.display_order, jsonFormField.display_order);
    }
}
