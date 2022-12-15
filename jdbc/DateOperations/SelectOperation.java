package jdbc.DateOperations;

import java.sql.*;
import java.text.SimpleDateFormat;

public class SelectOperation {

	public static void getUserData(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		String sqlSelectQuery = "select * from userdetails ";
		try {
			pstmt = conn.prepareStatement(sqlSelectQuery);
			resultSet = pstmt.executeQuery();
			if (resultSet != null) {
				System.out.println("ID\tNAME\tADDR\tGENDER\tDOB\tDOJ\tDOM");
				while (resultSet.next()) {
					int id = resultSet.getInt(1);
					String name = resultSet.getString(2);
					String address = resultSet.getString(3);
					String gender = resultSet.getString(4);
					Date dob = resultSet.getDate(5);
					Date doj = resultSet.getDate(6);
					Date dom = resultSet.getDate(7);
					SimpleDateFormat sdf = null;
					String sdob = null, sdoj = null, sdom = null;
					if (dob != null) {
						sdf = new SimpleDateFormat("dd-MM-yyyy");
						sdob = sdf.format(dob);
					}
					if (doj != null) {
						sdf = new SimpleDateFormat("MM-dd-yyyy");
						sdoj = sdf.format(doj);
					}
					if (dom != null) {
						sdf = new SimpleDateFormat("yyyy-MM-dd");
						sdom = sdf.format(dom);
				}
					System.out.println(id + "\t" + name + "\t" + address + "\t" + gender + "\t" + sdob + "\t" + sdoj
							+ "\t" + sdom);
				}
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
			if (pstmt != null)
				pstmt.close();

		}

	}

}
