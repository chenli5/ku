package welcome;

import hiber.Admin;
import hiber.AdminDAO;
import hiber.Student;
import hiber.StudentDAO;
import hiber.Teacher;
import hiber.TeacherDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class welcomeS extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		StudentDAO studentDAO = new StudentDAO();
		TeacherDAO teacherDAO = new TeacherDAO();
		AdminDAO adminDAO = new AdminDAO();
		List<Student> stuList = studentDAO.findAll();
		List<Teacher> teaList = teacherDAO.findAll();
		List<Admin> adList = adminDAO.findAll();
		request.setAttribute("stulist", stuList);
		request.setAttribute("tealist", teaList);
		request.setAttribute("adlist", adList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("../service/login.jsp");	
		dispatcher.forward(request, response);
		System.out.println(111);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
