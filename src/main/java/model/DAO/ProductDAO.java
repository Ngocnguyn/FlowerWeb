package model.DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.sql.*;

import context.DBContext;
import model.Bean.Admin;
import model.Bean.ProductModel;

public class ProductDAO {
	public static ArrayList<ProductModel> getProducts() {
		// mo cong ket noi csdl
		Connection conn = DBContext.getConnect();
		// Tao danh sach sp
		ArrayList<ProductModel> products = new ArrayList<>();
		
		// duyet tung phan tu cua bang product trong csdl
		try {
			ResultSet rs = conn.prepareStatement("select * from product order by id desc").executeQuery();
			while(rs.next()) {
				ProductModel product = new ProductModel();
				product.setId(rs.getInt("ID"));
				product.setImg(rs.getBytes("Img"));
				product.setName(rs.getString("Name"));
				product.setPrice(rs.getInt("Price"));
				product.setDiscount(rs.getInt("Discount"));
				
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return products;
	}
	
	public static boolean addProduct(ProductModel product) {
		
		Connection conn = DBContext.getConnect(); // Vao cong ket noi
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO product(Img, Name, Price, Discount) values(?,?,?,?)");
			ps.setBytes(1, product.getImg());
			ps.setString(2, product.getName());
			ps.setInt(3, product.getPrice());
			ps.setInt(4, product.getDiscount());
			System.out.println(product.getImg());
			boolean success = ps.executeUpdate() >0;
			return success;
 		} catch (Exception e) {
			// TODO: handle exception
 			e.printStackTrace();
 			
		}
		return false;
		
	}
	public static boolean editProduct(ProductModel product) {
		Connection conn = DBContext.getConnect(); // Vao cong ket noi
		try {
			PreparedStatement ps = conn.prepareStatement("update product set Img=?,Name=?,Price=?,Discount=? where ID=?");
			ps.setBytes(1, product.getImg());
			ps.setString(2, product.getName());
			ps.setInt(3, product.getPrice());
			ps.setInt(4, product.getDiscount());
			ps.setInt(5, product.getId());
			boolean success = ps.executeUpdate() >0;
			return success;
 		} catch (Exception e) {
			// TODO: handle exception
 			e.printStackTrace();
 			return false;
		}
	}
	public static boolean editProductnoImg(ProductModel product) {
		Connection conn = DBContext.getConnect(); // Vao cong ket noi
		try {
			PreparedStatement ps = conn.prepareStatement("update product set Name=?,Price=?,Discount=? where ID=?");
			ps.setString(1, product.getName());
			ps.setInt(2, product.getPrice());
			ps.setInt(3, product.getDiscount());
			ps.setInt(4, product.getId());
			boolean success = ps.executeUpdate() >0;
			return success;
 		} catch (Exception e) {
			// TODO: handle exception
 			e.printStackTrace();
 			return false;
		}
	}
	public static boolean deleteProduct(ProductModel product) {
		Connection conn = DBContext.getConnect(); // Vao cong ket noi
		try {
			String sql = "delete from product where ID="+product.getId();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			return true;
 		} catch (Exception e) {
			// TODO: handle exception
 			e.printStackTrace();
 			return false;
		}
	}
	public static ProductModel getProductbyID(int id) {
		Connection conn = DBContext.getConnect();
		ProductModel product = new ProductModel();
		try {
			String sql = "select * from product where ID="+id;
			ResultSet rs = conn.prepareStatement(sql).executeQuery();
			while(rs.next()) {
				product = new ProductModel(); 
				product.setId(rs.getInt("ID"));
				product.setImg(rs.getBytes("Img"));
				product.setName(rs.getString("Name"));
				product.setPrice(rs.getInt("Price"));
				product.setDiscount(rs.getInt("Discount"));
				
			}
			return product;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
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
}
