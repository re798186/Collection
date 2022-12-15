package jdbc.preparedStatement;

import java.sql.*;
import java.util.Scanner;

import jdbc.jdbcUtil.JdbcUtil;

public class StudentsDao {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to CRUD operation on Student table.  ");
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
		System.out.println("1. Create Data ");
		System.out.println("2. Read Data");
		System.out.println("3. Update Data ");
		System.out.println("4. Delete Data ");
		System.out.println("Please enter an option from 1-4 ");
		int option = scanner.nextInt();
		switch (option) {
		case 1:
			InsertOperation.insertStudentData(conn);
			break;
		case 2:
			SelectOperation.getStudentData(conn);
			break;
		case 3:
			UpdateOperation.updateStudentData(conn);
			break;
		case 4:
			DeleteOperation.deleteStudentData(conn);
			break;
		default:
			System.out.println("Please enter a valid option from 1-4 ");
			performOperation(scanner, conn);
			break;
		}
	}

}
