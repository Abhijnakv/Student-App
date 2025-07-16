package in.pentagon.studentapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class Login extends HttpServlet {
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	  StudentDAO sdao=new StudentDAOImpl();
	  HttpSession session=req.getSession(true);
	  //PrintWriter out =resp.getWriter();
	  Student s=sdao.getStudent(req.getParameter("mail"),req.getParameter("password")); 
	  if(s!=null) {
			  session.setAttribute("student",s);
			  req.setAttribute("success", "logged in successfully!");
			  RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
			  rd.forward(req, resp);
		  }
		  else 
		  {
			  req.setAttribute("error", "failed to login!");
			  RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			  rd.forward(req, resp);

		  } 
       }
	}