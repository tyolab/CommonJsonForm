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
    private static final String KEY_HEADER = "header";

    /**
     * Static footer
     *
     * for anything dynamic, should use a footer field
     */
    private static final String KEY_FOOTER = "footer";

    private static final String KEY_GROUPS = "groups";

    private static final String KEY_TITLE = "title";

    public static class FormGroup extends OrderedDataMap {

        private boolean showGroupTitle = true;

        public boolean isShowGroupTitle() {
            return showGroupTitle;
        }

        public void setShowGroupTitle(boolean showGroupTitle) {
            this.showGroupTitle = showGroupTitle;
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

        public void addField(String title, String value) {
            putInOrder(title, value);
        }
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
        return getInt(KEY_FOOTER);
    }

    public int getHeader() {
        return getInt(KEY_HEADER);
    }
}
