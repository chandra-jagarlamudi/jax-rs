package com.ragas.rest.context;

/**
 * @author Chandra Jagarlamudi
 *
 */

public class ServerContext {
	private String username;
	private String password;
	private String serverUrl;
	private String contextPath;

	public ServerContext() {
	}

	public ServerContext(final String username, final String password, final String serverUrl,
			final String contextPath) {
		super();
		this.username = username;
		this.password = password;
		this.serverUrl = serverUrl;
		this.contextPath = contextPath;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(final String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(final String contextPath) {
		this.contextPath = contextPath;
	}

}
