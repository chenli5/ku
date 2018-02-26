package service;

import hiber.Item;
import hiber.ItemDAO;
import hiber.Items;
import hiber.ItemsDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;

import com.mysql.jdbc.Connection;

public class tgtServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;chaset=utf-8");
		request.setCharacterEncoding("utf-8");
		

			String itemID = request.getParameter("itemID");
			String itemName = request.getParameter("itemName");
			ItemDAO itemDAO = new ItemDAO();
			ItemsDAO itemsDAO = new ItemsDAO();
			
			for (int i = 1; i < 6; i++) {
				Item item = new Item();
				String t = request.getParameter("T"+String.valueOf(i));
				String a = request.getParameter("A"+String.valueOf(i));
				String b = request.getParameter("B"+String.valueOf(i));
				String c = request.getParameter("C"+String.valueOf(i));
				String d = request.getParameter("D"+String.valueOf(i));
				String anwer = request.getParameter("ANWER"+String.valueOf(i));
				System.out.println(t);
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
				System.out.println(d);
				System.out.println(anwer);
				System.out.println(Integer.valueOf(itemID));
				
				item.setEtitle(t);
				item.setEa(a);
				item.setEb(b);
				item.setEc(c);
				item.setEd(d);
				item.setAnwer(anwer);
				item.setTid(Integer.valueOf(itemID));
				System.out.println(item.toString());
				
				itemDAO.getSession().beginTransaction();
				itemDAO.getSession().save(item);
				itemDAO.getSession().getTransaction().commit();
				itemDAO.getSession().close();
				
			}
		
//		String itemID = request.getParameter("itemID");

//		
//		
//		ItemDAO itemDAO = new ItemDAO();
//		Query query = itemDAO.getSession()
//		.createQuery("INSERT INTO item"+
//				"(eTitle,eA,eB,eC,eD,anwer,TID) VALUES ("+"'"+t+"'"+","+"'"+a+"'"+","+"'"+b+"'"+","+"'"+c+"'"+","+"'"+d+"'"+","+"'"+anwer+"'"+","+Integer.valueOf(itemID)+")");
//		System.out.println("SQLÓï¾äÊä³ö£º"+"INSERT INTO `item`"+
//				"(eTitle,eA,eB,eC,eD,anwer,TID) VALUES ("+"'"+t+"'"+","+"'"+a+"'"+","+"'"+b+"'"+","+"'"+c+"'"+","+"'"+d+"'"+","+"'"+anwer+"'"+","+Integer.valueOf(itemID)+")");
//		query.executeUpdate();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			super.doGet(request, response);
			doGet(request, response);
	}

}
