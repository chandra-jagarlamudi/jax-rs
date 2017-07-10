package com.ragas.rest.exception;

/**
 * @author Chandra Jagarlamudi
 *
 */
public class ServiceException extends Exception {

	private boolean hasCode = false;

	private Integer code = null;

	private static final long serialVersionUID = 7519207135551508320L;

	public ServiceException(final String message) {
		super(message);
	}

	public ServiceException(final int code) {
		this.code = code;
		this.hasCode = true;
	}

	public ServiceException() {
	}

	public ServiceException(final Exception e) {
		super(e);
	}

	public boolean hasCode() {
		return hasCode;
	}

	public Integer getCode() {
		return code;
	}
}