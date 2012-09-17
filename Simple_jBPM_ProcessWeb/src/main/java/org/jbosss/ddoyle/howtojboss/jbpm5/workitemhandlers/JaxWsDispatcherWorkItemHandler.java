package org.jbosss.ddoyle.howtojboss.jbpm5.workitemhandlers;

import org.drools.process.instance.WorkItemHandler;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemManager;

/**
* jBPM5 {@link WorkItemHandler} which calls a <code>WebService</code> using the <code>JAX-WS</code> <code>Dispatcher</code> framework.
* 
* @author <a href="mailto:duncan.doyle@redhat.com">Duncan Doyle</a>
*/
public class JaxWsDispatcherWorkItemHandler implements WorkItemHandler {

	@Override
	public void executeWorkItem(WorkItem arg0, WorkItemManager arg1) {
		//TODO: Implement method.
		/*
		// Qnames for service as defined in wsdl.
				QName serviceQName = new QName("http://xmlns.na.ch/document/metadata/provider/", "DocumentMetadataService");

				//QName for Port As defined in wsdl.
				QName portName = new QName("http://xmlns.na.ch/document/metadata/provider/", "DocumentMetadataPort");

				//Endpoint Address
				//String  endpointAddress = "http://schtwm05:8080/ESBCaseLab/DocumentMetadataPort";
				//Routing through internal proxy to check SOAP messages.
				String  endpointAddress = "http://localhost:8082/ESBCaseLab/DocumentMetadataPort";

				// Create a dynamic Service instance
				Service service = Service.create(serviceQName);

				// Add a port to the Service
				service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);

				//Create a dispatch instance
				Dispatch<SOAPMessage> dispatcher = service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);

				//Configure the SOAPAction
				BindingProvider bp = (BindingProvider) dispatcher;
				bp.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
				bp.getRequestContext().put(BindingProvider.SOAPACTION_URI_PROPERTY, "QueryContracts");
				
				//Build the SOAP Message;
				SOAPMessage requestSOAPMessage;
				try {
					requestSOAPMessage = buildSOAPMessageFromXmlStrings(payloadProxy.getRequestHeader(message), payloadProxy.getRequestBody(message));
				} catch (MessageDeliverException mde) {
					throw new ActionProcessingFaultException("Error building SOAP Message from input XML String.");
				}
				
				LOGGER.info("Calling Document Data Service - QueryContracts");
				SOAPMessage responseSOAPMessage = dispatcher.invoke(requestSOAPMessage);
				LOGGER.info("Received response from Document Data Service - QueryContracts");
				
				try {
					composeResponseMessage(responseSOAPMessage, message);
				} catch (MessageDeliverException mde) {
					throw new ActionProcessingFaultException("Error composing response JBoss SOA-P ESB Message from SOAP Message.");
				}
				
				return message;
				*/
		
	}
	
	@Override
	public void abortWorkItem(WorkItem arg0, WorkItemManager arg1) {
		throw new IllegalStateException("This WorkItem cannot be aborted.");
	}

}
