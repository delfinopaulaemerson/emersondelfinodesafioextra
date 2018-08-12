package br.com.appservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "usuario")
@XmlRootElement
public class User implements Serializable {

	private static final long serialVersionUID = -8451679170281063697L;

	@Id
	@SequenceGenerator(name="SEQ_USER", sequenceName="SEQ_USER", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USER")
	private Long id;

	
	@Column(name="nome")
	private String nome;

	@Column(name="sobrenome")
	private String sobrenome;
	
	@Column(name="cpf")
	private String cpf;
	
	@Transient
	private Integer httpStatus;
	
	@Transient
	private String sucesso;
	
	@Transient
	private String error;
	
	@Transient
	private String excessao;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getSucesso() {
		return sucesso;
	}

	public void setSucesso(String sucesso) {
		this.sucesso = sucesso;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getExcessao() {
		return excessao;
	}

	public void setExcessao(String excessao) {
		this.excessao = excessao;
	}

}
