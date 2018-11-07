package au.com.tyo.json.util;

import java.util.ArrayList;
import java.util.List;

public class OrderedDataMap extends DataJson {

    private List<String> orderedKeys;

    public void putInOrder(String key, Object value) {
        if (null == orderedKeys)
            orderedKeys = new ArrayList<>();

        if (!containsKey(key))
            orderedKeys.add(key);

        put(key, value);
    }

    public Object get(int pos) {
        return get(orderedKeys.get(pos));
    }
}
