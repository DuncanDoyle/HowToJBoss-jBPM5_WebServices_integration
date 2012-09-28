package org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers;

public interface RequestMapperFactory {

	public abstract RequestMapper getRequestMapper(final String mapperName);
	
}
