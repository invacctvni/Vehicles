package com.example.vehicles;

import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Formatter;

public class FakeSalesData {

    /**
     * This method will create a file with fake phone sales data in it
     * an example of valid insert stmt is
     *    INSERT INTO tableName (var1,var2,...) VALUES (1,2,'');
     *    valid id = 1-4
     *    valid dates - anyday up to today
     */
    public static void createSQL() throws FileNotFoundException {
        //this is a random number generator
        SecureRandom rng = new SecureRandom();
        //open the formatter in the try .... with resources block to auto-close.
        try(
                Formatter formatter = new Formatter("vehicleSales.sql");
                )
        {
            //create the fake data and write it to the file.
            for (int i = 1; i<=50; i ++) {
                int carId = rng.nextInt(1,5);
                //365*3 any day in the last 3 years. so we create the random dates with last 3 years.
                LocalDate dateSold = LocalDate.now().minusDays(rng.nextInt(1095));
                formatter.format("INSERT INTO vehicleSales(carID, dateSold) VALUES(%d, '%s');%n", carId,dateSold);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        createSQL();
    }



}
