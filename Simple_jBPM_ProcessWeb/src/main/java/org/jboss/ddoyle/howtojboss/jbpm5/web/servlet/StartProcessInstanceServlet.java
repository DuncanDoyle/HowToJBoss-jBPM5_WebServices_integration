package org.jboss.ddoyle.howtojboss.jbpm5.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

/**
 * Servlet implementation class StartProcessInstanceServlet.
 * 
 * Starts a jBPM5 process instance of our <code>org.jboss.ddoyle.howtojboss.jbpm5.SimpleWebServicesIntegrationProcess</code>.
 * <p/>
 * Note that this jBPM5 runtime does not use any persistency, as this would only introduce unnnecessary complexity to this demo.
 * 
 * @author <a href="mailto:duncan.doyle@redhat.com">Duncan Doyle</a>
 */
public class StartProcessInstanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PROCESS_NAME = "org.jboss.ddoyle.howtojboss.jbpm5.SimpleWebServicesIntegrationProcess";
	
	
	/**
	 * Default constructor.
	 */
	public StartProcessInstanceServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			StatefulKnowledgeSession sks = getSKS();
			sks.startProcess(PROCESS_NAME);
	}

	/**
	 * Creates a basic {@link StatefulKnowledgeSession} which contains the <code>BPMN2</code> process definition of our sample process.
	 * 
	 * @return
	 */
	private StatefulKnowledgeSession getSKS() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("/jbpm5-process-definitions/simple-webservices-integration-process.bpmn"), ResourceType.BPMN2);
		
		KnowledgeBase kbase = kbuilder.newKnowledgeBase();
		
		return kbase.newStatefulKnowledgeSession();
	}

}
