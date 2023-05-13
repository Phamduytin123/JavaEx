package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
	private static Connector instance;
	public Connection conn;
	public Statement statement;
	public ResultSet result;
	
	public static Connector getInstance()
	{
		if(instance == null)
			instance = new Connector();
		return instance;
	}
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public ResultSet getResult() {
		return result;
	}

	public void setResult(ResultSet result) {
		this.result = result;
	}


	public Connector() 
	{
	}
	
	public void ConnectToDatabase() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl=
					"jdbc:sqlserver://localhost:1433;DatabaseName=GymCenter";
			conn= DriverManager.getConnection(connectionUrl);
			statement=conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			System.out.println("SQL Exception: "+ e.toString());
		} catch (ClassNotFoundException cE) {
			System.out.println("Class Not Found Exception: "+ cE.toString());
		}
	}
	
	public int ExcecuteNonQuery(String query)
	{
		int rowCount = 0;
		this.ConnectToDatabase();
		try {
			instance.result =instance.statement.executeQuery(query);
			while(instance.result.next()) {
				rowCount++;
			}
			instance.result.close();
			instance.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowCount;
	}

}
