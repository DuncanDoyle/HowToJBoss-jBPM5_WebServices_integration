package org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers;

import java.util.Map;

import javax.xml.transform.Source;

public interface ResponseMapper {
	
	public abstract Map<String, Object> buildResponse(Source xmlResponse);

}
