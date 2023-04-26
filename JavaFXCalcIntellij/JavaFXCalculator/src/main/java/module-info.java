module com.example.javafxcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxcalculator to javafx.fxml;
    exports com.example.javafxcalculator;
}