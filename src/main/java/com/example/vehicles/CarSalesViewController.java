package com.example.vehicles;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CarSalesViewController implements Initializable {

    @FXML
    private TableView<Vehicles> tableView;

    @FXML
    private TableColumn<Vehicles, String> carNameColumn;

    @FXML
    private TableColumn<Vehicles, Integer> carSaleActNumberColumn;

    @FXML
    private TableColumn<Vehicles, Integer> idColumn;

    @FXML
    private TableColumn<Vehicles, Boolean> isCarSportColumn;

    @FXML
    private TableColumn<Vehicles, Double> priceColumn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Vehicles> vehicles = DBUtility.getVehiclesFromDB();
        System.out.println("");
    }
}