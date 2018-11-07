package au.com.tyo.json;

import com.google.api.client.util.Key;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormStep extends JsonFormGroup {

    /**
     * Groups with fields
     */
    @Key
    public List<JsonFormGroup> groups;

    public void createGroups() {
        groups = new ArrayList<>();
    }

    public JsonFormGroup addGroup(JsonFormGroup group) {
        groups.add(group);
        return group;
    }

    public JsonFormStep(String s) {
        super(s);
    }
}
