import java.sql.*;

public class PostgresJdbcExample {
    public static void main(String[] args) throws Exception {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/ArahmDB",
                "postgres",
                "1234");

        PreparedStatement ps =
                con.prepareStatement("insert into public.student values(?,?,?)");

        ps.setInt(1, 2);
        ps.setString(2, "Rahul");
        ps.setInt(3,44);

        ps.executeUpdate();

        System.out.println("Inserted in PostgreSQL");

        con.close();
    }
}