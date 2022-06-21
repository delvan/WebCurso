package model;

import java.sql.Time;

public class Curso {

	private int idCurso;
	private String nomeCurso;
	private String dataCurso;
	private Time horaCurso;
	private Integer duracaoCurso;
	private String resumoCurso;
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public String getDataCurso() {
		return dataCurso;
	}
	public void setDataCurso(String dataCurso) {
		this.dataCurso = dataCurso;
	}
	public Time getHoraCurso() {
		return horaCurso;
	}
	public void setHoraCurso(Time horaCurso) {
		this.horaCurso = horaCurso;
	}
	public Integer getDuracaoCurso() {
		return duracaoCurso;
	}
	public void setDuracaoCurso(Integer duracaoCurso) {
		this.duracaoCurso = duracaoCurso;
	}
	public String getResumoCurso() {
		return resumoCurso;
	}
	public void setResumoCurso(String resumoCurso) {
		this.resumoCurso = resumoCurso;
	}



}
