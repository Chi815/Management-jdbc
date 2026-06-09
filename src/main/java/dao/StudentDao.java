package dao;

import db.DatabaseConnection;
import model.Student;

import java.sql.*;

public class StudentDao {

    public void createTable() throws Exception {

        String sql = """
                CREATE TABLE IF NOT EXISTS students(
                    id SERIAL PRIMARY KEY,
                    full_name VARCHAR(100) NOT NULL,
                    email VARCHAR(100) UNIQUE,
                    address VARCHAR(255),
                    phone_number VARCHAR(20),
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                )
                """;

        Connection connection =
                DatabaseConnection.getConnection();

        Statement statement =
                connection.createStatement();

        statement.execute(sql);

        System.out.println(
                "Students table created successfully."
        );
    }

    public void addStudent(Student student)
            throws Exception {

        String sql =
                """
                INSERT INTO students
                (full_name,email,address,phone_number)
                VALUES(?,?,?,?)
                """;

        Connection connection =
                DatabaseConnection.getConnection();

        PreparedStatement ps =
                connection.prepareStatement(sql);

        ps.setString(1, student.getFullName());
        ps.setString(2, student.getEmail());
        ps.setString(3, student.getAddress());
        ps.setString(4, student.getPhoneNumber());

        int rows = ps.executeUpdate();

        System.out.println(
                rows + " student inserted."
        );
    }

    public Student getStudentById(int id)
            throws Exception {

        String sql =
                "SELECT * FROM students WHERE id=?";

        Connection connection =
                DatabaseConnection.getConnection();

        PreparedStatement ps =
                connection.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs =
                ps.executeQuery();

        if (rs.next()) {

            Student student =
                    new Student();

            student.setId(
                    rs.getInt("id"));

            student.setFullName(
                    rs.getString("full_name"));

            student.setEmail(
                    rs.getString("email"));

            student.setAddress(
                    rs.getString("address"));

            student.setPhoneNumber(
                    rs.getString("phone_number"));

            student.setCreatedAt(
                    rs.getTimestamp("created_at"));

            return student;
        }

        return null;
    }

    public void deleteStudent(int id)
            throws Exception {

        String sql =
                "DELETE FROM students WHERE id=?";

        Connection connection =
                DatabaseConnection.getConnection();

        PreparedStatement ps =
                connection.prepareStatement(sql);

        ps.setInt(1, id);

        int rows =
                ps.executeUpdate();

        System.out.println(
                rows + " student deleted."
        );
    }

    public void updateStudent(Student student)
            throws Exception {

        String sql =
                """
                UPDATE students
                SET
                full_name=?,
                email=?,
                address=?,
                phone_number=?
                WHERE id=?
                """;

        Connection connection =
                DatabaseConnection.getConnection();

        PreparedStatement ps =
                connection.prepareStatement(sql);

        ps.setString(
                1,
                student.getFullName());

        ps.setString(
                2,
                student.getEmail());

        ps.setString(
                3,
                student.getAddress());

        ps.setString(
                4,
                student.getPhoneNumber());

        ps.setInt(
                5,
                student.getId());

        int rows =
                ps.executeUpdate();

        System.out.println(
                rows + " student updated."
        );
    }
}