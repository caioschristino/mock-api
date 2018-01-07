package br.com.tim.meutim.mock.errorhandling;

public class ApiException extends Exception {

	private static final long serialVersionUID = -489592988578400669L;

	private String type;

	private Integer status;

	private String internalCode;

	private String message;

	private String transactionId;

	public ApiException() {
		super();
	}

	public ApiException(Integer status, String message) {
		super();
		this.type = "Error";
		this.status = status;
		this.internalCode = "-10001";
		this.message = message;
		this.transactionId = "Id-bc84e455f8950100000000009c7a3cfb";
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