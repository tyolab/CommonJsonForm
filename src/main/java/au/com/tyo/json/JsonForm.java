package au.com.tyo.json;

import com.google.api.client.util.Key;
import com.google.gson.internal.LinkedTreeMap;

import java.util.Set;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonForm extends JsonBase {

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

    public static JsonForm toForm(LinkedTreeMap data) {
        JsonForm form = new JsonForm();
        form.createNewStep();

        Set<LinkedTreeMap.Entry<String, Object>> list = data.entrySet();

        for (LinkedTreeMap.Entry<String, Object> entry : list) {
            String key = entry.getKey();
            Object value = entry.getValue();


        }

        return form;
    }

}
