package com.BookStoreApplication.net;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/books/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private BookDao bookDAO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        bookDAO = new  BookDao();
        bookDAO.connect();
        bookDAO.disconnect();
        
      
        
     
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.setAttribute("book_list", bookList);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/BookList.jsp");
//		dispatcher.forward(request, response);
		
		String action = request.getPathInfo();
		if(action.equals("/new")) {
			addBook(request,response);
		}
		else {
			listBooks(request, response);
		}
	 }

	private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Book> books = bookDAO.listAllBooks();
		
		request.setAttribute("book_list", books);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/BookList.jsp");
		dispatcher.forward(request, response);
		
	}

	private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	RequestDispatcher dispatcher = request.getRequestDispatcher("/BookForm.jsp");
	dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getPathInfo();
		if(action.equals("/insert")) {
			insertBook(request,response);
		}
	
	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("booktitle");
		String author = request.getParameter("bookauthor");	
		String price = request.getParameter("bookprice");
		
		Book newBook = new Book(title, author, Float.parseFloat(price));
		bookDAO.insertBook(newBook);
		
		response.sendRedirect("list");
	}

}
