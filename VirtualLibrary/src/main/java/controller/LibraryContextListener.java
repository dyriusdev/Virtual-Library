package controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.Library;


@WebListener
public class LibraryContextListener implements ServletContextListener {
	
	public static final String LibrarySystem = "Library System";
	
    public LibraryContextListener() {}

	public void contextDestroyed(ServletContextEvent event)  {
		ServletContext context = event.getServletContext();
		
		Library library = (Library)context.getAttribute(LibrarySystem);
		if (library != null) {
			// close database connection
		}
		
		context.removeAttribute(LibrarySystem);
	}

	public void contextInitialized(ServletContextEvent event)  {
		ServletContext context = event.getServletContext();
		
		try {
			Library library = new Library();
			context.setAttribute(LibrarySystem, library);
		} catch (Exception e) {
			System.out.println("Cant public library system in context " + e.getMessage());
		}
	}
}