package DAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() throws SQLException
	{
		Connection connection = null;
		// Tin
//		String connectionURL = "jdbc:sqlserver://MSI\\SQLEXPRESS:1433;encrypt=true;databaseName=GymCenter;integratedSecurity=true;trustServerCertificate=true;";
//		String user = "MSI\\ADMIN";
		
		// Khoi
		
		
		// Cong
		
		String password = "";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(connectionURL,user,password);
			} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage()+ "\n" + e.getClass() + "\n" + e.getCause());
		}
		return connection;
	}
	
	public static void closeConnection(Connection c)
	{
		try {
			if(c != null)
				c.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
