package com.example.vehicles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VehicleChartViewController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis categoryAxis;

    @FXML
    private NumberAxis numberAxis;

    private XYChart.Series<String, Integer> carSold;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        barChart.getData().addAll(DBUtility.getCarSold());
        numberAxis.setLabel("Car Sold");
        categoryAxis.setLabel("Car Name and Brand");
        //FAKE DATA CREATION
        XYChart.Series<String, Integer> carSold = new XYChart.Series<>();
        carSold.getData().addAll(new XYChart.Data<>("FAKE 1", 150));
        carSold.setName("2021");
        barChart.getData().addAll(carSold);
//        numberAxis.setLabel("car sold");
//        categoryAxis.setLabel("the brand");
    }

    @FXML
    private void loadTableView(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"car-sales-view.fxml");
    }

}