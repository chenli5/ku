package iframe;

import hiber.Student;
import hiber.StudentDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addStudent extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String stuID = request.getParameter("stuID");
		String stuName = request.getParameter("stuName");
		String pw = request.getParameter("pw");
		String sClass = request.getParameter("sClass");
		
		StudentDAO stuDao = new StudentDAO();
		Student student = new Student();
		
		student.setSid(stuID);
		student.setSname(stuName);
		student.setSclass(sClass);
		student.setSpw(pw);
		
		stuDao.getSession().beginTransaction();
		stuDao.getSession().save(student);
		stuDao.getSession().getTransaction().commit();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
