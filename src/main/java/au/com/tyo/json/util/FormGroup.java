package au.com.tyo.json.util;

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

}
