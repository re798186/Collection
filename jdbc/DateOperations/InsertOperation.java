package jdbc.DateOperations;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InsertOperation {

	static void insertUserData(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		Scanner scanner = null;
		String dobFormat = "dd-MM-yyyy";
		String dojFormat = "MM-dd-yyyy";
		String domFormat = "yyyy-MM-dd";
		try {
			scanner = new Scanner(System.in);
			System.out.println("Please enter the user details");
			System.out.print("User name :");
			String sname = scanner.next();
			System.out.print("User address :");
			String saddr = scanner.next();
			System.out.print("User gender :");
			String sgender = scanner.next();
			System.out.print("User DOB ("+dobFormat+"):");
			String sdob = scanner.next();
			java.sql.Date dob = getSqlDate(dobFormat,sdob);
			System.out.print("User DOJ ("+dojFormat+") :");
			String sdoj = scanner.next();
			java.sql.Date doj = getSqlDate(dojFormat,sdoj);
			System.out.print("User DOM ("+domFormat+"):");
			String sdom = scanner.next();
			java.sql.Date dom = getSqlDate(domFormat,sdom);
			String sqlInsertQuery = "insert into userdetails(`name`,`address`,`gender`,`DOB`,`DOJ`,`DOM`) values (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sqlInsertQuery);
			pstmt.setString(1, sname);
			pstmt.setString(2, saddr);
			pstmt.setString(3, sgender);
			pstmt.setDate(4, dob);
			pstmt.setDate(5, doj);
			pstmt.setDate(6, dom);
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

	private static Date getSqlDate(String format, String sdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		java.util.Date uDate = sdf.parse(sdate);
		java.sql.Date date = new java.sql.Date(uDate.getTime());
		return date;
	}

}
