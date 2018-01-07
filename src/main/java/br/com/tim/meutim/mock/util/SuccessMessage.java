package br.com.tim.meutim.mock.util;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SuccessMessage implements Serializable {

	private static final long serialVersionUID = 931367933537335643L;

	@XmlElement(name = "success")
	private String success;

	@XmlElement(name = "protocolo")
	private String protocolo;

	@XmlElement(name = "message")
	private String message;

	@XmlElement(name = "internalCode")
	private String internalCode;

	public SuccessMessage() {
		super();
		this.success = "sucesso";
		this.protocolo = "9999999999999";
		this.message = "Sucesso";
		this.internalCode = "1234567";
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getInternalCode() {
		return internalCode;
	}

	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}

}
