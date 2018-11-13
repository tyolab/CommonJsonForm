package au.com.tyo.json;

import com.google.api.client.util.Key;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonFormGroup {

    @Key
    public String title;

    @Key
    public String visible = "true";

    @Key
    public boolean titleVisible ;

    public JsonFormGroup(String title) {
        this.title = title;
    }

    public JsonFormGroup() {

    }

    public void createFields() {
        fields = new ArrayList<>();
    }

    public JsonFormField addField(JsonFormField field) {
        if (null == fields)
            fields = new ArrayList<>();

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
