package home;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionDB {
	private static Connection connection;
	static {
	try {
	Class.forName("com.mysql.jdbc.Driver");
	connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/stage","root","");
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	public static Connection getConnection() {
	return connection;
	}
}