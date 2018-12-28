package au.com.tyo.json.form;

import au.com.tyo.json.jsonform.JsonFormField;
import au.com.tyo.json.jsonform.JsonFormFieldWithTitle;

import static au.com.tyo.json.jsonform.JsonFormField.VALUE_NULLABLE;

public class FormGroup extends FormData {

    public FormGroup(String title) {
        this(title, false);
    }

    public FormGroup(String title, boolean showTitle) {
        super();
        setTitle(title);
        setShowingTitle(showTitle);
    }

    public FormGroup() {
        this(null);
    }

    public void addField(String title, Object value) {
        addField(FormField.toKey(title), title, value);
    }

    public void addField(String key, String title, Object value) {
        FormField formField = new FormField(key, title, value);

        putInOrder(key, formField);
    }

    public JsonFormField addTitledJsonFormField(String title, String type) {
        return addTitledJsonFormField(title, type, null, false);
    }

    public JsonFormField addTitledJsonFormField(String title, String value, String type, boolean clickable) {
        return addTitledJsonFormField(FormField.toKey(title), title, value, type, clickable);
    }

    public JsonFormField addTitledJsonFormField(String key, String title, String value, String type, boolean clickable) {
        return addTitledJsonFormField(key, title, value, type, clickable, VALUE_NULLABLE);
    }

    public JsonFormField addTitledJsonFormField(String key, String title, String value, String type, boolean clickable, int required) {
        JsonFormField jsonFormField = new JsonFormFieldWithTitle(key, title);
        jsonFormField.type = type;
        jsonFormField.value = value;
        jsonFormField.clickable = clickable;
        jsonFormField.required = required;

        addField(key, title, jsonFormField);
        return jsonFormField;
    }

    public void addField(JsonFormFieldWithTitle jsonFormField) {
        addField(jsonFormField.key, jsonFormField.title, jsonFormField);
    }

    public void addField(JsonFormField jsonFormField) {
        addField(jsonFormField.key, FormField.toTitle(jsonFormField.key), jsonFormField);
    }
}
