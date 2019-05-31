package au.com.tyo.json.form;

import au.com.tyo.json.util.OrderedDataMap;

import static au.com.tyo.json.jsonform.JsonFormField.CLICKABLE_NONE;

class FormData extends OrderedDataMap {

    public static final String KEY_EDITABLE = "$editable";

    public static final String KEY_LOCKED = "$locked";

    public static final String KEY_TITLE = "$title";

    public static final String KEY_KEY = "$key";

    public static final String KEY_LAYOUT = "$layout";

    public static final String KEY_LAYOUT_TITLE = "$layout_title";

    public static final String KEY_VISIBLE = "$visible";

    public static final String KEY_CLICKABLE = "$clickable";

    public static final String KEY_ORIENTATION = "$orientation";

    private boolean showingTitle = false;

    public boolean isShowingTitle() {
        return showingTitle;
    }

    public void setShowingTitle(boolean showingTitle) {
        this.showingTitle = showingTitle;
    }

    public void setTitle(String title) {
        set(KEY_TITLE, title);
    }

    public String getTitle() {
        return getString(KEY_TITLE);
    }

    public void setEditable(boolean editable) {
        set(KEY_EDITABLE, editable);
    }

    public boolean isEditable() {
        return getBoolean(KEY_EDITABLE, true);
    }

    public boolean isEditableValueSet() {
        return containsKey(KEY_EDITABLE);
    }

    public void setLocked(boolean editable) {
        set(KEY_LOCKED, editable);
    }

    public boolean isLocked() {
        return getBoolean(KEY_LOCKED, false);
    }

    public void setLayout(int layout) {
        put(KEY_LAYOUT, layout);
    }

    public int getLayout() {
        return getInt(KEY_LAYOUT, -1);
    }

    public boolean hasLayout() {
        return containsKey(KEY_LAYOUT);
    }

    public void setTitleLayout(int layout) {
        put(KEY_LAYOUT_TITLE, layout);
    }

    public int getTitleLayout() {
        return getInt(KEY_LAYOUT_TITLE, -1);
    }

    public boolean hasTitleLayout() {
        return containsKey(KEY_LAYOUT_TITLE);
    }

    public void setKey(String keyStr) {
        set(KEY_KEY, keyStr);
    }

    public String getKey() {
        return getString(KEY_KEY);
    }

    public boolean hasKey() {
        return containsKey(KEY_KEY);
    }

    public void setVisible(boolean editable) {
        set(KEY_VISIBLE, editable);
    }

    public boolean isVisible() {
        return getBoolean(KEY_VISIBLE, true);
    }

    public void setClickable(int clickable) {
        put(KEY_CLICKABLE, clickable);
    }

    public int getClickable() {
        return getInt(KEY_CLICKABLE, CLICKABLE_NONE);
    }

    public void setOrientation(String value) {
        set(KEY_ORIENTATION, value);
    }

    public String getOrientation() {
        return getString(KEY_ORIENTATION);
    }
}
