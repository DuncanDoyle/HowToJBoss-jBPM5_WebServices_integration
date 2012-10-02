package org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers.orderservice;

import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;

import org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers.RequestMapper;
import org.jboss.ddoyle.howtojboss.orderservice.ObjectFactory;
import org.jboss.ddoyle.howtojboss.orderservice.PlaceOrderType;

/**
 * Creates a {@link Source}, containing the XML representation of an {@link PlaceOrderType}, from a {@link Map parameterMap}.
 * 
 * @author <a href="mailto:duncan.doyle@redhat.com">Duncan Doyle</a>
 */
public class OrderServiceRequestMapper implements RequestMapper {

	private static final String INPUT_PARAM = "input";

	@Override
	public Source buildRequest(Map<String, Object> parameterMap) {
		String input = (String) parameterMap.get(INPUT_PARAM);
		ObjectFactory of = new ObjectFactory();
		PlaceOrderType placeOrder = new PlaceOrderType();
		placeOrder.setIn(input);
		JAXBContext jContext;
		try {
			jContext = JAXBContext.newInstance("org.jboss.ddoyle.howtojboss.orderservice");
		} catch (JAXBException jaxbe) {
			throw new RuntimeException("Error creating JAXB2 Context.", jaxbe);
		}

		JAXBSource source;
		try {
			JAXBElement<PlaceOrderType> placeOTElement = new JAXBElement<PlaceOrderType>(new QName(
					"http://www.jboss.org/ddoyle/howtojboss/OrderService/", "PlaceOrder"), PlaceOrderType.class, placeOrder);
			source = new JAXBSource(jContext, placeOTElement);
		} catch (JAXBException jaxbe) {
			throw new RuntimeException("Error creating JAXBSource.");
		}

		return source;
	}
}
