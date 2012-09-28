package org.jboss.ddoyle.howtojboss.jbpm5webservices.workitemhandlers;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.drools.process.instance.WorkItemHandler;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemManager;
import org.jboss.ddoyle.howtojboss.paymentservice.PaymentService;
import org.jboss.ddoyle.howtojboss.paymentservice.PaymentService_Service;

/**
 * jBPM5 {@link WorkItemHandler} which calls the <code>HelloService</code> WebService using a generated <code>JAX-WS</code> WebService
 * Proxy.
 * <p/>
 * This {@link WorkItemHandler} is a proxy to the <code>HelloService</code>. It can not be used to call other WebServices. For each
 * WebService, a new WorkItemHandler has to be built/generated.
 * 
 * @author <a href="mailto:duncan.doyle@redhat.com">Duncan Doyle</a>
 */
public class PaymentServiceJaxWsProxyWorkItemHandler implements WorkItemHandler {

	public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
		/*
		 *  First retrieve the parameter values passed in by the jBPM5 process.
		 *  This will include the endpoint location of the PaymentService and the request parameter (as a String);
		 */
		Map<String, Object> parameters = workItem.getParameters();
		
		String endpointLocation = (String) parameters.get("location");
		String request = (String) parameters.get("input");
		
		/*
		 * TODO: We should check whether we've actually retrieved the params, and if this is not the case, signal an error. Being lazy for now ;-)
		 */
		
		/*
		 * Retrieve the WSDL Location from the classpath and define the Service's QName.
		 */
		URL wsdlLocation = PaymentServiceJaxWsProxyWorkItemHandler.class.getClassLoader().getResource("wsdl/PaymentService.wsdl");

		QName serviceQname = new QName("http://www.jboss.org/ddoyle/howtojboss/PaymentService/", "PaymentService");

		// Retrieve the endpoint proxy
		PaymentService_Service service = new PaymentService_Service(wsdlLocation, serviceQname);
		PaymentService endpoint = service.getPort(PaymentService.class);

		// Set the username and password in the UsernameToken.
		BindingProvider bp = (BindingProvider) endpoint;

		// Set the URL on the BindingProvider, so we can easily route to different addresses.
		bp.getRequestContext().put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				endpointLocation);

		String response = endpoint.checkPayment(request);
		
		Map<String, Object> responses = new HashMap<String, Object>();
		
		//And add the webservice response to the parameters map.
		responses.put("paymentServiceResponse", response);
		
		//And complete the WorkItem
		workItemManager.completeWorkItem(workItem.getId(), responses);

	}

	public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
		throw new IllegalStateException("This WorkItem cannot be aborted.");
	}

}
