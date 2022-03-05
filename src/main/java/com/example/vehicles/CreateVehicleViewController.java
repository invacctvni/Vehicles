package com.example.vehicles;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

        //configure the spinner to accept inputs by using spinner value factory.
        //the constructor takes max,min default and increment
        SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,10,5);
        carSoldSpinner.setValueFactory(spinnerValueFactory);
        carSoldSpinner.setEditable(true);
        TextField spinnerTextField = carSoldSpinner.getEditor();

        //create a custom changeListen class wasn't efficient - extra files and didn't allow access JavaFX objects
        //create anonymous inner class.
        spinnerTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                Integer.parseInt(newValue);
            } catch (Exception e) {
                msgLabel.setText("only whole numbers allowed for resolution");
                spinnerTextField.setText(oldValue);
            }
//                msgLabel.setText(String.format("Old value: %s new Value: %s", oldValue, newValue));
        });
    }


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
            msgLabel.setText("the car sold/price must be positive numbers only");

        }
            boolean isCarSport = sportCheckBox.isSelected();
        if (carSold != -1 && carPrice != -1) {
            Vehicles newCar = new Vehicles(carName, carBrand, carSold, carPrice, isCarSport);
            msgLabel.setText(newCar.toString());
        }
    }
}

