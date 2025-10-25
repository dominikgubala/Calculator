package pl.dominikgubala.advancedprogramming2.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.dominikgubala.advancedprogramming2.calculator.common.defs.Strings;
import pl.dominikgubala.advancedprogramming2.calculator.common.utils.ResourceHelper;
import pl.dominikgubala.advancedprogramming2.calculator.controller.CalculatorController;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class CalculatorApp extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = createScene();
        stage.setScene(scene);
        stage.setTitle(Strings.APP_NAME.value);
        stage.show();
    }

    private Scene createScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(ResourceHelper.getResource(CalculatorController.MAIN_VIEW));
        loader.setResources(ResourceBundle.getBundle(Strings.TRANSLATIONS.value, Locale.getDefault()));
        Parent parent = loader.load();
        return new Scene(parent);
    }
}
