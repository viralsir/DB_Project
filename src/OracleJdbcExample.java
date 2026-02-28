import java.sql.*;

/*

       CLIENTUSERNAME=VIMAL OR A=A
       CLIENT_PASSWORD=123 OR B=B

       SELECT * FROM LOGIN_DETAIL WHERE USERNAME=VIMAL OR A=A AND PASSWORD=123 OR B=B





             LOGIN_DETAIL
             USERNAME
             PASSWORD

 */





public class OracleJdbcExample {
    public static void main(String[] args) throws Exception {

        // Activate the driver
        Class.forName("oracle.jdbc.driver.OracleDriver");

       // Connection
        Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "system",
                "1234");

        //

        // buffer for DML   ( STATEMENT (SELECT) , PREPARED STATEMENT (SQL INJECTION)  , RESULSET ( RETURN DATA FROM SELECT)
        PreparedStatement ps =
                con.prepareStatement("insert into hr.student  values(?,?,?,?)");

        ps.setInt(1, 8);
        ps.setString(2, "ROHAN");
        ps.setInt(3,49);
        ps.setInt(4,94);


        ps.executeUpdate();

        System.out.println("Inserted in Oracle");

        con.close();
    }
}