import java.sql.Connection;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {

        // choose DB
       // Connection con = DBConnection.getOracleConnection();
        Connection con = DBConnection.getPostgresConnection();

        Scanner scanner=new Scanner(System.in);

        int option1=0;
        do {
            System.out.println("\n\t\t\t Student Info");
            System.out.println("\t\t Press 1 for Entry");
            System.out.println("\t\t Press 2 for View");
            System.out.println("\t\t Press 3 for Search by Rollno");
            System.out.println("\t\t press 4 for display on Pass student");
            System.out.println("\t\t Press 5 for Exit ");

            System.out.println("Enter your option :");
            option1=scanner.nextInt();

            switch (option1)
            {
                case 1:
                    String option2="";
                      do {
                          System.out.println("Enter Student Roll No:");
                          int rollno=scanner.nextInt();
                          System.out.println("Enter Student Name:");
                          String name=scanner.next();
                          System.out.println("Enter Maths Marks:");
                          int maths=scanner.nextInt();
                          System.out.println("Enter Science Marks:");
                          int science=scanner.nextInt();

                          StudentCRUD.insert(con, rollno, name,maths,science);
                          System.out.println("Do you want to continue(y/n)?:");
                          option2= scanner.next();

                      }while(option2.equalsIgnoreCase("y"));
                      break;
                case 2:
                    System.out.println("\n\t\t View ");
                    StudentCRUD.display(con);
                 break;
                case 3:
                    System.out.println("\n\t\t Search ");
                    System.out.println("Enter Rollno");
                    int rollno=scanner.nextInt();
                    StudentCRUD.displaybyRollno(con,rollno);
                    break;
                case 4:
                    System.out.println("\n\t\t Pass Student ");
                    StudentCRUD.displayPassStudent(con);
                case 5:
                    System.out.println("you are exited");
                    break;
                default:
                    System.out.println("wrong option selected try again !!");
                    break;

            }



        }while(option1!=5);


//        StudentCRUD.update(con, 1, "Rahul");
//
//        StudentCRUD.delete(con, 1);

        con.close();
    }
}