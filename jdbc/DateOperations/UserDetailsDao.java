package jdbc.DateOperations;

import java.sql.*;
import java.util.Scanner;

import jdbc.jdbcUtil.JdbcUtil;

public class UserDetailsDao {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to  operation on UserDetails table ");
		try {
			conn = JdbcUtil.getJdbcConnection();
			performOperation(scanner, conn);
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
			if (conn != null)
				conn.close();
		}
	}

	private static void performOperation(Scanner scanner , Connection conn) throws SQLException {
		System.out.println("1. Insert Data ");
		System.out.println("2. Retrieve Data");
		System.out.println("Please enter an option ");
		int option = scanner.nextInt();
		switch (option) {
		case 1:
			InsertOperation.insertUserData(conn);
			break;
		case 2:
			SelectOperation.getUserData(conn);
			break;
		default:
			System.out.println("Please enter a valid option ");
			performOperation(scanner, conn);
			break;
		}
	}

}
