package com.example.vehicles;

import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class DBUtility {
    private static String user = "Jiaqi200477892";
    private static String password = "UeRfRiM5fr";
    //    connection string hostname / dbname
    private static String connectURL = "jdbc:mysql://172.31.22.43:3306/Jiaqi200477892";


    /**
     * Send to DB and return the id.
     */
    public static int insertIntoDB(Vehicles vehicles) throws SQLException {
        int id = -1;
        ResultSet resultSet = null;

        String sql = "INSERT INTO vehicles (carName, carBrand, carSold, price, isCarSport) VALUES (?,?,?,?,?);";

        //autoclose anything in the ()
        try (
                Connection conn = DriverManager.getConnection(connectURL, user, password);
                PreparedStatement ps = conn.prepareStatement(sql, new String[]{"id"})
        ) {
            //configure the prepared to stmt to prevent SQL injection attacks.
            ps.setString(1, vehicles.getCarName());
            ps.setString(2, vehicles.getCarBrand());
            ps.setInt(3, vehicles.getCarSold());
            ps.setDouble(4, vehicles.getPrice());
            ps.setBoolean(5, vehicles.getisCarSport());
            //run the command into DB.
            ps.executeUpdate();
            //get the id
            resultSet = ps.getGeneratedKeys();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //close the resultset
        finally {
            if (resultSet != null)
                resultSet.close();
        }

        return id;
    }

    /**
     * The method will return a list of all vehicle's and their number of sales.
     */
    public static ArrayList<Vehicles> getVehiclesFromDB() {
        ArrayList<Vehicles> vehicles = new ArrayList<>();
        //query the db and create objects / add to the list.
        String sql = "SELECT vehicles.carID,carName, carBrand,carSold, price,isCarSport as isCarSport,count(salesId) as carSalesNumber FROM vehicles \n" +
                " INNER JOIN vehicleSales \n" +
                " ON vehicles.carId = vehicleSales.carId\n" +
                " group by carID;";
        try (
                Connection conn = DriverManager.getConnection(connectURL, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("carId");
                String carName = resultSet.getString("carName");
                String carBrand = resultSet.getString("carBrand");
                int carSold = resultSet.getInt("carSold");
                double price = resultSet.getDouble("price");
                boolean isCarSport = resultSet.getBoolean("isCarSport");
                int carSalesNumber = resultSet.getInt("carSalesNumber");
                Vehicles newVehicles = new Vehicles(id, carName, carBrand, carSold, price, carSalesNumber);
//                Vehicles newVehicles = new Vehicles(id,carName,carBrand,carSold,price,isCarSport,carSalesNumber);
                System.out.println(newVehicles);
                vehicles.add(newVehicles);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicles;
    }


    public static XYChart.Series<String, Integer> getCarSold() {
        XYChart.Series<String, Integer> carSalesNumber = new XYChart.Series<>();
        carSalesNumber.setName("2022");
        ArrayList<Vehicles> vehicles = getVehiclesFromDB();

        for (Vehicles vehicle : vehicles) {
              carSalesNumber.getData().add(new XYChart.Data<>(vehicle.getNameAndBrand(), vehicle.getCarSalesNumber()));
//            carSalesNumber.getData().add(new XYChart.Data<>("Hello", 20));
//            carSalesNumber.getData().add(new XYChart.Data<>("HelloB", 40));
//            carSalesNumber.getData().add(new XYChart.Data<>("HelloC", 60));
//            System.out.println(carSold.toString());

        }
        return carSalesNumber;
    }
}
