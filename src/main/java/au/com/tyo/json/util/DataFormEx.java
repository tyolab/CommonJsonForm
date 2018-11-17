package au.com.tyo.json.util;

import java.util.List;
import java.util.Map;

public class DataFormEx extends DataJson {

    /**
     * Static header
     *
     * for anything dynamic, should use a header field
     *
     */
    public static final String KEY_HEADER = "$header";

    /**
     * Static footer
     *
     * for anything dynamic, should use a footer field
     */
    public static final String KEY_FOOTER = "$footer";

    public static final String KEY_GROUPS = "$groups";

    public static final String KEY_TITLE = "$title";

    public static final String KEY_EDITABLE = "$editable";

    public static class FormGroup extends OrderedDataMap {

        private boolean showingGroupTitle = false;

        public boolean isShowingGroupTitle() {
            return showingGroupTitle;
        }

        public void setShowingGroupTitle(boolean showingGroupTitle) {
            this.showingGroupTitle = showingGroupTitle;
        }

        public FormGroup(String title) {
            setTitle(title);
        }

        public void setTitle(String title) {
            set(KEY_TITLE, title);
        }

        public String getTitle() {
            return getString(KEY_TITLE);
        }

        public void addField(String title, Object value) {
            putInOrder(title, value);
        }

    }

    public void addHeader(int headerResId) {
        set(KEY_HEADER, headerResId);
    }

    public void addFooter(int footerResId) {
        set(KEY_FOOTER, footerResId);
    }

    public void addGroup(Map group) {
        addListData(KEY_GROUPS, group);
    }

    public List getGroups() {
        return getListData(KEY_GROUPS);
    }

    public void setTitle(String title) {
        set(KEY_TITLE, title);
    }

    public String getTitle() {
        return getString(KEY_TITLE);
    }

    public boolean hasFooter() {
        return containsKey(KEY_FOOTER);
    }

    public boolean hasHeader() {
        return containsKey(KEY_HEADER);
    }

    public int getFooter() {
        return getInt(KEY_FOOTER, -1);
    }

    public int getHeader() {
        return getInt(KEY_HEADER, -1);
    }

    public void setFormEditable(boolean editable) {
        set(KEY_EDITABLE, editable);
    }
}
