package com.maven.junittesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CrudeOpInSql {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/sys";
		Connection con = DriverManager.getConnection(url, "root", "root");
		System.out.println("Database Connected Successfully");
		Statement stmt = con.createStatement();
		int rollno;
		String name, address;
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println(" 1 - Add details");
			System.out.println(" 2 - displaying of Students details");
			System.out.println(" 3 - Update of Students details");
			System.out.println(" 4 - Delete of Students details");
			System.out.println(" 5 - Count of records");
			System.out.println(" 6 - display records in acsending order");
			System.out.println(" 7 - exit");
			System.out.println("Enter the choice :");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter student rollno:");
				rollno = s.nextInt();
				System.out.println("Enter student name:");
				name = s.next();
				System.out.println("Enter student address:");
				address = s.next();
				stmt.executeUpdate(
						"INSERT INTO students values( " + rollno + ", " + "'" + name + "', '" + address + "')");
				break;
			}
			case 2: {
				System.out.println("Enter the student number :");
				rollno = s.nextInt();
				ResultSet rs = stmt.executeQuery("select * from students where rollno =" + rollno);

				System.out.println("Get students records:");
				if(rs.next()) {
					System.out.println("rollno:" + rs.getInt(1));
					System.out.println("s Name:" + rs.getString(2));
					System.out.println("s address:" + rs.getString(3));
				}
				else {
					System.err.println("Record no exists");
				}
				break;
			}
			case 3: {
				System.out.println("Enter the student number :");
				rollno = s.nextInt();

				System.out.println("Enter the student name :");
				name = s.next();
				System.out.println("Enter the student address :");
				address = s.next();

				stmt.executeUpdate("update students set name= " + "'" + name + "', address= '" + address
						+ "' where rollno=" + rollno);
				System.out.println("update insert.....");

				break;
			}
			case 4: {
				System.out.println("Enter the s number :");
				rollno = s.nextInt();
//				stmt.executeUpdate("delete from students where rollno =" + rollno);
				int deletecount=stmt.executeUpdate("delete from students where rollno =" + rollno);;
                if(deletecount>0)
                {
                    System.err.println("Data deleted successfully");
                }
                else
                {
                    System.err.println("No Data found with that id ");
                }
//				System.out.println("Record deleted successfully");

				break;
			}
			case 5: {
				ResultSet rs = stmt.executeQuery("select count(*) students");
				System.out.println("Count of records");
				rs.next();
				int count = rs.getInt(1);
				System.out.println(count);
				break;
			}
			case 6: {
				ResultSet rs = stmt.executeQuery("select * from students order by name");
				System.out.println("order by name");
				while(rs.next()) {
					System.out.println("rollno:"+rs.getInt(1));
					System.out.println("name:"+rs.getString(2));
					System.out.println("address:"+rs.getString(3));
				}
				break;
			}
			case 7: {
				System.exit(0);
				;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);

			}
		}
	}
}