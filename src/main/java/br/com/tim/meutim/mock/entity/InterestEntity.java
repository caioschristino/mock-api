package br.com.tim.meutim.mock.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "MT_INTEREST")
@XmlRootElement
public class InterestEntity implements Serializable {

	private static final long serialVersionUID = 7047254473238645981L;

	@Id
	@Column(name = "TOKEN", nullable = false)
	@JsonIgnore
	@XmlElement(name = "token")
	private String token;

	@Column(name = "JSON", nullable = false, length = 10000)
	@JsonIgnore
	@XmlElement(name = "json")
	private String json;

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
