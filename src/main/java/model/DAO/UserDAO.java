package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import context.DBContext;
import model.Bean.ProductModel;
import model.Bean.UserModel;
public class UserDAO {
	public UserModel findbyUsername(String username) {
		Connection conn = DBContext.getConnect();
		UserModel user = new UserModel();
		try {
			String sql = "select * from user where Username="+username;
			ResultSet rs = conn.prepareStatement(sql).executeQuery();
			while(rs.next()) {
				user = new UserModel(); 
				user.setID(rs.getInt("ID"));
				user.setName(rs.getString("Name"));
				user.setUsername(rs.getString("Username"));
				user.setPassword(rs.getString("Password"));
				
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
