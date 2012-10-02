package org.jboss.ddoyle.howtojboss.jbpm5webservices;

import java.util.HashMap;
import java.util.Map;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.ProcessInstance;
import org.drools.runtime.process.WorkItemManager;
import org.jboss.ddoyle.howtojboss.jbpm5webservices.workitemhandlers.JaxWsDispatcherWorkItemHandler;
import org.jboss.ddoyle.howtojboss.jbpm5webservices.workitemhandlers.PaymentServiceJaxWsProxyWorkItemHandler;

/**
 * Main class which creates the {@link KnowledgeBase}, loads the BPMN2 process, creates the {@link StatefulKnowledgeSession} and starts the
 * {@link ProcessInstance}.
 * 
 * @author <a href="mailto:duncan.doyle@redhat.com">Duncan Doyle</a>
 */
public class Main {

	private static final String PROCESS_NAME = "simple-webservices-integration-process";

	public static void main(String[] args) {
		// The first command-line argument is the order, the second is payment type.
		if (args.length != 2) {
			throw new IllegalArgumentException("Expected 2 arguments, 'order' and 'paymentType'.");
		}
		String order = args[0];
		String paymentType = args[1];

		// Set the process start arguments.
		Map<String, Object> processArguments = new HashMap<String, Object>();
		processArguments.put("order", order);
		processArguments.put("paymentType", paymentType);

		System.out.println("Loading StatefulKnowledgeSession.");
		StatefulKnowledgeSession sks = getSKS();

		// Register our WorkItemHandlers.
		WorkItemManager wim = sks.getWorkItemManager();
		PaymentServiceJaxWsProxyWorkItemHandler paymentServiceWIH = new PaymentServiceJaxWsProxyWorkItemHandler();
		wim.registerWorkItemHandler("PaymentService", paymentServiceWIH);
		JaxWsDispatcherWorkItemHandler jaxwsDispatcherWIH = new JaxWsDispatcherWorkItemHandler();
		wim.registerWorkItemHandler("JAX-WS-Dispatcher-Service", jaxwsDispatcherWIH);

		System.out.println("Starting Process Instance.");

		ProcessInstance pInstance = sks.startProcess(PROCESS_NAME, processArguments);
		System.out.println("Finished Process Instance with id: " + pInstance.getId());
	}

	/**
	 * Creates a basic {@link StatefulKnowledgeSession} which contains the <code>BPMN2</code> process definition of our sample process.
	 * 
	 * @return
	 */
	private static StatefulKnowledgeSession getSKS() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(
				ResourceFactory
						.newClassPathResource("jbpm5-process-definitions/org.jboss.ddoyle.howtojboss.jbpm5webservices.simple-webservices-integration-process.v1.bpmn2"),
				ResourceType.BPMN2);

		KnowledgeBase kbase = kbuilder.newKnowledgeBase();

		return kbase.newStatefulKnowledgeSession();
	}

}
