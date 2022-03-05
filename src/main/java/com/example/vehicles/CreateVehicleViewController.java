package com.example.vehicles;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateVehicleViewController implements Initializable {

    @FXML
    private ComboBox<String> brandComboBox;

    @FXML
    private TextField carNameTextField;

    @FXML
    private Spinner<Integer> carSoldSpinner;

    @FXML
    private Label msgLabel;

    @FXML
    private TextField priceTextField;

    @FXML
    private CheckBox sportCheckBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        msgLabel.setText("");
        brandComboBox.getItems().addAll(Vehicles.getBrands());
    }
//    @Override
//    public String toString() {
//
//    }
    public void createCar() {

            String carBrand = brandComboBox.getSelectionModel().getSelectedItem();
            String carName = carNameTextField.getText();
            int carSold = -1;
            double carPrice = -1;
            //!!! Need to parseInt
        try {
            //Change Spinner to integers.
            carSold = carSoldSpinner.getValue();
            carPrice = Double.parseDouble(priceTextField.getText());
        }
        catch (Exception e) {
            //print error message.
            msgLabel.setText("the car sold and price must be positive numbers only");

        }
            boolean isCarSport = sportCheckBox.isSelected();
        if (carSold != -1 && carPrice != -1) {
            Vehicles newCar = new Vehicles(carName, carBrand, carSold, carPrice, isCarSport);
            msgLabel.setText(newCar.toString());
        }
    }
}

