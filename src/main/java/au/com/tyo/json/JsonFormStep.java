package au.com.tyo.json;

import com.google.api.client.util.Key;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormStep {

    @Key
    public List<JsonFormField> fields;

    @Key
    public String title;

    public JsonFormStep(String s) {
        this.title = s;
    }

    public void createFields() {
        fields = new ArrayList<>();
    }

    public JsonFormField addField(JsonFormField field) {
        fields.add(field);
        return field;
    }
}
