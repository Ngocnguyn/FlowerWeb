package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.ProductBO;
import model.Bean.ProductModel;

/**
 * Servlet implementation class SearchHome
 */
@WebServlet("/searchhome")
public class SearchHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductBO productBO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchHome() {
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
		String name = request.getParameter("name-search");
		ArrayList<ProductModel> products = productBO.getProductsbyName(name);
		request.setAttribute("products", products);
		request.getRequestDispatcher("/View/Home.jsp").forward(request, response);
	}

}
