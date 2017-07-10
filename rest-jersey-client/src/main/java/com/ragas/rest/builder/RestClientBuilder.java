package com.ragas.rest.builder;

import com.ragas.rest.client.IRestClient;
import com.ragas.rest.client.RestClient;
import com.ragas.rest.context.ServerContext;

/**
 * @author Chandra Jagarlamudi
 *
 */
public class RestClientBuilder {
	public static IRestClient createClient(final ServerContext context) {
		return new RestClient(context);
	}
}
