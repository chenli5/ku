package service;
import hiber.Sitem;
import hiber.SitemDAO;



import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class stestServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			super.doGet(request, response);
			doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
//			int j = 0;
			try{
				HttpSession session = request.getSession();
				
				SitemDAO dao = new SitemDAO();
				Sitem sitem = new Sitem();
				List<Sitem> list1 = dao.findAll();
				if (request.getParameter("list1")!=null) {
					list1 = (List<Sitem>)request.getAttribute("list1");
				}
				System.out.println(list1);
				request.setAttribute("list1", list1);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/test1.jsp");
				dispatcher.forward(request, response);
//
//				
//				for(int i = 1; i < 26; i++){
//					
//					String result = request.getParameter("subjectAnswer"+i);
//					System.out.println("题号"+i+":"+result);
//					
//					if(result.equals(dao.fin.getAnwer())){
//							j+=4;
//							System.out.println("对");
//						}
//					}
//				System.out.println("得分"+j);
//
//				}catch(Exception e){
//					
//				}
//				try{
//				String stuID = request.getParameter("stuID");
//				System.out.println("id是"+stuID);
//				ScoretbDAO scoretbDAO = new ScoretbDAO();
//				Scoretb scoretb = scoretbDAO.findById(Integer.valueOf(stuID));
//				scoretb.setScore(String.valueOf(j));

			
				}catch(Exception e){
					System.err.println(e);
				}
				
	} 
				
}
