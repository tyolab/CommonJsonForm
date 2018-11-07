package au.com.tyo.json;

import com.google.api.client.util.Key;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldEditText extends JsonFormFieldWithTitleAndHint {

    @Key
    public boolean editable;

    @Key
    public List<JsonFormFieldValidator> validators;

    @Key
    public List<JsonFormFieldFilter> filters;

    @Key
    public int maxLength = -1;

    @Key
    public int minLength = -1;

    public JsonFormFieldEditText(String key, String type, String title, String hint) {
        super(key, type, title, hint);
    }

    public JsonFormFieldEditText(String key, String title, String hint) {
        this(key, Constants.JSON_FORM_WIDGET_KEY_TITLED_EDIT_TEXT, title, hint);
    }

    public JsonFormFieldEditText(String key, String title) {
        this(key, title, REQUIRED);
        addRequiredValidator();
    }

    public void addValidator(JsonFormFieldValidator validator) {
        if (null == validators)
            validators = new ArrayList<>();

        for (JsonFormFieldValidator tor : validators)
            if (tor.equals(validator))
                return;

        validators.add(validator);
    }

    public void addRequiredValidator() {
        addValidator(JsonFormFieldValidator.createRequiredValidator());
    }

    public void addAllCapsFilter() {
        addFilter(JsonFormFieldFilter.createAllCapsFilter());
    }

    public void addNumericValidator() {
        addValidator(JsonFormFieldValidator.createNumericValidator());
    }

    public void addNumericFilter() {
        addFilter(JsonFormFieldFilter.createNumericFilter());
    }

    public void addFilter(JsonFormFieldFilter filter) {
        if (null == filters)
            filters = new ArrayList<>();

        for (JsonFormFieldFilter tor : filters)
            if (tor.equals(filter))
                return;

        filters.add(filter);
    }

    public void addCapSentencesFilter() {
        addFilter(JsonFormFieldFilter.createTextFilter());
        addFilter(JsonFormFieldFilter.createCapSentencesFilter());
    }

    public void addCapWordsFilter() {
        addFilter(JsonFormFieldFilter.createTextFilter());
        addFilter(JsonFormFieldFilter.createCapWordsFilter());
    }

    public void addCapCharactersFilter() {
        addFilter(JsonFormFieldFilter.createTextFilter());
        addFilter(JsonFormFieldFilter.createCapCharactersFilter());
    }
}
