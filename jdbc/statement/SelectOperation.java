package jdbc.statement;

import java.sql.*;

public class SelectOperation {

	public static void getStudentData(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet resultSet = null;

		String sqlSelectQuery = "select sid,sname,sage,saddr from student ";
		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sqlSelectQuery);
			if (resultSet != null) {
				System.out.println("SID\tSNAME\tSAGE\tSADDR");
				while (resultSet.next())
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4));
			} else {
				System.out.println("No Data Available");

			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null)
				resultSet.close();
			if (stmt != null)
				stmt.close();
			
		}

	}

}
