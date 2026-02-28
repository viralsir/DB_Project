import java.sql.*;

public class PostgresJdbcExample {
    public static void main(String[] args) throws Exception {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/testdb",
                "postgres",
                "1234");

        PreparedStatement ps =
                con.prepareStatement("insert into student values(?,?)");

        ps.setInt(1, 1);
        ps.setString(2, "Rahul");

        ps.executeUpdate();

        System.out.println("Inserted in PostgreSQL");

        con.close();
    }
}