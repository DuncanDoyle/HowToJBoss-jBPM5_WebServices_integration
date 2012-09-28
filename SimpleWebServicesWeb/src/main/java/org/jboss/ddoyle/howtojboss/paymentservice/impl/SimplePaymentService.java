package org.jboss.ddoyle.howtojboss.paymentservice.impl;

import javax.jws.WebService;

import org.jboss.ddoyle.howtojboss.paymentservice.PaymentService;

@WebService(endpointInterface = "org.jboss.ddoyle.howtojboss.paymentservice.PaymentService")
public class SimplePaymentService implements PaymentService {

	/**
	 * Approves payment when payment is "VISA".
	 * 
	 * @param in
	 *            the payment type.
	 * @return <code>Payment approved</code> or <code>Payment disapproved</code>
	 */
	@Override
	public String checkPayment(String in) {
		String response = "INVALID";
		if ("VISA".equals(in)) {
			response = "VALID";
		}
		return response;
	}

}
