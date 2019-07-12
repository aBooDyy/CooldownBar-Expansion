package me.aboodyy.cooldownbarexpansion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static int convertToSec(String cooldown) {
        int seconds = 0;

        if (contains(cooldown, "[0-9]{1,2}d"))
            seconds += get(cooldown, "[0-9]{1,2}d") * 24 * 60 * 60;

        if (contains(cooldown, "[0-9]{1,2}h"))
            seconds += get(cooldown, "[0-9]{1,2}h") * 60 * 60;

        if (contains(cooldown, "[0-9]{1,2}m"))
            seconds += get(cooldown, "[0-9]{1,2}m") * 60;

        if (contains(cooldown, "[0-9]{1,2}s"))
            seconds += get(cooldown, "[0-9]{1,2}s");

        return seconds;
    }

    public static boolean contains(String text, String regex) {
        Pattern ex = Pattern.compile(regex);
        Matcher match = ex.matcher(text);
        return match.find();
    }

    public static int get(String text, String regex) {
        Pattern ex = Pattern.compile(regex);
        Matcher match = ex.matcher(text);
        if (match.find()) {
            String value = match.group(0);
            return Integer.valueOf(value.substring(0, value.length() - 1));
        }
        return 0;
    }

}
