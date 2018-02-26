package service;

import hiber.Scoretb;
import hiber.ScoretbDAO;
import hiber.Student;
import hiber.StudentDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="TMserviet",urlPatterns="/service/tManageStudentServlet")
public class tManageStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
	try {

		StudentDAO stuDao = new StudentDAO();
		List<Student> list = stuDao.findAll();
		System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
				String stuID = request.getParameter("stuID"+String.valueOf(i));
				String stScore = request.getParameter("cj"+String.valueOf(i));
				String name = request.getParameter("name"+String.valueOf(i));
//				System.out.println("id是"+stuID);
//				System.out.println("成绩是"+stScore);
//				System.out.println("名字是"+name);
				Student student = stuDao.findById(stuID);
				//student.setSname("111");
				student.setSscore(stScore);
				stuDao.getSession().beginTransaction();
				stuDao.getSession().update(student);
				stuDao.getSession().getTransaction().commit();
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			super.doGet(request, response);
			doGet(request, response);
	}

}
