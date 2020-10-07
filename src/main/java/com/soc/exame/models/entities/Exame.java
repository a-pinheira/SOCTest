package com.soc.exame.models.entities;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soc.exame.models.entities.enums.ExameStatus;

@Entity
@Table(name = "tb_exame")
public class Exame extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	private String nmExame;
	private String descricao;
	/*@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING,
    pattern = "yyyy-MM-dd")
	private Date DataExame; ou
	@JsonFormat(shape = JsonFormat.Shape.STRING, 
	pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant DataExame; */
	private String dataExame; 
	//Tratamento interno nos GET's e SET's
	//private ExameStatus exameStatus;
	//private Integer exameStatus;
	private Double valorExame;
	
	
	public Exame() {
	}

	public Exame(Long id) {
    	setId(id);
    }

//	public Exame(String nmExame, String descricao, String dataExame, ExameStatus exameStatus, Double valorExame) {
	public Exame(String nmExame, String descricao, String dataExame, Double valorExame) {
		super();
		this.nmExame = nmExame;
		this.descricao = descricao;
		this.dataExame = dataExame;
		//tratamento ENUM
		//setDataExame(dataExame);
		this.valorExame = valorExame;
	}
	
	public String getNmExame() {
		return nmExame;
	}
	public void setNmExame(String nmExame) {
		this.nmExame = nmExame;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDataExame() {
		return dataExame;
	}
	public void setDataExame(String dataExame) {
		this.dataExame = dataExame;
	}
	//Tratamento interno nos GET's e SET's
	/*public ExameStatus getExameStatus() {
		return ExameStatus.valueOf(exameStatus);
	}
	public void setExameStatus(ExameStatus exameStatus) {
		//tratamento ENUM
		if (exameStatus != null) {
			this.exameStatus = exameStatus.getCode();
		}
	}*/
	
	public Double getValorExame() {
		return valorExame;
	}
	public void setValorExame(Double valorExame) {
		this.valorExame = valorExame;
	}
	
}
