package jdbc.preparedStatement;

import java.sql.*;
import java.util.Scanner;

public class UpdateOperation {

	static void updateStudentData(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;

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
			String sqlDeleteQuery = "update student set `sname` =?, `sage` = ?, `saddr` = ?  where sname =?";
			pstmt = conn.prepareStatement(sqlDeleteQuery);
			pstmt.setString(1, sname);
			pstmt.setInt(2, sage);
			pstmt.setString(3, saddr);
			pstmt.setString(4, snameOld);
			int noOfRows = pstmt.executeUpdate();
			System.out.println("No of rows Affected is " + noOfRows);
		} catch (SQLException e) {
			e.printStackTrace();
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
