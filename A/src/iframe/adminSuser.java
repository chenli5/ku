package iframe;

import hiber.Student;
import hiber.StudentDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="adminSuser",urlPatterns="/iframe/adminSuser")
public class adminSuser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("sid");
		String name = request.getParameter("sname");
		String score = request.getParameter("score");
		//System.out.println(id);
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.findById(id);
		
		student.setSname(name);
		student.setSscore(score);
		studentDAO.getSession().beginTransaction();
		studentDAO.getSession().update(student);
		studentDAO.getSession().getTransaction().commit();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
