package au.com.tyo.json;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonForm extends JsonBase {

    public static final Object FORM_META_KEY_ORIENTATION = "orientation";
    public static final Object FORM_META_KEY_TEXT_STYLE = "text_style";
    public static String FORM_META_KEY_I18N = "i18n";
    public static String FORM_META_KEY_DATA_TYPE = "type";
    public static String FORM_META_KEY_WIDGET = "widget";
    public static String FORM_META_KEY_VISIBLE = "visible";

    /**
     *
     */
    @Key
    public String count = "1";

    /**
     * We use only one page
     */
    @Key
    public JsonFormStep step1;

    // private List<JsonFormStep> steps;

    @Key
    public String title = "";

    public JsonForm(String title) {
        super();
        this.title = title;
    }

    public JsonForm() {
        // steps = new ArrayList();
    }

    public JsonFormStep createNewStep() {
        return createNewStep("");
    }

    public JsonFormStep createNewStep(String s) {
        JsonFormStep  step = new JsonFormStep(s);
        //steps.add(step);

        //if (steps.size() == 0) {
            step1 = step;
        //}

        step.createFields();
        return step;
    }

    public JsonFormStep getStep(int i) {
        return step1;
        // return steps.get(i);
    }

}
