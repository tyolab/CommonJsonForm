package au.com.tyo.json.util;

import static au.com.tyo.json.form.DataFormEx.ABSORB_DATA_PREFIX_DEFAULT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import au.com.tyo.json.form.DataJson;

public class OrderedDataMap<ValueType, ContainerType extends List<ValueType>> extends DataJson {

    private List<String>            orderedKeys;
    private ContainerType           values;

    /**
     *
     * @param key
     * @param valueType
     */
    public void pushBack(String key, ValueType valueType) {
        putInOrder(key, valueType);
    }

    /**
     * The put method won't keep the entry in order
     *
     * @param key
     * @param value
     */
    public void putInOrder(String key, ValueType value) {

        if (null != key && (key.charAt(0) != '$' || key.startsWith(ABSORB_DATA_PREFIX_DEFAULT))) {
            if (null == orderedKeys)
                orderedKeys = new ArrayList<>();

            if (!containsKey(key)) {
                orderedKeys.add(key);

                // use ArrayList as container if no container set
                if (null == values)
                    values = (ContainerType) new ArrayList();
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
        if (pos < 0 || pos >= sizeOfOrder())
            throw new IllegalArgumentException("The position of the item can't be negative or greater than the size of order " + sizeOfOrder());
        return (ValueType) get(orderedKeys.get(pos));
    }

    public int size() {
        return sizeOfOrder();
    }

    public int sizeOfOrder() {
        return null != orderedKeys ? orderedKeys.size() : 0;
    }

    public List<String> getOrderedKeys() {
        return orderedKeys;
    }

    public String getKey(int pos) {
        return orderedKeys.get(pos);
    }

    public ContainerType getOrderedValues() {
        return values;
    }

    public void append(OrderedDataMap orderedDataMap) {
        for (int i = 0; i < orderedDataMap.size(); ++i)
            putInOrder(orderedDataMap.getKey(i), (ValueType) orderedDataMap.getValue(i));
    }

    public void putInOrder(OrderedDataMap orderedDataMap) {
        append(orderedDataMap);
    }

    public void setOrderContainer(ContainerType container) {
        values = container;
    }

    public ContainerType getOrderContainer() {
        return getValues();
    }

    public ContainerType getValues() {
        return values;
    }

    public void removeOldest() {
        synchronized (this) {
            if (null == orderedKeys || orderedKeys.size() == 0)
                return;
            String ketStr = orderedKeys.get(0);
            remove(ketStr);
            orderedKeys.remove(0);
            values.remove(0);
        }
    }

    public ValueType popOldest() {
        ValueType value = peekOldest();

        removeOldest();

        return value;
    }

    public ValueType peekOldest() {
        if (null == values || values.size() == 0)
            return null;

        ValueType value = values.get(0);
        return value;
    }
}
