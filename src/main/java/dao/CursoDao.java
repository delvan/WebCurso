package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Curso;

public class CursoDao {

	public List<Curso> listar() {

		List<Curso> cursos = new ArrayList<Curso>();

		Conexao conn = new Conexao();

		try {

			Statement stmt = (Statement) conn.getConn().createStatement();
			ResultSet rs = stmt.executeQuery("Select * from curso ORDER BY id_curso DESC");
			while (rs.next()) {
				Curso livro = new Curso();
				livro.setIdCurso(rs.getInt("id_curso"));
				livro.setNomeCurso(rs.getString("nome_curso"));
				livro.setDataCurso(rs.getString("data_curso"));
				livro.setHoraCurso(rs.getTime("hora_curso"));
				livro.setDuracaoCurso(rs.getInt("duracao_curso"));
				livro.setResumoCurso(rs.getString("resumo_curso"));

				// Date dt = sf.parse(rs.getString("data_edicao"));

				// String st = sf.format(dt);

				// livro.setData(st);

				cursos.add(livro);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// conn.fecharConexao();
		}
		return cursos;

	}

	public String inserir(Curso curso) {

		String retorno = "falha";
		Conexao conn = new Conexao();
		try {
			Statement stmt = (Statement) conn.getConn().createStatement();
			stmt.execute(
					"insert into curso (id_curso, nome_curso, data_curso, hora_curso, duracao_curso, resumo_curso, data_criacao) "
							+ "values (" + curso.getIdCurso() + ",'" + curso.getNomeCurso() + "'," + "'"
							+ curso.getDataCurso() + "', " + "'" + curso.getHoraCurso() + "', " + ""
							+ curso.getDuracaoCurso() + "," + "'" + curso.getResumoCurso() + "','" + LocalDate.now()
							+ "')");
			retorno = "sucesso";

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.fecharConexao();
		}

		return retorno;

	}

	public String update(Curso curso) {
		String retorno = "falha";
		Conexao conn = new Conexao();

		try {

			String query = "update curso set " + "nome_curso= ?, data_curso= ?, " + "hora_curso= ?, duracao_curso= ?,"
					+ " resumo_curso= ?" + "where id_curso =" + curso.getIdCurso();

			PreparedStatement pStatement = conn.getConn().prepareStatement(query);

			pStatement.setString(1, curso.getNomeCurso());
			pStatement.setString(2, curso.getDataCurso());
			pStatement.setTime(3, curso.getHoraCurso());
			pStatement.setInt(4, curso.getDuracaoCurso());
			pStatement.setString(5, curso.getResumoCurso());

			pStatement.executeUpdate();

			retorno = "sucesso";

			// conn.close();
		} catch (Exception e) {
			System.err.println("Error! ");
			System.err.println(e.getMessage());
		}
		return retorno;

	}

	public Curso buscarCursoId(int id) {

		Conexao conn = new Conexao();
		Curso curso = new Curso();

		try {
			String sql = "select * from curso where id_curso =?";
			PreparedStatement stmt = conn.getConn().prepareStatement(sql);

			stmt.setInt(1, id); // o id é o argumento recebido pelo método
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				curso.setIdCurso(rs.getInt("id_curso"));
				curso.setNomeCurso(rs.getString("nome_curso"));
				curso.setDataCurso(rs.getString("data_curso"));
				curso.setHoraCurso(rs.getTime("hora_curso"));
				curso.setDuracaoCurso(rs.getInt("duracao_curso"));
				curso.setResumoCurso(rs.getString("resumo_curso"));

				// Calendar data = Calendar.getInstance();
				// data.setTime(rs.getDate("dataNascimento"));
				// contato.setDataNascimento(data);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return curso;
	}

	public String remover(int id) {

		String retorno = "falha";

		Conexao conn = new Conexao();

		String sql = "DELETE  FROM curso where id_curso=" + id;
		try {
			PreparedStatement stmt = conn.getConn().prepareStatement(sql);

			stmt.execute(sql);

			retorno = "sucesso";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;

	}

}
