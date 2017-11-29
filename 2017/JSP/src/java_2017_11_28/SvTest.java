package java_2017_11_28;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class svTest
 */
@WebServlet("/st")//URL맵핑 Url주소에 파일명.class가 붙는것은 너무 길고 가독성도 떨어지기 때문에
//url맵핑을 만들어 파일명 대신 사용된다. 현재 코드에선 st 가 SvTest대신 사용
public class SvTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//request는 get메서드가 많고 response는 set메서드가 많다. 
		//request는 클라이언트의 데이터를 받아와 작업하기 때문에 get이 많고
		//response는 서버쪽에서 데이터를 가공해 클라이언트로 보내기 때문에 set이 많다.
		//로그작업 : 웹페이지에 띄워주는게 아니라 콘솔창에 넣는다.
		System.out.println("GET방식");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>First Servlet</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>Hello Servlet</h1>");
		pw.println("<h1>GET방식</h1>");
		pw.println("<body>");
		pw.println("</html>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>First Servlet</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>Hello Servlet</h1>");
		pw.println("<h1>POST방식</h1>");
		pw.println("<body>");
		pw.println("</html>");
		pw.close();
	}

}
