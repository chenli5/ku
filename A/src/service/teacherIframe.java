package service;

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

import common.Fenye;

public class teacherIframe extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		TeacherDAO teacherDAO = new TeacherDAO();
		List<Teacher> tealist = teacherDAO.findAll();

		//Ñ§Éú·ÖÒ³
		if (request.getParameter("list")!=null) {
			tealist = (List<Teacher>)request.getAttribute("list");
		}
		int currentPage = 1;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		Fenye<Teacher> fenye = new Fenye<Teacher>();				
		fenye.setRecPer(5);
		fenye.setCurrentPages(currentPage);
		fenye.init(tealist, currentPage);
		int totalPages = fenye.getTotalPages();
		List<Teacher> subList = fenye.getSubList();
//		for (Teacher student : subList) {
//			System.out.println(student.getTid());
//		}
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("list", subList);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("../jsp/teacherIframe.jsp");
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}


}
