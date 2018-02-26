package iframe;

import hiber.Teacher;
import hiber.TeacherDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="adminTeacherIm",urlPatterns="/iframe/adminTeacherIm")
public class adminTeacherIm extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		//System.out.println("adm"+id);
		TeacherDAO teacherDAO = new TeacherDAO();
		Teacher teacher = teacherDAO.findById(id);
		//System.out.println(teacher);
		request.setAttribute("teacher", teacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../iframe/xgTeacher.jsp");
		dispatcher.forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
