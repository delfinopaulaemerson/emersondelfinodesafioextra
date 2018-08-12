package br.com.appservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="feed")
@XmlRootElement
public class Feed implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -158164429263021787L;
	
	@Id
	@SequenceGenerator(name="SEQ_USER", sequenceName="SEQ_USER", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USER")
	private Long id;
	
	
	@Column(name="json")
	private String json;

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

}
	
	

    
