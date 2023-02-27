module com.example.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.alenso.calculator to javafx.fxml;
    exports fr.alenso.calculator;
}