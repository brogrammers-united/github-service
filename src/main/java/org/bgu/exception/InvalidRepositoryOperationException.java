package org.bgu.exception;

public class InvalidRepositoryOperationException extends BguGithubException {

	private static final long serialVersionUID = 1L;

	public InvalidRepositoryOperationException() {
		super();
	}

	public InvalidRepositoryOperationException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidRepositoryOperationException(String message) {
		super(message);
	}

	
}
