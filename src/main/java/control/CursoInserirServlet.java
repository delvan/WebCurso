package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Curso;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.CursoDao;

/**
 * Servlet implementation class CursoInserirServlet
 */
@WebServlet(name = "CursoInserirServlet", urlPatterns = "/inserir")
public class CursoInserirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String id = request.getParameter("id");
		String nome_curso = request.getParameter("nome_curso");
		String data_curso = request.getParameter("data_curso");
		String hora_curso = request.getParameter("hora_curso");
		String duracao_curso = request.getParameter("duracao_curso");
		String resumo_curso = request.getParameter("resumo_curso");

		// String url = request.getContextPath();

		try {

			System.out.println(nome_curso);
			System.out.println(data_curso);
			System.out.println(hora_curso);
			System.out.println(duracao_curso);
			System.out.println(resumo_curso);

			System.out.println(id);

			CursoDao dao = new CursoDao();

			Curso curso = new Curso();
			// nome curso
			curso.setNomeCurso(nome_curso);
			SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd");
			Date dataCurso = sft.parse(data_curso);
			String dt = sft.format(dataCurso);
			// Data Curso
			curso.setDataCurso(dt);
			Time hora = Time.valueOf(hora_curso + ":00");
			// System.out.println(hora);
			// Hora curso
			curso.setHoraCurso(hora);
			// Duracao Curso
			curso.setDuracaoCurso(Integer.parseInt(duracao_curso));
			// Resumo Curso
			curso.setResumoCurso(resumo_curso);
			
			
			String retorno = dao.inserir(curso);

			if (retorno.equals("sucesso")) {
				System.out.println("Deu certo..");
				response.sendRedirect("./pages/pesquisarCurso.jsp");

			} else {
				PrintWriter out = response.getWriter();
				out.print("<html>");
				out.print("<h2>Não foi possivel inserir curso</h2>");
				out.print("<br>");
				out.print("<a href='index.jsp'>Voltar</a>");
				out.print("</html");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
