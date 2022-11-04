import java.sql.*;
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
                    System.out.println("view student selected");
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "");
                        String sql = "SELECT `name`, `rollNumber`, `adminNo`, `college` FROM `students`";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            String getName = rs.getString("name");
                            String getRoll = rs.getString("rollNumber");
                            String getAdm = rs.getString("adminNo");
                            String getCollege = rs.getString("college");
                            System.out.println("name="+getName);
                            System.out.println("rollno="+getRoll);
                            System.out.println("admno="+getAdm);
                            System.out.println("college="+getCollege+"\n");
                        }

                    }

                    catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.println("Search student");
                    System.out.println("Enter the admission number : ");
                    admno=scanner.nextInt();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
                        String sql = "SELECT `name`, `rollNumber`, `adminNo`, `college` FROM `students` WHERE `adminNo`="+String.valueOf(admno);
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){

                            String getName = rs.getString("name");
                            String getRollno = rs.getString("rollNumber");
                            String getAdmno = rs.getString("adminNo");
                            String getCollege = rs.getString("college");
                            System.out.println("Name="+getName);
                            System.out.println("Rollno="+getRollno);
                            System.out.println("Admno="+getAdmno);
                            System.out.println("college="+getCollege+"\n");
                        }
                    }
                    catch (Exception e ){
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("delete student selected");
                    System.out.println("enter addmission number:");
                    String adm=scanner.next();
                    try{
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
                        String sql="DELETE FROM `students` WHERE `adminNo`="+adm;
                        Statement stmt=con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("data deleted sucessfully");
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
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