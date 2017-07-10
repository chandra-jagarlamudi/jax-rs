package com.ragas.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ragas.rest.context.ServerContext;

/**
 * @author Chandra Jagarlamudi
 *
 */

public abstract class AbstractClient {
	private static final Logger LOG = LoggerFactory.getLogger(AbstractClient.class);
	private final ServerContext context;

	protected AbstractClient(final ServerContext context) {
		this.context = context;
	}

	protected WebTarget createClient(final String path) {
		String assembledPath = assembleEndpoint(path);
		LOG.debug("Endpoint URL: " + assembledPath);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(assembledPath);
		if (context.getUsername() != null && context.getPassword() != null) {
			HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(context.getUsername(),
					context.getPassword());
			target = target.register(feature);
		}
		return target;
	}

	private String assembleEndpoint(final String path) {
		return context.getServerUrl().concat(context.getContextPath()).concat(path);
	}

}
