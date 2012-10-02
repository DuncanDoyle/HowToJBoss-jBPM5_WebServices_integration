package org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers.orderservice;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;

import org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers.ResponseMapper;
import org.jboss.ddoyle.howtojboss.orderservice.PlaceOrderResponseType;

/**
 * Maps the output of the <code>OrderService</code> onto a String param which is placed in the {@link Map parameterMap}.
 * 
 * @author <a href="mailto:duncan.doyle@redhat.com">Duncan Doyle</a>
 */
public class OrderServiceResponseMapper implements ResponseMapper {

	private static final String RESPONSE_PARAM = "response";

	@Override
	public Map<String, Object> buildResponse(Source xmlResponse) {
		JAXBContext jContext;
		try {
			jContext = JAXBContext.newInstance("org.jboss.ddoyle.howtojboss.orderservice");
		} catch (JAXBException jaxbe) {
			throw new RuntimeException("Error creating JAXB2 Context.", jaxbe);
		}
		Unmarshaller unmarshaller;
		try {
			unmarshaller = jContext.createUnmarshaller();
		} catch (JAXBException jaxbe) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Error creating unmarshaller.", jaxbe);
		}
		PlaceOrderResponseType response;
		JAXBElement<PlaceOrderResponseType> responseElement;
		try {
			responseElement = unmarshaller.unmarshal(xmlResponse, PlaceOrderResponseType.class);
			response = responseElement.getValue();
		} catch (JAXBException jaxbe) {
			throw new RuntimeException("Error unmarshalling XML response.");
		}
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put(RESPONSE_PARAM, response.getOut());

		return responseMap;
	}

}
