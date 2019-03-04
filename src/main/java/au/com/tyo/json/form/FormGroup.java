package au.com.tyo.json.form;

import au.com.tyo.json.jsonform.JsonFormField;
import au.com.tyo.json.jsonform.JsonFormFieldWithTitle;

import static au.com.tyo.json.jsonform.JsonFormField.CLICKABLE_FIELD;
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

    public FormField addField(String title, Object value) {
        return addField(title, value, 0);
    }

    public FormField addField(String title, Object value, int clickable) {
        return addField(FormField.toKey(title), title, value, clickable);
    }

    public FormField addField(String key, String title, boolean value) {
        return addField(key, title, value, CLICKABLE_FIELD);
    }

    public FormField addField(String key, String title, Object value, int clickable) {
        FormField formField = new FormField(key, title, value);
        formField.setClickable(clickable);

        putInOrder(key, formField);

        return formField;
    }

    public JsonFormField addTitledJsonFormField(String title, String type) {
        return addTitledJsonFormField(title, type, null, 0);
    }

    public JsonFormField addTitledJsonFormField(String title, String value, String type, int clickable) {
        return addTitledJsonFormField(FormField.toKey(title), title, value, type, clickable);
    }

    public JsonFormField addTitledJsonFormField(String key, String title, String value, String type, int clickable) {
        return addTitledJsonFormField(key, title, value, type, clickable, VALUE_NULLABLE);
    }

    public JsonFormField addTitledJsonFormField(String key, String title, String value, String type, int clickable, int required) {
        JsonFormField jsonFormField = new JsonFormFieldWithTitle(key, title);
        jsonFormField.type = type;
        jsonFormField.value = value;
        jsonFormField.clickable = clickable;
        jsonFormField.required = required;

        addField(key, title, jsonFormField, clickable);
        return jsonFormField;
    }

    public void addField(JsonFormFieldWithTitle jsonFormField) {
        addField(jsonFormField.key, jsonFormField.title, jsonFormField, jsonFormField.clickable);
    }

    public void addField(JsonFormField jsonFormField) {
        addField(jsonFormField.key, FormField.toTitle(jsonFormField.key), jsonFormField, jsonFormField.clickable);
    }
}
