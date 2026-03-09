import java.sql.*;

public class StudentCRUD {



    public static void insert(Connection con, int id, String name,int maths,int science) throws Exception {
        PreparedStatement ps =
                con.prepareStatement("insert into public.student values(?,?,?,?)");

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3,maths);
        ps.setInt(4,science);

        ps.executeUpdate();
        System.out.println("Inserted");
    }

    public static void update(Connection con, int id, String name,int maths,int science) throws Exception {
        PreparedStatement ps =
                con.prepareStatement("update hr.student set name=?,maths=?,science=? where rollno=?");

        ps.setString(1, name);
        ps.setInt(2,maths);
        ps.setInt(3,science);
        ps.setInt(4, id);


        ps.executeUpdate();
        System.out.println("Updated");
    }

    public static void delete(Connection con, int id) throws Exception {
        PreparedStatement ps =
                con.prepareStatement("delete from hr.student where rollno=?");

        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Deleted");
    }

    public static void display(Connection con) throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from public.student ");

        while (rs.next()) {
            System.out.println("Roll No:"+rs.getInt(1) );
            System.out.println("Name: " + rs.getString(2));
            System.out.println("Maths :"+rs.getInt(3));
            System.out.println("Science:"+rs.getInt(4));

        }
        rs.close();
    }

    public static void displaybyRollno(Connection con,int rollno) throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from public.student where rollno='"+rollno+"'");

        while (rs.next()) {
            System.out.println("Roll No:"+rs.getInt(1) );
            System.out.println("Name: " + rs.getString(2));
            System.out.println("Maths :"+rs.getInt(3));
            System.out.println("Science:"+rs.getInt(4));

        }
    }

    public static void displayPassStudent(Connection con) throws Exception {
        Statement st = con.createStatement();
       // ResultSet rs = st.executeQuery("select * from public.student where maths>35 and science>35  ");
        ResultSet rs = st.executeQuery("select rollno,name,maths,science,maths+science,(maths+science)/2 as avg from public.student where maths>35 and science>35 group by city  order by avg desc , ");

        while (rs.next())
        {
            System.out.println("Roll No:"+rs.getInt(1) );
            System.out.println("Name: " + rs.getString(2));
            System.out.println("Maths :"+rs.getInt(3));
            System.out.println("Science:"+rs.getInt(4));
            System.out.println("Total :"+rs.getInt(5));
            System.out.println("Avg :"+rs.getInt(6));
            //System.out.println("total :"+rs.getInt(3)+rs.getInt(4));

        }
    }

}