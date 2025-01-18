package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DemoApp
 */
public class DemoApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoApp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    int count=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		HttpSession hs = request.getSession();
		pw.println("<font color=red size=5>");
		if(hs.isNew()) {
			pw.println("<br/> New Client");
		}else {
			pw.println("<br/> Old Client");
		}
		pw.println("<br/> Count value is "+count);
		pw.println("<br/> Session Id is "+hs.getId());
		pw.println("<br/> Session Creation "+new Date(hs.getCreationTime()));
		pw.println("<br> Last Access time "+new Date(hs.getLastAccessedTime()));
		pw.println("<br/> Default session time "+hs.getMaxInactiveInterval()); //1800
		hs.setMaxInactiveInterval(600);
		pw.println("<br/> After change session time "+hs.getMaxInactiveInterval());
		if(count%5==0) {
			hs.invalidate();// it help to destroy the session explicitly. 
		}
		count++;
		pw.println("</font>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
