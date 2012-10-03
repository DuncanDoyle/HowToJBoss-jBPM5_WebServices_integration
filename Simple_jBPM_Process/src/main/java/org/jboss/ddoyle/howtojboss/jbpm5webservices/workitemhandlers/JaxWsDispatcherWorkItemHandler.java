package org.jboss.ddoyle.howtojboss.jbpm5webservices.workitemhandlers;

import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.drools.process.instance.WorkItemHandler;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemManager;
import org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers.RequestMapper;
import org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers.RequestMapperFactory;
import org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers.ResponseMapper;
import org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers.ResponseMapperFactory;
import org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers.SimpleRequestMapperFactory;
import org.jboss.ddoyle.howtojboss.jbpm5webservices.mappers.SimpleResponseMapperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * jBPM5 {@link WorkItemHandler} which calls a <code>WebService</code> using the <code>JAX-WS</code> <code>Dispatcher</code> framework.
 * <p/>
 * This is a generic JAX-WS Dispatcher {@link WorkItemHandler} which can be used to call any <code>WebService</code>. It is completely
 * parameterized and is not tied to any specific <code>WebService</code>, <code>Data Model</code> and/or service location.
 * 
 * @author <a href="mailto:duncan.doyle@redhat.com">Duncan Doyle</a>
 */
public class JaxWsDispatcherWorkItemHandler implements WorkItemHandler {

	private static final String SERVICE_NAMESPACE_PARAM = "serviceNamespace";

	private static final String SERVICE_NAME_PARAM = "serviceName";

	private static final String PORT_TYPE_NAMESPACE_PARAM = "portTypeNamespace";

	private static final String PORT_TYPE_NAME_PARAM = "portTypeName";

	private static final String SOAP_ACTION_PARAM = "soapAction";

	private static final String ENDPOINT_ADDRESS_PARAM = "endpointAddress";

	private static final String REQUEST_MAPPER_PARAM = "requestMapper";

	private static final String RESPONSE_MAPPER_PARAM = "responseMapper";

	private final RequestMapperFactory requestMapperFactory;

	private final ResponseMapperFactory responseMapperFactory;

	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(JaxWsDispatcherWorkItemHandler.class);

	
	public JaxWsDispatcherWorkItemHandler() {
		this(new SimpleRequestMapperFactory(), new SimpleResponseMapperFactory());
	}
	
	public JaxWsDispatcherWorkItemHandler(RequestMapperFactory requestMapperFactory, ResponseMapperFactory responseMapperFactory) {
		this.requestMapperFactory = requestMapperFactory;
		this.responseMapperFactory = responseMapperFactory;
	}
	
	
	public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
		/*
		 * Obtain the workitem params. These should contain: - Service namespace. - Service name. - Port namespace. - Port name. - SOAP
		 * action. - Endpoint. - RequestMapper name. - ResponseMapper name. address
		 */
		Map<String, Object> parameters = workItem.getParameters();

		final String serviceNamespace = (String) parameters.get(SERVICE_NAMESPACE_PARAM);
		final String serviceName = (String) parameters.get(SERVICE_NAME_PARAM);
		final String portNamespace = (String) parameters.get(PORT_TYPE_NAMESPACE_PARAM);
		final String portName = (String) parameters.get(PORT_TYPE_NAME_PARAM);
		final String soapAction = (String) parameters.get(SOAP_ACTION_PARAM);
		final String endpointAddress = (String) parameters.get(ENDPOINT_ADDRESS_PARAM);

		final String requestMapperName = (String) parameters.get(REQUEST_MAPPER_PARAM);
		final String responseMapperName = (String) parameters.get(RESPONSE_MAPPER_PARAM);

		// TODO: We should check whether all params have values. Skipping that for now :-)

		/*
		 * Retrieve our request and response mappers.
		 */
		final RequestMapper requestMapper = requestMapperFactory.getRequestMapper(requestMapperName);
		final ResponseMapper responseMapper = responseMapperFactory.getResponseMapper(responseMapperName);

		// Qnames for service as defined in wsdl.
		QName serviceQName = new QName(serviceNamespace, serviceName);

		// QName for Port As defined in wsdl.
		QName portTypeQName = new QName(portNamespace, portName);

		// Create a dynamic Service instance
		Service service = Service.create(serviceQName);

		// Add a port to the Service
		service.addPort(portTypeQName, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);

		/*
		 * Create a dispatch instance. We can create a dispatcher with mode 'PAYLOAD' (the mode we're using here), which allows use to only
		 * provide the SOAP Envelope Body's payload. In mode 'MESSAGE', we are responsible for creating the entire SOAP message, including
		 * the header.
		 */
		Dispatch<Source> dispatcher = service.createDispatch(portTypeQName, Source.class, Service.Mode.PAYLOAD);

		// Configure the SOAPAction
		BindingProvider bp = (BindingProvider) dispatcher;
		bp.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
		bp.getRequestContext().put(BindingProvider.SOAPACTION_URI_PROPERTY, soapAction);

		// Build the SOAP Body payload as an XML Source;
		Source requestPayloadSource = requestMapper.buildRequest(parameters);

		LOGGER.info("Calling Service: " + serviceNamespace + ":" + serviceName);
		Source responsePayloadSource = dispatcher.invoke(requestPayloadSource);
		LOGGER.info("Received response from Service: " + serviceNamespace + ":" + serviceName);

		/*
		 * Build the response map. We're now using the output from the responseMapper directly, but one could, for example, also merge this
		 * output with the input parameters Map.
		 */
		Map<String, Object> responseMap = responseMapper.buildResponse(responsePayloadSource);

		// And complete the workitem.
		workItemManager.completeWorkItem(workItem.getId(), responseMap);
	}

	public void abortWorkItem(WorkItem arg0, WorkItemManager arg1) {
		throw new IllegalStateException("This WorkItem cannot be aborted.");
	}

}
