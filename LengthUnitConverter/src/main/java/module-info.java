module com.example.lengthapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lengthapplication to javafx.fxml;
    exports com.example.lengthapplication;
}