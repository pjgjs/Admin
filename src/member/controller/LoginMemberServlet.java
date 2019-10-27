package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginMemberServlet
 */
@WebServlet("/loginMember")
public class LoginMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		Member memberOne = new MemberService().selectMember(userId,userPwd);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if (memberOne != null) {
			HttpSession session = request.getSession();
			System.out.println("발급된 세션 값: "+session.getId());
			
			session.setAttribute("member", memberOne);
			
			out.println("<html><head><title>로그인성공</title></head>");
			out.println("<body>");
			out.println("<h1>로그인에 성공하였습니다.</h1>");
			out.println("<h1>" + memberOne.getName()+"님 환영합니다"+"</h1>");
			out.println("<a href = 'myinfo'>마이페이지</a>");
			out.println("<a href = 'logout'>로그아웃</a>");
			out.println("</body>");
			out.println("</html>");
		}else {
			out.println("<html><head><title>로그인실패</title></head>");
			out.println("<body>");
			out.println("<h1>로그인에 실패하였습니다.</h1>");
			out.println("<h1>아이디 혹은 패스워드를 확인해주세요.</h1>");
			out.println("<a href = 'index.html'>기본 페이지로 이동</a>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
