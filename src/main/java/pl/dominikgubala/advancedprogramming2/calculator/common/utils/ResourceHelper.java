package pl.dominikgubala.advancedprogramming2.calculator.common.utils;

import pl.dominikgubala.advancedprogramming2.calculator.CalculatorApp;

import java.net.URL;

public class ResourceHelper {
    private final static Class<CalculatorApp> APP = CalculatorApp.class;

    public static URL getResource(String name) {
        try {
            return APP.getResource(name.toLowerCase() + ".fxml");
        } catch (Exception ignored) {
            return null;
        }
    }

    public static URL getAction(String name) {
        try {
            return APP.getResource("actions/" + name.toLowerCase() + ".fxml");
        } catch (Exception ignored) {
            return null;
        }
    }
}
