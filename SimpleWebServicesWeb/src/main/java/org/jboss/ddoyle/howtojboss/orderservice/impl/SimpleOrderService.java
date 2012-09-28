package org.jboss.ddoyle.howtojboss.orderservice.impl;

import javax.jws.WebService;

import org.jboss.ddoyle.howtojboss.orderservice.OrderService;

@WebService(endpointInterface="org.jboss.ddoyle.howtojboss.orderservice.OrderService")
public class SimpleOrderService implements OrderService {

	@Override
	public String placeOrder(String in) {
		return "Order '" + in +"' submitted successfully";
	}

}
