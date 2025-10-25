package pl.dominikgubala.advancedprogramming2.calculator.common.defs;

import pl.dominikgubala.advancedprogramming2.calculator.common.utils.Translator;

public enum Type {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,

    ;

    @Override
    public String toString() {
        return Translator.trans("type." + name().toLowerCase());
    }
}
