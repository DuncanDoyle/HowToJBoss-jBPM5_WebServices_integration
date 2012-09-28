package org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers;

public interface ResponseMapperFactory {

	public abstract ResponseMapper getResponseMapper(final String mapperName);
	
}
