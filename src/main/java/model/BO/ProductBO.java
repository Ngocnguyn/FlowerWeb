package model.BO;

import model.DAO.*;

import java.util.ArrayList;

import model.Bean.*;

public class ProductBO {
	
	public static ArrayList<ProductModel> getProducts() {
		return ProductDAO.getProducts();
	}
	public static boolean addProduct(ProductModel product) {
		
		// TODO Auto-generated method stub
		return ProductDAO.addProduct(product);
	}
	
	public static boolean editProduct(ProductModel product) {
		return ProductDAO.editProduct(product);
	}
	
	public static boolean deleteProduct(ProductModel product) {
		return ProductDAO.deleteProduct(product);
	}
	
	public static ProductModel getProductbyID(int id) {
		return ProductDAO.getProductbyID(id);
	}
	
	public static Admin getAdminByLogin(String username, String password) {
		return ProductDAO.getAdminByLogin(username, password);
	}
}
