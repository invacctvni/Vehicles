package com.example.vehicles;

import java.sql.*;

public class DBUtility {
    private static String user = "Jiaqi200477892";
    private static String password = "UeRfRiM5fr";
    //    connection string hostname / dbname
    private static String connectURL = "jdbc:mysql://172.31.22.43:3306/Jiaqi200477892";


    /**
     *  Send to DB and return the id.
     */
    public static int insertIntoDB(Vehicles vehicles) throws SQLException {
        int id=-1;
        ResultSet resultSet = null;

        String sql = "INSERT INTO vehicles (carName, carBrand, carSold, price, isCarSport) VALUES (?,?,?,?,?);";

        //autoclose anything in the ()
        try(
                Connection conn = DriverManager.getConnection(connectURL,user,password);
                PreparedStatement ps = conn.prepareStatement(sql,new String[] {"id"})
                )
        {
            //configure the prepared to stmt to prevent SQL injection attacks.
            ps.setString(1,vehicles.getCarName());
            ps.setString(2,vehicles.getCarBrand());
            ps.setInt(3,vehicles.getCarSold());
            ps.setDouble(4,vehicles.getPrice());
            ps.setBoolean(5,vehicles.getisCarSport());
            //run the command into DB.
            ps.executeUpdate();
            //get the id
            resultSet = ps.getGeneratedKeys();
            while(resultSet.next()) {
                    id = resultSet.getInt(1);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        //close the resultset
        finally {
            if(resultSet != null)
                resultSet.close();
        }

        return id;
    }




}
