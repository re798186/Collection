package jdbc.statement;

import java.sql.*;
import java.util.Scanner;

 
public class DeleteOperation {

	public static void deleteStudentData(Connection conn) throws SQLException {
		Statement stmt = null;
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.println("Please enter the student name to delete ");
			String sname = scanner.next();
			String sqlDeleteQuery = "delete from student where sname = '" + sname + "'";
			stmt = conn.createStatement();
			int noOfRows = stmt.executeUpdate(sqlDeleteQuery);
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
