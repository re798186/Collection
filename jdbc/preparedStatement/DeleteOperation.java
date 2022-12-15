 package jdbc.preparedStatement;

import java.sql.*;
import java.util.Scanner;

 
public class DeleteOperation {

	public static void deleteStudentData(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.println("Please enter the student name to delete ");
			String sname = scanner.next();
			String sqlDeleteQuery = "delete from student where sname =?";
			pstmt = conn.prepareStatement(sqlDeleteQuery);
			pstmt.setString(1, sname);
			int noOfRows = pstmt.executeUpdate();
			System.out.println("No of rows Affected is " + noOfRows);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (scanner != null)
				scanner.close();
		}

	}

}
