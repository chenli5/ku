package service;

import hiber.Teacher;
import hiber.TeacherDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class adminTeacherSerlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		TeacherDAO teacherDAO = new TeacherDAO();
		Teacher teacher = teacherDAO.findById(id);
		//System.out.println("id"+id);

			teacherDAO.getSession().beginTransaction();
			teacherDAO.getSession().delete(teacher);
			teacherDAO.getSession().getTransaction().commit();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
