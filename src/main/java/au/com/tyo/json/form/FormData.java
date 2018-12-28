package au.com.tyo.json.form;

import au.com.tyo.json.util.OrderedDataMap;

class FormData extends OrderedDataMap {

    public static final String KEY_EDITABLE = "$editable";

    public static final String KEY_LOCKED = "$locked";

    public static final String KEY_TITLE = "$title";

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

    public void setLocked(boolean editable) {
        set(KEY_LOCKED, editable);
    }

    public boolean isLocked() {
        return getBoolean(KEY_LOCKED, false);
    }

}
