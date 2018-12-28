package au.com.tyo.json.jsonform;

import com.google.api.client.util.Key;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormStep extends JsonFormGroup {

    @Key
    public Object header;

    @Key
    public Object footer;

    /**
     * Groups with fields
     */
    @Key
    public List<JsonFormGroup> groups;

    public JsonFormGroup addGroup(JsonFormGroup group) {
        if (null == groups)
            groups = new ArrayList<>();

        groups.add(group);
        return group;
    }

    public JsonFormStep(String s) {
        super(s);
    }
}
