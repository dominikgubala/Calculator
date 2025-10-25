package pl.dominikgubala.advancedprogramming2.calculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import pl.dominikgubala.advancedprogramming2.calculator.common.defs.Type;
import pl.dominikgubala.advancedprogramming2.calculator.common.utils.ResourceHelper;
import pl.dominikgubala.advancedprogramming2.calculator.common.utils.Translator;
import pl.dominikgubala.advancedprogramming2.calculator.model.CalculatorModel;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class CalculatorController {

    public final static String MAIN_VIEW = "view";
    private final static DecimalFormat DEC = new DecimalFormat("0.##");

    private final CalculatorModel model = new CalculatorModel();

    @FXML
    private ComboBox<Type> types;

    @FXML
    private StackPane container;

    @FXML
    public void initialize() {
        types.getItems().addAll(Type.values());
        types.getSelectionModel().selectFirst();
        onClick();
    }

    @FXML
    public void onClick() {
        try {

            Type selected = types.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader(ResourceHelper.getAction(selected.name()));
            loader.setResources(ResourceBundle.getBundle("translations.messages", Locale.getDefault()));
            Parent view = loader.load();
            container.getChildren().setAll(view);

            Button btn = (Button) view.lookup("#calculateBtn");
            if (btn != null) {
                switch (selected) {
                    case ADD -> btn.setOnAction(this::onAdd);
                    case SUBTRACT -> btn.setOnAction(this::onSubtract);
                    case MULTIPLY -> btn.setOnAction(this::onMultiply);
                    case DIVIDE -> btn.setOnAction(this::onDivide);
                }
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    @FXML
    private void onAdd(ActionEvent event) {
        try {
            Double num1 = getNum1();
            Double num2 = getNum2();
            if (num1 != null && num2 != null) {
                double res = model.add(num1, num2);
                showResult(res);
            } else
                showError("");
        } catch (Exception e) {
            showError(e.getMessage());
        }
    }

    @FXML
    private void onSubtract(ActionEvent event) {
        try {
            Double num1 = getNum1();
            Double num2 = getNum2();
            if (num1 != null && num2 != null) {
                double res = model.subtract(num1, num2);
                showResult(res);
            } else
                showError("");
        } catch (Exception e) {
            showError(e.getMessage());
        }
    }

    @FXML
    private void onMultiply(ActionEvent event) {
        try {
            Double num1 = getNum1();
            Double num2 = getNum2();
            if (num1 != null && num2 != null) {
                double res = model.multiply(num1, num2);
                showResult(res);
            } else
                showError("");
        } catch (Exception e) {
            showError(e.getMessage());
        }
    }

    @FXML
    private void onDivide(ActionEvent event) {
        try {
            Double num1 = getNum1();
            Double num2 = getNum2();
            if (num1 != null && num2 != null) {
                double res = model.divide(num1, num2);
                showResult(res);
            } else
                showError("");
        } catch (Exception e) {
            showError(e.getMessage());
        }
    }

    private Double getNum1() {
        try {
            TextField input = (TextField) container.lookup("#input1");
            String number = input.getText();
            return (number == null || number.isEmpty()) ? null : Double.parseDouble(number);
        } catch (Exception ignored) {
            return null;
        }
    }

    private Double getNum2() {
        try {
            TextField input = (TextField) container.lookup("#input2");
            String number = input.getText();
            return (number == null || number.isEmpty()) ? null : Double.parseDouble(number);
        } catch (Exception ignored) {
            return null;
        }
    }

    private Label getResultArea() {
        return (Label) container.lookup("#resultLabel");
    }

    private void showResult(double result) {
        getResultArea().setText(Translator.trans("result", DEC.format(result)));
    }

    private void showError(String message) {
        getResultArea().setText(message);
    }
}
