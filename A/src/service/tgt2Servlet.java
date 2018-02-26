package service;

import hiber.Item;
import hiber.ItemDAO;
import hiber.ItemsDAO;
import hiber.Sitem;
import hiber.SitemDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class tgt2Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		SitemDAO sitemDAO = new SitemDAO();
		
		for (int i = 1; i < 6; i++) {
			Sitem sitem = new Sitem();
			String t = request.getParameter("T"+String.valueOf(i));
			String a = request.getParameter("A"+String.valueOf(i));
			String b = request.getParameter("B"+String.valueOf(i));
			String c = request.getParameter("C"+String.valueOf(i));
			String d = request.getParameter("D"+String.valueOf(i));
			String anwer = request.getParameter("ANWER"+String.valueOf(i));
//			System.out.println(t);
//			System.out.println(a);
//			System.out.println(b);
//			System.out.println(c);
//			System.out.println(d);
//			System.out.println(anwer);
			
			sitem.setSeTitle(t);
			sitem.setSeA(a);
			sitem.setSeB(b);
			sitem.setSeC(c);
			sitem.setSeD(d);
			sitem.setSeAnwer(anwer);
			//System.out.println(sitem.toString());
			
			sitemDAO.getSession().beginTransaction();
			sitemDAO.getSession().save(sitem);
			sitemDAO.getSession().getTransaction().commit();
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			super.doGet(request, response);
			doGet(request, response);
	}

}
