package au.com.tyo.json;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 23/8/17.
 */

public class JsonFormFieldFilter extends NameValuePair {

    public static final String FILTER_ALLCAPS = "f_allcaps";
    public static final String FILTER_NUMBERIC = "f_numberic";
    public static final String FILTER_DECIMAL = "f_decimal";
    public static final String FILTER_TEXT = "f_text";
    public static final String FILTER_CAP_SENTENCES = "f_cap_sentences";
    public static final String FILTER_CAP_WORDS = "f_cap_words";
    public static final String FILTER_CAP_CHARACTERS = "f_cap_characters";
    //public static final String FILTER_DISIMAL = "f_number";

    public JsonFormFieldFilter(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static JsonFormFieldFilter createNumericFilter() {
        return new JsonFormFieldFilter(FILTER_NUMBERIC, "true");
    }

    public static JsonFormFieldFilter createAllCapsFilter() {
        return new JsonFormFieldFilter(FILTER_ALLCAPS, "true");
    }

    public static JsonFormFieldFilter createTextFilter() {
        return new JsonFormFieldFilter(FILTER_TEXT, "true");
    }

    public static JsonFormFieldFilter createCapSentencesFilter() {
        return new JsonFormFieldFilter(FILTER_CAP_SENTENCES, "true");
    }

    public static JsonFormFieldFilter createCapWordsFilter() {
        return new JsonFormFieldFilter(FILTER_CAP_WORDS, "true");
    }

    public static JsonFormFieldFilter createCapCharactersFilter() {
        return new JsonFormFieldFilter(FILTER_CAP_CHARACTERS, "true");
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
