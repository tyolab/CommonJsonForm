package au.com.tyo.json;

import com.google.api.client.util.Key;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonFormGroup {

    @Key
    public String title;

    public JsonFormGroup(String s) {
        this.title = s;
    }

    public void createFields() {
        fields = new ArrayList<>();
    }

    public JsonFormField addField(JsonFormField field) {
        fields.add(field);
        return field;
    }

    public void sort() {
        Collections.sort(fields);
    }
    /**
     * Fields directly showed in form
     */
    @Key
    public List<JsonFormField> fields;
}
