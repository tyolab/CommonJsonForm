package au.com.tyo.json.util;

import com.google.api.client.util.Key;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 24/10/17.
 */

public class NameValuePair {

    @Key public String name;
    @Key public String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NameValuePair that = (NameValuePair) o;

        return name != null ? name.equals(that.name) : that.name == null;

    }
}
