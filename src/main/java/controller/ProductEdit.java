package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.*;
import java.util.Base64;

import javax.accessibility.AccessibleAttributeSequence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.BO.ProductBO;
import model.Bean.ProductModel;

/**
 * Servlet implementation class ProductEdit
 */
@WebServlet("/ProductEdit")
@MultipartConfig
public class ProductEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		int id = Integer.parseInt(request.getParameter("product-id"));
		
		Part filePart= request.getPart("product-img");
	    String fileName = filePart.getSubmittedFileName();
		
	    ProductModel product = new ProductModel();
		String name = request.getParameter("product-name");
		int price = Integer.parseInt(request.getParameter("product-price"));
		int discount = Integer.parseInt(request.getParameter("product-discount"));
		
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		product.setDiscount(discount);
	    
	    if(fileName.trim().equals("")) { //k upload
	    	if(ProductBO.editProductnoImg(product))
			{	
				RequestDispatcher rd = request.getRequestDispatcher("/HomeAdmin");
				rd.forward(request, response);
			}
			else {
				PrintWriter pr2 = response.getWriter();
				pr2.print("Loi sua");
			}
	    } 
	    else { //co upload
	    	InputStream inputStream = filePart.getInputStream();
	    	byte[] img =  new byte[inputStream.available()];
	    	inputStream.read(img);
	    	product.setImg(img);
	    	
	    	//goi ham edit (co anh)
	    	if(ProductBO.editProduct(product))
			{	
				RequestDispatcher rd = request.getRequestDispatcher("/HomeAdmin");
				rd.forward(request, response);
			}
			else {
				PrintWriter pr2 = response.getWriter();
				pr2.print("Loi sua");
			}
	    }
	}
}
