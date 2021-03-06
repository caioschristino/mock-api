package br.com.tim.meutim.mock.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "MT_BALANCE_HISTORY_V3")
@XmlRootElement
public class BalanceHistoryV3Entity implements Serializable {

	private static final long serialVersionUID = 4473620600086084040L;

	@Id
	@Column(name = "TOKEN", nullable = false)
	@JsonIgnore
	private String token;

	@Column(name = "JSON", nullable = false, length = 10000)
	@JsonIgnore
	private String json;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

}