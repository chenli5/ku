package service;

import hiber.Admin;
import hiber.AdminDAO;
import hiber.Item;
import hiber.ItemDAO;
import hiber.Scoretb;
import hiber.ScoretbDAO;
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
import javax.servlet.http.HttpSession;

import common.Fenye;

public class loginService extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		StudentDAO studentDAO = new StudentDAO();
		AdminDAO adminDAO = new AdminDAO();
		TeacherDAO teacherDAO = new TeacherDAO();
		ItemDAO itemDAO = new ItemDAO();
		ScoretbDAO scoretbDAO = new ScoretbDAO();

		String userId = request.getParameter("userId");
		String userPW = request.getParameter("userPW");
		String power = request.getParameter("power");

		
		
		
		// Item item = itemDAO.findById(userId);
		

		HttpSession session = request.getSession();

		String msg = "";
		try {

			if (power.equals("1")) {
				studentDAO.findById(userId);
				Scoretb scoretb = scoretbDAO.findById(Integer.valueOf(userId));
				Student student = studentDAO.findById(userId);
				if (userPW.equals(student.getSpw())) {
					session.setAttribute("userId", userId);
					session.setAttribute("scoretb", scoretb);
					session.setAttribute("student", student);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/jsp/student.jsp");
					dispatcher.forward(request, response);

				} 
			}
			if (power.equals("2")) {
				Teacher teacher = teacherDAO.findById(userId);
				if (userPW.equals(teacher.getTpw())) {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/jsp/techer.jsp");
					dispatcher.forward(request, response);
				}
			}
			if (power.equals("3")) {
				//System.out.println(1222);
				Admin admin = adminDAO.findById(userId);

				
//				request.setAttribute("stulist", stulist);
//				request.setAttribute("tealist", tealist);
				if (userPW.equals(admin.getApass())) {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/jsp/admin.jsp");
					//System.out.println("22");
					dispatcher.forward(request, response);
				}
			}

		} catch (Exception e) {
			msg = "该用户不存在";
			request.setAttribute("msg", msg);
			//System.out.println("yhm "+111);
			out.print("<script>alert('密码或者用户名错误');return false;</script>");
			System.out.println(msg);
		} finally {
			studentDAO.getSession().close();
			teacherDAO.getSession().close();
			adminDAO.getSession().close();
		}

	}

}
