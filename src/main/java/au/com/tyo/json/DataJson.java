/*
 * Copyright (c) 2018 TYONLINE TECHNOLOGY PTY. LTD. (TYO Lab)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package au.com.tyo.json;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 8/1/18.
 */

public class DataJson extends GenericJson {

    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public float getFloatString(String key) {
        float value = 0f;
        try {
            value = Float.parseFloat((String) get(key));
        }
        catch (Exception ex) {}
        return value;
    }

    public double getDoubleFromString(String key) {
        double value = 0f;
        try {
            value = Double.parseDouble((String) get(key));
        }
        catch (Exception ex) {}
        return value;
    }

    public int getIntFromString(String key) {
        return (int) getFloatString(key);
    }

    public int getInt(String key) {
        try {
            return (int) get(key);
        }
        catch (Exception ex) {
            try {
                return (int) getDouble(key);
            }
            catch (Exception e1) {
                try {
                    return (int) getDoubleFromString(key);
                }
                catch (Exception e2) {

                }
            }
        }
        return 0;
    }

    public double getDouble(String key) {
        try {
            return (double) get(key);
        }
        catch (Exception ex) {}
        return 0;
    }

    public Object get(String key) {
        if (containsKey(key))
            return super.get(key);
        return "";
    }

    protected List getListData(String name) {
        return getListData(this, name);
    }

    protected static List getListData(Map parentMap, String name) {
        List list = (List) parentMap.get(name);

        if (list == null) {
            list = createList();
            parentMap.put(name, list);
        }
        return list;
    }

    protected static List createList() {
        return new ArrayList();
    }

    protected Map getMapData(String name) {
        return getMapData(this, name);
    }

    protected static Map getMapData(Map parentMap, String name) {
        Map map = (Map) parentMap.get(name);

        if (map == null) {
            map = createMapData();
            parentMap.put(name, map);
        }
        return map;
    }

    protected static GenericData createMapData() {
        return new GenericData();
    }

    protected Map createMapData(String name, Object value) {
        Map map = createMapData();
        map.put(name, value);
        return map;
    }
}
