package org.bgu.exception;

import java.util.Collections;
import java.util.Map;

public abstract class BguGithubException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BguGithubException() {
		super();
	}

	public BguGithubException(String message, Throwable cause) {
		super(message, cause);
	}

	public BguGithubException(String message) {
		super(message);
	}
	
	public Map<String, String> getMessageAsJson() {
		return Collections.singletonMap("errorMessage", getMessage());
	}

}
