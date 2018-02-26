package iframe;

import hiber.Student;
import hiber.StudentDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="adminStudentIm",urlPatterns="/iframe/adminStudentIm")
public class adminStudentIm extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=ut-8");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.findById(id);
		//System.out.println(student);
		request.setAttribute("student",student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../iframe/xgStudent.jsp");
		dispatcher.forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
