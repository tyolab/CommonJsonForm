package au.com.tyo.json.form;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import au.com.tyo.json.jsonform.JsonFormField;
import au.com.tyo.json.util.OrderedDataMap;

public class DataFormEx extends FormGroup {

    public static final String ABSORB_DATA_PREFIX_DEFAULT = "$form_data";

    public static String absorbDataPrefix = ABSORB_DATA_PREFIX_DEFAULT;

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
    public static final String KEY_FIELDS = "$fields";

    /**
     *
     */
    public static final String KEY_META_MAP = "$meta";

    /**
     *
     */
    public static final String KEY_ID = "$id";

    protected boolean initialized = false;

    private Map formData = null;

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

        if (null != formData)
            absorbData(group);
    }

    public void addFields(Map<? extends String, ?> fields) {
        List list = getListData(KEY_FIELDS);

        for (Map.Entry<? extends String, ?> entry : fields.entrySet())
            addField(entry.getKey(), entry.getValue());
    }

    public void addData(Map data) {
        if (null != formData)
            absorbData(data);
    }

    /**
     * Only take the real setting data, not the metadata for the form building
     *
     * @param formField
     */
    private void absorbData(FormField formField) {
        String keyStr = formField.getKey();
        absorbData(keyStr, formField.getValue());
    }

    /**
     * Only take the real setting data, not the metadata for the form building
     *
     * @param entry
     */
    private void absorbData(Entry<String, Object> entry) {
        absorbData(entry.getKey(), entry.getValue());
    }

    /**
     * Only take the real setting data, not the metadata for the form building
     *
     * This behaviour is changeable by setting tht static member field: absorbDataPrefix
     *
     * @param keyStr
     * @param data
     */
    private void absorbData(String keyStr, Object data) {
        if (keyStr.startsWith(absorbDataPrefix)) {
            if (data instanceof JsonFormField)
                formData.put(keyStr, ((JsonFormField) data).value);
            else
                formData.put(keyStr, data);
        }
    }

    private void absorbData(Map group) {
        if (group instanceof FormGroup) {
            FormGroup formGroup = (FormGroup) group;
            for (int i = 0; i < formGroup.sizeOfOrder(); ++i)
                absorbData((FormField) formGroup.get(i));
        }
        else {
            Collection<Entry<String, Object>> set = group.entrySet();
            for (Entry<String, Object> entry : set) {
                if (entry.getValue() instanceof FormField)
                    absorbData((FormField) entry.getValue());
                else
                    absorbData(entry);
            }
        }
    }

    public boolean hasData() {
        return getFields().size() > 0;
    }

    public FormField addField(String key, String title, Object value, int clickable) {
        FormField formField = super.addField(key, title, value, clickable);

        return addField(formField);
    }

    public FormField addField(FormField formField) {
        List fields = getListData(KEY_FIELDS);
        fields.add(formField);

        return formField;
    }

    public void clearFields() {
        getListData(KEY_FIELDS).clear();
    }

    public List getGroups() {
        return getListData(KEY_GROUPS);
    }

    public FormField setTitle(String title) {
        set(KEY_TITLE, title);
        return null;
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

    /**
     * The copy of the actual data excluding the all meta keys/data
     * @return
     */
    public Map getFormData() {
        return formData;
    }

    public void setFormData(Map formData) {
        this.formData = formData;
    }

    public List getFields() {
        return getListData(KEY_FIELDS);
    }

}
