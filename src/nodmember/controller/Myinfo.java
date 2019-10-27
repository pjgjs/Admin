package nodmember.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nodmember.model.vo.Member;

/**
 * Servlet implementation class Myinfo
 */
@WebServlet("/myinfo")
public class Myinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		Member memberOne = (Member)session.getAttribute("member");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>나의 정보</title></head>");
		out.println("<body>");
		out.println("<h1> 회원정보 </h1>");
		out.println("<form action='/update' method='post'>");
		out.println("아이디 : <input type='text' name='userId' value='"+ memberOne.getUserId() + "'/><br>" );
		out.println("패스워드 : <input type='password' name='userPwd' value='"+ memberOne.getUserPwd() + "'/><br>" );
		out.println("이름 : <input type='text' name='userName' value='"+ memberOne.getName() + "'/><br>" );
		out.println("<input type='submit' value='수정하기'/>");
		out.println("<input type='reset' value='취소'/><br></form>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
