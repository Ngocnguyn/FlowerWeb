package model.BO;

import model.DAO.*;

import java.util.ArrayList;

import model.Bean.*;

public class ProductBO {
	
	public static ArrayList<ProductModel> getProducts() {
		return ProductDAO.getProducts();
	}
	public static ArrayList<ProductModel> getProductsbyName(String name) {
		return ProductDAO.getProductsbyName(name);
	}
	public static boolean addProduct(ProductModel product) {
		// TODO Auto-generated method stub
		return ProductDAO.addProduct(product);
	}
	
	public static boolean editProduct(ProductModel product) {
		return ProductDAO.editProduct(product);
	}
	public static boolean editProductnoImg(ProductModel product) {
		return ProductDAO.editProductnoImg(product);
	}
	
	public static boolean deleteProduct(ProductModel product) {
		return ProductDAO.deleteProduct(product);
	}
	
	public static ProductModel getProductbyID(int id) {
		return ProductDAO.getProductbyID(id);
	}
}
