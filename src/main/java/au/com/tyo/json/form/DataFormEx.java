package au.com.tyo.json.form;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import au.com.tyo.json.util.OrderedDataMap;

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

    /**
     *
     */
    public static final String KEY_GROUPS = "$groups";

    /**
     *
     */
    public static final String KEY_META_MAP = "$meta";

    /**
     *
     */
    public static final String KEY_ID = "$id";

    protected boolean initialized = false;

    public DataFormEx(String title) {
        super(title);
    }

    public DataFormEx() {
        super();
    }

    public DataFormEx(Map<String, Object> data) {
        if (data instanceof OrderedDataMap) {
            OrderedDataMap orderedDataMap = (OrderedDataMap) data;
            for (int i = 0; i < orderedDataMap.size(); ++i) {
                putInOrder(orderedDataMap.getKey(i), orderedDataMap.getValue(i));
            }
        }
        else {
            Collection<Entry<String, Object>> set = data.entrySet();
            for (Entry<String, Object> entry : set)
                put(entry.getKey(), entry.getValue());
        }
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
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

    public void setHeader(int headerResId) {
        put(KEY_HEADER, headerResId);
    }

    public void setFooter(int footerResId) {
        put(KEY_FOOTER, footerResId);
    }

    public Map getMetaMap() {
        if (!containsKey(KEY_META_MAP))
            return null;
        return (Map) getMapData(KEY_META_MAP);
    }

    public Object getMetaAttribute(String key, String attribute) {
        return DataJson.getMapData(getMapData(KEY_META_MAP), key).get(attribute);
    }

    public void setMetaAttribute(String key, String attribute, Object value) {
        DataJson.getMapData(getMapData(KEY_META_MAP), key).put(attribute, value);
    }

    public String getFormId() {
        return getString(KEY_ID);
    }

    public void setFormId(String id) {
        set(KEY_ID, id);
    }

    /**
     * Initialize the form
     *
     */
    public void initializeForm() {
        // no ops yet
    }
}
