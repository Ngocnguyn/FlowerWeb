package model.Bean;

public class ProductModel {
	// cac thuoc tinh tuong duong trong csdl
	private int ID;
	private String Img;
	private String Name;
	private int Price;
	private int Discount;
	public ProductModel() {
		super();
	}
	public ProductModel(int id,String img, String name, int price, int discount) {
		super();
		ID = id;
		Img = img;
		Name = name;
		Price = price;
		Discount = discount;
	}
	public int getId() {
		return ID;
	}
	public void setId(int id) {
		this.ID = id;
	}
	public String getImg() {
		return Img;
	}
	public void setImg(String img) {
		Img = img;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getDiscount() {
		return Discount;
	}
	public void setDiscount(int discount) {
		Discount = discount;
	}
	
	
	
	
}
