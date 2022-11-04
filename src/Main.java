import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int choice;
        while (true)
        {
            System.out.println("select an option");
            System.out.println("1.insert");
            System.out.println("2.select");
            System.out.println("3.search");
            System.out.println("4.delete");
            System.out.println("5.update");
            System.out.println("6.Exit");
            Scanner scanner=new Scanner(System.in);
            choice=scanner.nextInt();
            switch (choice)
            {

                case 1:
                    System.out.println("insert student selected");
                    System.out.println("enter the name:");
                    String name = scanner.next();
                    System.out.println("enter the rollno:");
                    int rollno = scanner.nextInt();
                    System.out.println("enter the admno:");
                    int admno = scanner.nextInt();
                    System.out.println("enter the college name:");
                    String collegename = scanner.next();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "");
                        String sql = "INSERT INTO `students`(`name`, `rollNumber`, `adminNo`, `college`) VALUES (?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1, name);
                        stmt.setInt(2, rollno);
                        stmt.setInt(3, admno);
                        stmt.setString(4, collegename);
                        stmt.executeUpdate();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("select student selected");
                    break;
                case 3:
                    System.out.println("search student selected");
                    break;
                case 4:
                    System.out.println("delete student selected");
                    break;
                case 5:
                    System.out.println("update student selected");
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}