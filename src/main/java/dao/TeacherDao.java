package dao;

import db.DatabaseConnection;
import model.Teacher;

import java.sql.*;

public class TeacherDao {

    public void createTable() throws Exception {

        String sql = """
                CREATE TABLE IF NOT EXISTS teachers(
                    id SERIAL PRIMARY KEY,
                    full_name VARCHAR(100) NOT NULL,
                    email VARCHAR(100) UNIQUE,
                    subject VARCHAR(100),
                    phone_number VARCHAR(20),
                    employment_type VARCHAR(100),
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                )
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                Statement statement =
                        connection.createStatement()
        ) {

            statement.execute(sql);

            System.out.println(
                    "Teachers table created successfully."
            );
        }
    }

    public void addTeacher(
            Teacher teacher)
            throws Exception {

        String sql =
                """
                INSERT INTO teachers
                (full_name,email,subject,phone_number,employment_type)
                VALUES(?,?,?,?,?)
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(sql)
        ) {

            ps.setString(
                    1,
                    teacher.getFullName());

            ps.setString(
                    2,
                    teacher.getEmail());

            ps.setString(
                    3,
                    teacher.getSubject());

            ps.setString(
                    4,
                    teacher.getPhoneNumber());

            ps.setString(
                    5,
                    teacher.getemployment_type());
            
            

            int rows =
                    ps.executeUpdate();

            System.out.println(
                    rows + " teacher inserted."
            );
        }
    }

    public Teacher getTeacherById(
            int id)
            throws Exception {

        String sql =
                "SELECT * FROM teachers WHERE id=?";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                Teacher teacher =
                        new Teacher();

                teacher.setId(
                        rs.getInt("id"));

                teacher.setFullName(
                        rs.getString("full_name"));

                teacher.setEmail(
                        rs.getString("email"));

                teacher.setSubject(
                        rs.getString("subject"));

                teacher.setPhoneNumber(
                        rs.getString("phone_number"));
                
                teacher.setemployment_type(
                        rs.getString("employment_type"));

                teacher.setCreatedAt(
                        rs.getTimestamp("created_at"));

                return teacher;
            }
        }

        return null;
    }

    public void updateTeacher(
            Teacher teacher)
            throws Exception {

        String sql =
                """
                UPDATE teachers
                SET
                full_name=?,
                email=?,
                subject=?,
                phone_number=?,
                employment_type=?
                WHERE id=?
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(sql)
        ) {

            ps.setString(
                    1,
                    teacher.getFullName());

            ps.setString(
                    2,
                    teacher.getEmail());

            ps.setString(
                    3,
                    teacher.getSubject());

            ps.setString(
                    4,
                    teacher.getPhoneNumber());

            ps.setString(
                    5,
                    teacher.getemployment_type());

            ps.setInt(
                    6,
                    teacher.getId());

            int rows =
                    ps.executeUpdate();

            System.out.println(
                    rows + " teacher updated."
            );
        }
    }

    public void deleteTeacher(
            int id)
            throws Exception {

        String sql =
                "DELETE FROM teachers WHERE id=?";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            int rows =
                    ps.executeUpdate();

            System.out.println(
                    rows + " teacher deleted."
            );
        }
    }
}