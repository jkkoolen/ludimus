package eu.ludimus.ws;

public enum ERRORS {
	AUTHENTICATION_ERROR(0, "You are not authorized to log in"),
	TICKET_REQUEST_ERROR(1, "ticketRequest not implmented yet");
	private int code;
	private String message;
	
    ERRORS(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
