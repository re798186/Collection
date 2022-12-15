package jdbc.preparedStatement;

import java.sql.*;
import java.util.Scanner;

public class InsertOperation {

	static void insertStudentData(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
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
			String sqlInsertQuery = "insert into student (`sname`,`sage`, `saddr`) values (?,?,?)";
			pstmt = conn.prepareStatement(sqlInsertQuery);
			pstmt.setString(1, sname);
			pstmt.setInt(2, sage);
			pstmt.setString(3, saddr);
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
