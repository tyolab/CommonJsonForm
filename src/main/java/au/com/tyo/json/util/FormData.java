package au.com.tyo.json.util;

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
