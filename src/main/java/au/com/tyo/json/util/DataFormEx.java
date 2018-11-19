package au.com.tyo.json.util;

import java.util.List;
import java.util.Map;

public class DataFormEx extends FormGroup {

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

    public static final String KEY_META_MAP = "$meta";

    public DataFormEx(String title) {
        super(title);
    }

    public DataFormEx() {
        super();
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

    public Map getMetaMap() {
        if (!containsKey(KEY_META_MAP))
            return null;
        return (Map) getMapData(KEY_META_MAP);
    }

    public Object getMetaAttribute(String key, String attribute) {
        return getMapData(getMapData(KEY_META_MAP), key).get(attribute);
    }

    public void setMetaAttribute(String key, String attribute, Object value) {
        getMapData(getMapData(KEY_META_MAP), key).put(attribute, value);
    }
}
