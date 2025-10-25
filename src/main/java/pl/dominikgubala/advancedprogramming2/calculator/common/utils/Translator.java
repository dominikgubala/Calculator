package pl.dominikgubala.advancedprogramming2.calculator.common.utils;

import pl.dominikgubala.advancedprogramming2.calculator.common.defs.Strings;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Translator {
    private static final ResourceBundle resource = ResourceBundle.getBundle(Strings.TRANSLATIONS.value, Locale.getDefault());

    public static String trans(String key, Object... args) {
        try {
            String value = resource.getString(key);
            return args.length > 0 ? MessageFormat.format(value, args) : value;
        } catch (MissingResourceException ignored) {
            return key;
        }
    }
}
