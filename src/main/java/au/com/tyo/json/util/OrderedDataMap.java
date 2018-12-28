package au.com.tyo.json.util;

import java.util.ArrayList;
import java.util.List;

import au.com.tyo.json.form.DataJson;

public class OrderedDataMap<ValueType> extends DataJson {

    private List<String>            orderedKeys;
    private List<ValueType>         values;

    /**
     * The put method won't keep the entry in order
     *
     * @param key
     * @param value
     */
    public void putInOrder(String key, ValueType value) {

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
        return getValue(pos);
    }

    public ValueType getValue(int pos) {
        return (ValueType) get(orderedKeys.get(pos));
    }

    @Override
    public int size() {
        return null != orderedKeys ? orderedKeys.size() : 0;
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

    public void append(OrderedDataMap<ValueType> orderedDataMap) {
        for (int i = 0; i < orderedDataMap.size(); ++i)
            putInOrder(orderedDataMap.getKey(i), orderedDataMap.getValue(i));
    }

    public void putInOrder(OrderedDataMap<ValueType> orderedDataMap) {
        append(orderedDataMap);
    }
}
