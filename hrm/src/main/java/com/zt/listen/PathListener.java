package com.zt.listen;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class PathListener
 *
 */
@WebListener
public class PathListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public PathListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	ServletContext servletContext = sce.getServletContext();
    	String contextPath = servletContext.getContextPath();
    	servletContext.setAttribute("PATH", contextPath);
    }
    
	
}
