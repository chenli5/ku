package service;

import hiber.Scoretb;
import hiber.ScoretbDAO;
import hiber.Student;
import hiber.StudentDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class techerServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String work = request.getParameter("work");
		System.out.println("ֵ"+work);
		if (work.equals("1")){
			StudentDAO studentDAO = new StudentDAO();
			Student student = new Student();
			List<Student> list = studentDAO.findAll();
			request.setAttribute("list",list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/tgs.jsp");
			dispatcher.forward(request, response);
		}
		if (work.equals("2")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/tgt.jsp");
			dispatcher.forward(request, response);
		}
		if (work.equals("3")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/tgt2.jsp");
			dispatcher.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			super.doGet(request, response);
			doGet(request, response);
	}

}
