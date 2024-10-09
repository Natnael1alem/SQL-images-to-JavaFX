package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/car_inventory";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM cars";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Car car = new Car(
                        rs.getInt("id"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getBigDecimal("price")
                );
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cars;
    }

    public static void addCar(Car car) {
        String query = "INSERT INTO cars (make, model, year, price) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, car.getMake());
            pstmt.setString(2, car.getModel());
            pstmt.setInt(3, car.getYear());
            pstmt.setBigDecimal(4, car.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
