package au.com.tyo.json.util;

public interface TitleKeyConverter {
    String toKey(String title);
    String toTitle(String key);
}
