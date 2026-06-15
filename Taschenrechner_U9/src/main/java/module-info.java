module com.example.taschenrechner_u9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.taschenrechner_u9 to javafx.fxml;
    exports com.taschenrechner_u9;
}