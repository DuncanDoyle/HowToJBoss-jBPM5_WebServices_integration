package org.jbosss.ddoyle.howtojboss.jbpm5.workitemhandlers;

import org.drools.process.instance.WorkItemHandler;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemManager;

/**
* jBPM5 {@link WorkItemHandler} which calls the <code>HelloService</code> WebService using a generated <code>JAX-WS</code> WebService Proxy.
* <p/>
* This {@link WorkItemHandler} is a proxy to the <code>HelloService</code>. It can not be used to call other WebServices. For each WebService, a new WorkItemHandler has to be built/generated.
* 
* @author <a href="mailto:duncan.doyle@redhat.com">Duncan Doyle</a>
*/
public class HelloServiceJaxWsProxyWorkItemHandler implements WorkItemHandler {

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
		// TODO Implement method.
		
		/*
		 * 
		 * /Retrieve the WSDL Location from the classpath and define the Service's QName.
  URL	wsdlLocation = Main.class.getClassLoader().getResource("wsdl/wssecurity_usernametoken.wsdl");;
  QName serviceQname = new QName("http://www.example.org/wssecurity_usernametoken/", "wssecurity_usernametoken");
		
  //Retrieve the endpoint proxy
  WssecurityUsernametoken_Service service = new WssecurityUsernametoken_Service(wsdlLocation, serviceQname);
  WssecurityUsernametoken endpoint = service.getPort(WssecurityUsernametoken.class);

  //Set security config and enable WS-Security.
  ((StubExt) endpoint).setSecurityConfig("jboss-wsse-client.xml");
  ((StubExt) endpoint).setConfigName("Standard WSSecurity Client");
		
  //Set the username and password in the UsernameToken.
  BindingProvider bp = (BindingProvider) endpoint;
        
  bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
  /* Don't send the password. We will trust the username. */
/*
  bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "");
        
  //Set the URL on the BindingProvider, so we can easily route to different addresses.
  bp.getRequestContext().put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://127.0.0.1:8081/WebServiceWsSecurityUsernameToken2Web");
        
  String response = endpoint.secureOperation("FedICT");
  System.out.println("My response: " + response);
     return response;
		 */
		
	}
	
	@Override
	public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
		throw new IllegalStateException("This WorkItem cannot be aborted.");
	}

}
