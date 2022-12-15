package jdbc.jdbcUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

	private JdbcUtil() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getJdbcConnection() throws SQLException {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/jdbcproject";
		String uname = "root";
		String pw = "root@reethu22";
		conn = DriverManager.getConnection(url, uname, pw);
		return conn;

	}
}
