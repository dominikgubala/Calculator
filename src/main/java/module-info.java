module Calculator.main {
    requires javafx.controls;
    requires javafx.fxml;

    opens pl.dominikgubala.advancedprogramming2.calculator to javafx.fxml;
    exports pl.dominikgubala.advancedprogramming2.calculator;
}