package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/person_list";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static List<Person> getAllPersons() {
        List<Person> ps = new ArrayList<>();
        String query = "SELECT * FROM Person";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Person p = new Person(
                    rs.getString("name")
                );
                ps.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    public static void addPerson(Person p) {
        String query = "INSERT INTO Person (name) VALUES (?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, p.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
