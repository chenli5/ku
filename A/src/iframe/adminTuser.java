package iframe;

import hiber.Teacher;
import hiber.TeacherDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class adminTuser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String tid = request.getParameter("tid");
		String tname = request.getParameter("tname");
//		System.out.println("id"+tid);
//		System.out.println("name"+tname);
		TeacherDAO teacherDAO = new TeacherDAO();
		Teacher teacher = teacherDAO.findById(tid);

		teacher.setTname(tname);
		teacherDAO.getSession().beginTransaction();
		teacherDAO.getSession().update(teacher);
		teacherDAO.getSession().getTransaction().commit();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
