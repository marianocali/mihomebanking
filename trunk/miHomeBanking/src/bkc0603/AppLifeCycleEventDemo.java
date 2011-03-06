package bkc0603;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

public class AppLifeCycleEventDemo implements ServletContextListener 
{

  public void contextInitialized(ServletContextEvent sce) 
  {
    System.out.println("Initializing Application …");
  

    // Get the ServletContext object
    ServletContext servletContext = sce.getServletContext();

    // Set a ServletContext attribute
    servletContext.setAttribute("dbUrl", "jdbc:oracle:thin");
    System.out.println("Application initialized");
  }

  public void contextDestroyed(ServletContextEvent sce) 
  {
    System.out.println("Application shut down");
  }
}
