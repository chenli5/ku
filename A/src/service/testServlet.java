package service;

import hiber.Item;
import hiber.ItemDAO;
import hiber.Scoretb;
import hiber.ScoretbDAO;
import hiber.Student;
import hiber.StudentDAO;

import java.util.List;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.NEW;

import common.Fenye;

@WebServlet(name="testServlet",urlPatterns="/service/testServlet")
public class testServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			super.doGet(request, response);
			doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			int j = 0;
			try{
				HttpSession session = request.getSession();
				
				int currentPage = 1;
				if (request.getParameter("currentPage") != null) {
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				
				ItemDAO dao = new ItemDAO();
				Item item = new Item();
				List<Item> list = dao.findAll();
				if (request.getParameter("list")!=null) {
					list = (List<Item>)request.getAttribute("list");
				}
				Fenye<Item> fenye = new Fenye<Item>();
				fenye.setRecPer(30);
				fenye.setCurrentPages(currentPage);
				fenye.init(list, currentPage);
				int totalPages = fenye.getTotalPages();
				List<Item> subList = fenye.getSubList();
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("list", subList);
				
				//request.setAttribute("list", list);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/test1.jsp");
				dispatcher.forward(request, response);

				
				for(int i = 1; i < 26; i++){
					
					String result = request.getParameter("subjectAnswer"+i);
					//System.out.println("题号"+i+":"+result);
					
					if(result.equals(dao.findById(i).getAnwer())){
							j+=4;
							//System.out.println("对");
						}
					}
				//System.out.println("得分"+j);

				}catch(Exception e){
					
				}
				try{
				String stuID = request.getParameter("stuID");
				//System.out.println("id是"+stuID);
				StudentDAO studentDAO = new StudentDAO();
				Student student = studentDAO.findById(stuID);
				student.setSscore(String.valueOf(j));
				studentDAO.getSession().beginTransaction();
				studentDAO.getSession().update(student);
				studentDAO.getSession().getTransaction().commit();
				
				}catch(Exception e){
					System.err.println(e);
				}
				
	} 
				
}
