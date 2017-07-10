package com.ragas.rest.client;

import com.ragas.rest.exception.ServiceException;

/**
 * @author Chandra Jagarlamudi
 *
 */
public interface IRestClient {

	public abstract String get() throws ServiceException;

}
