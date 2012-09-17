package org.jboss.ddoyle.howtojboss.helloservice.impl;

import javax.jws.WebService;

import org.jboss.ddoyle.howtojboss.helloservice.HelloService;

@WebService(endpointInterface="org.jboss.ddoyle.howtojboss.helloservice.HelloService")
public class SimpleHelloService implements HelloService {

	public String getHello(String in) {
		return "Hello: " + in;
	}

}
