package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.ProductBO;
import model.Bean.ProductModel;

/**
 * Servlet implementation class ProductEdit
 */
@WebServlet("/ProductEdit")
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
		String img = request.getParameter("product-img");
		String name = request.getParameter("product-name");
		int price = Integer.parseInt(request.getParameter("product-price"));
		int discount = Integer.parseInt(request.getParameter("product-discount"));
		ProductModel product = new ProductModel();
		product.setId(id);
		product.setImg(img);
		product.setName(name);
		product.setPrice(price);
		product.setDiscount(discount);
		PrintWriter pr = response.getWriter();
		pr.print(product.getId()+product.getImg()+product.getName()+product.getPrice()+product.getDiscount());
		if(ProductBO.editProduct(product))
		{	
			RequestDispatcher rd = request.getRequestDispatcher("/home");
			rd.forward(request, response);
		}
		else {
			PrintWriter pr2 = response.getWriter();
			pr2.print("Deo sua duoc vao duoc");
		}
	}

}