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
@WebServlet("/st")//URL���� Url�ּҿ� ���ϸ�.class�� �ٴ°��� �ʹ� ��� �������� �������� ������
//url������ ����� ���ϸ� ��� ���ȴ�. ���� �ڵ忡�� st �� SvTest��� ���
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
		//request�� get�޼��尡 ���� response�� set�޼��尡 ����. 
		//request�� Ŭ���̾�Ʈ�� �����͸� �޾ƿ� �۾��ϱ� ������ get�� ����
		//response�� �����ʿ��� �����͸� ������ Ŭ���̾�Ʈ�� ������ ������ set�� ����.
		//�α��۾� : ���������� ����ִ°� �ƴ϶� �ܼ�â�� �ִ´�.
		System.out.println("GET���");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>First Servlet</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>Hello Servlet</h1>");
		pw.println("<h1>GET���</h1>");
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
		pw.println("<h1>POST���</h1>");
		pw.println("<body>");
		pw.println("</html>");
		pw.close();
	}

}
