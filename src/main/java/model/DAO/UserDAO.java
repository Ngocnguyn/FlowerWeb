package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import context.DBContext;
import model.Bean.Admin;
import model.Bean.ProductModel;
public class UserDAO {
	public static Admin getAdminByLogin(String username, String password) {
		Connection conn = DBContext.getConnect();
		
		String sql = "select * from admin where username = ? and password = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Admin admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3));
				return admin;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static boolean addUser(Admin admin) {
		Connection conn = DBContext.getConnect(); // Vao cong ket noi
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO admin(username,password) values(?,?)");
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			boolean success = ps.executeUpdate() >0;
			return success;
 		} catch (Exception e) {
			// TODO: handle exception
 			e.printStackTrace();
 			
		}
		return false;
	}
	
}
