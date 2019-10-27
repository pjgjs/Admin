package calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bugger
 */
//@WebServlet("/bugger")
public class Bugger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bugger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//1.
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//2.
		String bugger = request.getParameter("bbugger");
		String side = request.getParameter("side");
		String bervarage = request.getParameter("bervarage");
		 
		int price = 0;
		
		switch(bugger) {
		case "한우버거" : price += 5000;
			 break;
		case "밥버거" : price += 4500;
			break;
		case "치즈버거" : price += 4000;
			break;
		}
		
		switch(side) {
		case "감자튀김" : price += 1500;
			break;
		case "어니언링" : price += 1700;
			break;
		}
		
		switch(bervarage) {
		case "콜라" : price += 1000;
			break;
		case "사이다" : price += 1000;
			break;
		case "커피" : price += 1500;
			break;
		case "밀크쉐이크" : price += 2500;
			break;
		}
		 
		//3.
		PrintWriter out = response.getWriter();
		out.println("<html><head><title> 앙기모띠. </title>");
		out.println("<style>");
		out.println("p1{color:red}");
		out.println("p2{color:violet}");
		out.println("p3{color:green}");
		out.println("</style></head>");
		out.println("<body>");
		out.println("<h3>"+ "감사링" +"</h3>");
		out.println("<p1>"+ bugger + "</p1>"+"," +"<p2>" +side +"</p2>"+ "," +"<p3>"+ bervarage +"</p3>" + "를 주문하셨습니다.");
		out.println("<br>" +"총 결제 금액은 "+ price +"입니다.");
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
