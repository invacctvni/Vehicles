module com.example.vehicles {
    requires javafx.controls;
    requires javafx.fxml;
    /***/
    requires java.sql;


    opens com.example.vehicles to javafx.fxml;
    exports com.example.vehicles;
}