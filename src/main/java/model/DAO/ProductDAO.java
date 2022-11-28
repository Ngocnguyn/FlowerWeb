package model.DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.*;

import context.DBContext;
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
				product.setImg(rs.getString("Img"));
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
			String sql = "INSERT INTO product(Img, Name, Price, Discount) "
					+ "VALUES ('"+product.getImg()+"','"+product.getName()+"','"+product.getPrice()+"','"+product.getDiscount()+"')";
			Statement stmt = conn.createStatement();
			System.out.print(sql);
			boolean success = stmt.executeUpdate(sql) >0;
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
			String sql = "update product set Img= '"+product.getImg()+"',Name='"+product.getName()+"'"
					+ ",Price='"+product.getPrice()+"',Discount='"+product.getDiscount()+"' where ID="+product.getId();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			return true;
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
				product.setImg(rs.getString("Img"));
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
	public static void main(String[] args) {
		System.out.println("Lay ra ");
	}
}
