package jdbc.statement;

import java.sql.*;
import java.util.Scanner;

public class InsertOperation {

	static void insertStudentData(Connection conn) throws SQLException {
		Statement stmt = null;
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.println("Please enter the student details");
			System.out.print("Strudent name :");
			String sname = scanner.next();
			System.out.print("Student age :");
			int sage = scanner.nextInt();
			System.out.print("Student address :");
			String saddr = scanner.next();
			String sqlInsertQuery = "insert into student (`sname`,`sage`, `saddr`) values ('" + sname + "', " + sage
					+ " ,'" + saddr + "')";
			stmt = conn.createStatement();
			int noOfRows = stmt.executeUpdate(sqlInsertQuery);
			System.out.println("No of rows Affected is " + noOfRows);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null)
				stmt.close();
			if (scanner != null)
				scanner.close();
		}

	}

}
