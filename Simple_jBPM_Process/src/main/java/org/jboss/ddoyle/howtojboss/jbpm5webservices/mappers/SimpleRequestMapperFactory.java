package org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers;

import org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers.orderservice.OrderServiceRequestMapper;

public class SimpleRequestMapperFactory implements RequestMapperFactory {

private static final OrderServiceRequestMapper orderServiceRequestMapper = new OrderServiceRequestMapper();
	
	private static final String ORDER_SERVICE_REQUEST_MAPPER_NAME = "orderServiceRequestMapper";
	
	@Override
	public RequestMapper getRequestMapper(String mapperName) {
		RequestMapper mapper;
		if (ORDER_SERVICE_REQUEST_MAPPER_NAME.equals(mapperName)) {
			mapper = orderServiceRequestMapper; 
		} else {
			throw new IllegalArgumentException("Unknown mapper name: " + mapperName);
		}
		return mapper;
	}

}
