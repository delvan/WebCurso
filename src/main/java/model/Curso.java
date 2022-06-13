package model;

import java.sql.Time;

public class Curso {

	private int id_curso;
	private String nome_curso;
	private String data_curso;
	private Time hora_curso;
	private Integer duração_curso;
	private String resumo_curso;

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public String getNome_curso() {
		return nome_curso;
	}

	public void setNome_curso(String nome_curso) {
		this.nome_curso = nome_curso;
	}

	public String getData_curso() {
		return data_curso;
	}

	public void setData_curso(String data_curso) {
		this.data_curso = data_curso;
	}

	public Time getHora_curso() {
		return hora_curso;
	}

	public void setHora_curso(Time hora_curso) {
		this.hora_curso = hora_curso;
	}

	public Integer getDuração_curso() {
		return duração_curso;
	}

	public void setDuração_curso(Integer duração_curso) {
		this.duração_curso = duração_curso;
	}

	public String getResumo_curso() {
		return resumo_curso;
	}

	public void setResumo_curso(String resumo_curso) {
		this.resumo_curso = resumo_curso;
	}

	@Override
	public String toString() {
		return "Curso [id_curso=" + id_curso + ", nome_curso=" + nome_curso + ", data_curso=" + data_curso
				+ ", hora_curso=" + hora_curso + ", duração_curso=" + duração_curso + ", resumo_curso=" + resumo_curso
				+ "]";
	}

}
