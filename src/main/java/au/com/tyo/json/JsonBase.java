package au.com.tyo.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 17/7/17.
 */

public class JsonBase implements Serializable {

    static private Gson gson;

    static {
        gson = new GsonBuilder().create();
    }

    public static String toJson(Object form) {
        return gson.toJson(form);
    }

    public String toString() {
       return toJson(this);
    }

}
