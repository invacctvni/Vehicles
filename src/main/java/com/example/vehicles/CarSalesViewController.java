package com.example.vehicles;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CarSalesViewController implements Initializable {

    @FXML
    private TableColumn<Vehicles, String> carBrandColumn;

    @FXML
    private TableColumn<Vehicles, String> carNameColumn;

    @FXML
    private TableColumn<Vehicles, Integer> carSalesActNumberColumn;

    @FXML
    private TableColumn<Vehicles, Integer> carSoldColumn;

    @FXML
    private TableColumn<Vehicles, Integer> idColumn;
    @FXML
    private TableColumn<Vehicles, Double> priceColumn;

    @FXML
    private TableView<Vehicles> tableView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        ArrayList<Vehicles> vehicles = DBUtility.getVehiclesFromDB();
//        System.out.println("");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        carNameColumn.setCellValueFactory(new PropertyValueFactory<>("carName"));
        carBrandColumn.setCellValueFactory(new PropertyValueFactory<>("carBrand"));
        carSoldColumn.setCellValueFactory(new PropertyValueFactory<>("carSold"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        carSalesActNumberColumn.setCellValueFactory(new PropertyValueFactory<>("carSalesNumber"));
        tableView.getItems().addAll(DBUtility.getVehiclesFromDB());
    }
}