package controller;

import java.awt.print.Book;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Library;
import model.PurchaseCart;

@WebServlet(name = "controller", urlPatterns = {"/library/books", "/library/catalog"})
public class ServletLibraryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletLibraryController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = null, clear = null;
		Book book = null;
		Library library = (Library)getServletContext().getAttribute(LibraryContextListener.LibrarySystem);
		HttpSession session = request.getSession();
		
		PurchaseCart cart = (PurchaseCart)session.getAttribute("cart");
		if (cart == null) {
			cart = new PurchaseCart();
			session.setAttribute("cart", cart);
		}
		
		String selectedAction = request.getServletPath();
		
		String screen = selectedAction + ".jsp";
		
		try {
			request.getRequestDispatcher(screen).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}