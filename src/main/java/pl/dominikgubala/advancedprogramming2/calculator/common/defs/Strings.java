package pl.dominikgubala.advancedprogramming2.calculator.common.defs;

public enum Strings {
    APP_NAME("Calculator"),
    TRANSLATIONS("translations.messages"),

    ;

    public final String value;

    Strings(String value) {
        this.value = value;
    }
}
