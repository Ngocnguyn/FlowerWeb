package context;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBContext {
	public static Connection getConnect(){
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/qlbh";
		String user = "root";
		String pass = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,user,pass);
			return connection;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return connection;
	}
}
