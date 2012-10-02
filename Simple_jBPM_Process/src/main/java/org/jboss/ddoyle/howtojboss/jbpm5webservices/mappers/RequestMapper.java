package org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers;

import java.util.Map;

import javax.xml.transform.Source;

public interface RequestMapper {
	
	public abstract Source buildRequest(Map<String, Object> parameterMap);

}
