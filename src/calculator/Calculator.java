package calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
//@WebServlet("/cal")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		//1. 전송값에 한글이 있을 경우 처리할 수 있도록 인코딩
		request.setCharacterEncoding("utf-8");
		
		//2. 웹에서 보내준 데이터를 꺼내서 변수에 저장
		int firstValue = Integer.parseInt(request.getParameter("firstValue"));
		
		int secondValue = Integer.parseInt(request.getParameter("secondValue"));
		
		char oper = request.getParameter("cal").charAt(0);
	
		//3. 처리 결과 내보내기
		PrintWriter out = response.getWriter();
		out.println("<html><head><title> result </title></head>");
		out.println("<body>");
		
		switch(oper) {
		case '+' : out.println(firstValue + "+" + secondValue + "=" + (firstValue+secondValue));
		break;
		case '-' : out.println(firstValue + "-" + secondValue + "=" + (firstValue - secondValue));
		break;
		case '*' : out.println(firstValue + "*" + secondValue + "=" + (firstValue * secondValue));
		break;
		case '/' : out.println(firstValue + "/" + (double)secondValue + "=" + (firstValue / secondValue));
		break;
		}
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
