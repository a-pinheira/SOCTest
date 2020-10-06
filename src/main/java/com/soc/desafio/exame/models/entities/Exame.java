package com.soc.desafio.exame.models.entities;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Exame extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	private String nmExame;
	private String Descricao;
	/*@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date DataExame; */
	private String DataExame;
	private Double ValorExame;
	
	public Exame() {
		super();
	}

	public Exame(String nmExame, String descricao, String dataExame, Double valorExame) {
		super();
		this.nmExame = nmExame;
		Descricao = descricao;
		DataExame = dataExame;
		ValorExame = valorExame;
	}

	
	public String getNmExame() {
		return nmExame;
	}
	public void setNmExame(String nmExame) {
		this.nmExame = nmExame;
	}

	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getDataExame() {
		return DataExame;
	}
	public void setDataExame(String dataExame) {
		DataExame = dataExame;
	}

	public Double getValorExame() {
		return ValorExame;
	}
	public void setValorExame(Double valorExame) {
		ValorExame = valorExame;
	}
	
}
