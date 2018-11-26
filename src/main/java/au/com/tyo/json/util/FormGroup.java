package au.com.tyo.json.util;

import au.com.tyo.json.JsonFormField;
import au.com.tyo.json.JsonFormFieldWithTitle;

public class FormGroup extends FormData {

    public FormGroup(String title) {
        super();
        setTitle(title);
    }

    public FormGroup() {

    }

    public void addField(String title, Object value) {
        addField(toKey(title), title, value);
    }

    public void addField(String key, String title, Object value) {
        FormField formField = new FormField(key, title, value);

        putInOrder(key, formField);
    }

    public void addTitledJsonFormField(String title, String type) {
        addTitledJsonFormField(title, type, null, false);
    }

    public void addTitledJsonFormField(String title, String value, String type, boolean clickable) {
        addTitledJsonFormField(toKey(title), title, value, type, clickable);
    }

    public void addTitledJsonFormField(String key, String title, String value, String type, boolean clickable) {
        JsonFormField jsonFormField = new JsonFormFieldWithTitle(key, title);
        jsonFormField.type = type;
        jsonFormField.value = value;
        jsonFormField.clickable = clickable;

        addField(key, title, jsonFormField);
    }

    public void addField(JsonFormFieldWithTitle jsonFormField) {
        addField(jsonFormField.key, jsonFormField.title, jsonFormField);
    }

    public void addField(JsonFormField jsonFormField) {
        addField(jsonFormField.key, toTitle(jsonFormField.key), jsonFormField);
    }
}
