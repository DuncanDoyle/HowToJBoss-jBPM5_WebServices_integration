package org.jboss.ddoyle.howtojboss.worldservice.impl;

import javax.jws.WebService;

import org.jboss.ddoyle.howtojboss.worldservice.WorldService;

@WebService(endpointInterface="org.jboss.ddoyle.howtojboss.worldservice.WorldService")
public class SimpleWorldService implements WorldService {

	@Override
	public String getWorld(String in) {
		return "World: " + in;
	}

}
