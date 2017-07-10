package com.ragas.rest.client;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ragas.rest.context.ServerContext;
import com.ragas.rest.endpoints.ApplicationEndpoints;
import com.ragas.rest.exception.ServiceException;

/**
 * @author Chandra Jagarlamudi
 *
 */
public class RestClient extends AbstractClient implements IRestClient {

	private static final Logger LOG = LoggerFactory.getLogger(RestClient.class);

	public RestClient(final ServerContext serverContext) {
		super(serverContext);
	}

	@Override
	public String get() throws ServiceException {
		WebTarget client = createClient(ApplicationEndpoints.getEndpoints());
		Response response = client.request(MediaType.APPLICATION_JSON).get();
		LOG.info("Status {}", response.getStatus());
		String result = "";

		if (Status.OK.getStatusCode() == response.getStatus()) {
			result = response.readEntity(String.class);
		} else {
			throw new ServiceException();
		}
		return result;
	}

	public static void main(final String[] args) {
		ServerContext serverContext = new ServerContext();
		serverContext.setServerUrl("http://localhost:8888/");
		serverContext.setContextPath("webapi/v1");
		serverContext.setUsername("admin");
		serverContext.setPassword("secret");

		RestClient restclient = new RestClient(serverContext);
		try {
			System.out.println(restclient.get());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
