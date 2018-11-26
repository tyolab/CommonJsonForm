package au.com.tyo.json.util;

import java.util.ArrayList;
import java.util.List;

public class OrderedDataMap extends DataJson {

    private List<String> orderedKeys;
    private List         values;

    /**
     * The put method won't keep the entry in order
     *
     * @param key
     * @param value
     */
    public void putInOrder(String key, Object value) {

        if (null != key && key.charAt(0) != '$') {
            if (null == orderedKeys)
                orderedKeys = new ArrayList<>();

            if (!containsKey(key)) {
                orderedKeys.add(key);

                if (null == values)
                    values = new ArrayList();
                values.add(value);
            }
        }
        else
            throw new IllegalArgumentException("Key cannot contain special character $");

        put(key, value);
    }

    public Object get(int pos) {
        return get(orderedKeys.get(pos));
    }

    @Override
    public int size() {
        return orderedKeys.size();
    }

    public List<String> getOrderedKeys() {
        return orderedKeys;
    }

    public String getKey(int pos) {
        return orderedKeys.get(pos);
    }

    public List getOrderedValues() {
        return values;
    }
}
