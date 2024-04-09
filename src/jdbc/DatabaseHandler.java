package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin1234";

    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create a new person in the database
    public void createPerson(Person person) {
        try {
            String query = "INSERT INTO persons (name, age) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, person.getName());
                preparedStatement.setInt(2, person.getAge());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve all persons from the database
    public List<Person> readAllPersons() {
        List<Person> persons = new ArrayList<>();
        try {
            String query = "SELECT * FROM persons";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    Person person = new Person();
                    person.setId(resultSet.getInt("id"));
                    person.setName(resultSet.getString("name"));
                    person.setAge(resultSet.getInt("age"));
                    persons.add(person);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    // Update a person in the database
    public void updatePerson(Person person) {
        try {
            String query = "UPDATE persons SET name = ?, age = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, person.getName());
                preparedStatement.setInt(2, person.getAge());
                preparedStatement.setInt(3, person.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a person from the database
    public void deletePerson(int personId) {
        try {
            String query = "DELETE FROM persons WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, personId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete all persons from the database
    public void deleteAllPersons() {
        try {
            String query = "DELETE FROM persons";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.executeUpdate();
                System.out.println("All persons deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
