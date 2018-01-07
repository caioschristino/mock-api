package br.com.tim.meutim.mock.errorhandling;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Error")
public class ErrorMessage implements Serializable {

	private static final long serialVersionUID = -496489572855369466L;

	@XmlElement(name = "type")
	private String type;

	@XmlElement(name = "status")
	private Integer status;

	@XmlElement(name = "internalCode")
	private String internalCode;

	@XmlElement(name = "message")
	private String message;

	@XmlElement(name = "transactionId")
	private String transactionId;

	public ErrorMessage() {
		super();
	}

	public ErrorMessage(ApiException ex) {
		super();
		this.type = ex.getType();
		this.status = ex.getStatus();
		this.internalCode = ex.getInternalCode();
		this.message = ex.getMessage();
		this.transactionId = ex.getTransactionId();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getInternalCode() {
		return internalCode;
	}

	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}