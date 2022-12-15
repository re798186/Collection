package jdbc.statement;

import java.sql.*;
import java.util.Scanner;

public class UpdateOperation {

	static void updateStudentData(Connection conn) throws SQLException {
		Statement stmt = null;
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
		System.out.println("Please enter the student name to update ");
		String snameOld = scanner.next();
		System.out.println("Please enter the student details");
		System.out.print("Strudent name :");
		String sname = scanner.next();
		System.out.print("Student age :");
		int sage = scanner.nextInt();
		System.out.print("Student address :");
		String saddr = scanner.next();
		String sqlDeleteQuery = "update student set `sname` = '"+sname+"', `sage` = "+sage+", `saddr` = '"+saddr+"' where sname = '"+snameOld+"'";
			stmt = conn.createStatement();
			int noOfRows = stmt.executeUpdate(sqlDeleteQuery);
			System.out.println("No of rows Affected is " + noOfRows);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			if (stmt != null)
				stmt.close();
			if (scanner != null)
				scanner.close();
		}

	}
}
