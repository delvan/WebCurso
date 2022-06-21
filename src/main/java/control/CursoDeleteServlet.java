package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import dao.CursoDao;

/**
 * Servlet implementation class CursoDeleteServlet
 */

@WebServlet(name = "CursoDeleteServlet", urlPatterns = "/delete")
public class CursoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String id = request.getParameter("id");

		System.out.println("Deu certo");

		CursoDao dao = new CursoDao();

		String retorno = dao.remover(Integer.parseInt(id));

		if (retorno.equals("sucesso")) {
			response.sendRedirect("./pages/pesquisarCurso.jsp");
		} else {
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<h2>Não foi possivel remover curso</h2>");
			out.print("<br>");
			out.print("<a href='index.jsp'>Voltar</a>");
			out.print("</html");
		}
	}


}
