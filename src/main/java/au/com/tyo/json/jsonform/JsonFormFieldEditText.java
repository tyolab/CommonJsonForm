package au.com.tyo.json.jsonform;

import com.google.api.client.util.Key;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonFormFieldEditText extends JsonFormFieldWithTitleAndHint {

    @Key
    public List<JsonFormFieldValidator> validators;

    @Key
    public List<JsonFormFieldFilter> filters;

    @Key
    public int maxLength = -1;

    @Key
    public int minLength = -1;

    @Key
    public boolean has_validator;

    public JsonFormFieldEditText(String key, String title, String hint) {
        super(key, title, hint);
    }

    public JsonFormFieldEditText(String key, String title) {
        this(key, title, REQUIRED);
        addRequiredValidator("Cannot be empty");
    }

    public void addValidator(JsonFormFieldValidator validator) {
        if (null == validators)
            validators = new ArrayList<>();

        for (JsonFormFieldValidator tor : validators)
            if (tor.equals(validator))
                return;

        validators.add(validator);
    }

    public void addRequiredValidator(String errorMessage) {
        addValidator(JsonFormFieldValidator.createRequiredValidator(errorMessage));
    }

    public void addAllCapsFilter() {
        addFilter(JsonFormFieldFilter.createAllCapsFilter());
    }

    public void addNumericValidator(String errorMessage) {
        addValidator(JsonFormFieldValidator.createNumericValidator(errorMessage));
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
