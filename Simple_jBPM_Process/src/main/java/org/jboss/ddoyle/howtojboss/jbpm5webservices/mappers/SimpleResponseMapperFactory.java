package org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers;

import org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers.orderservice.OrderServiceResponseMapper;

public class SimpleResponseMapperFactory implements ResponseMapperFactory {

	private static final OrderServiceResponseMapper orderServiceResponseMapper = new OrderServiceResponseMapper();
	
	private static final String ORDER_SERVICE_RESPONSE_MAPPER_NAME = "orderServiceResponseMapper";
	
	@Override
	public ResponseMapper getResponseMapper(String mapperName) {
		ResponseMapper mapper;
		if (ORDER_SERVICE_RESPONSE_MAPPER_NAME.equals(mapperName)) {
			mapper = orderServiceResponseMapper; 
		} else {
			throw new IllegalArgumentException("Unknown mapper name: " + mapperName);
		}
		return mapper;
	}
	
}
