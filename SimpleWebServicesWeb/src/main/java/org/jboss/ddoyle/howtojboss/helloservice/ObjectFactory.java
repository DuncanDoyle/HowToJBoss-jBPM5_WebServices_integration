
package org.jboss.ddoyle.howtojboss.helloservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jboss.ddoyle.howtojboss.helloservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetHelloResponse_QNAME = new QName("http://www.jboss.org/ddoyle/howtojboss/HelloService/", "GetHelloResponse");
    private final static QName _GetHello_QNAME = new QName("http://www.jboss.org/ddoyle/howtojboss/HelloService/", "GetHello");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jboss.ddoyle.howtojboss.helloservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHelloType }
     * 
     */
    public GetHelloType createGetHelloType() {
        return new GetHelloType();
    }

    /**
     * Create an instance of {@link GetHelloResponseType }
     * 
     */
    public GetHelloResponseType createGetHelloResponseType() {
        return new GetHelloResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHelloResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jboss.org/ddoyle/howtojboss/HelloService/", name = "GetHelloResponse")
    public JAXBElement<GetHelloResponseType> createGetHelloResponse(GetHelloResponseType value) {
        return new JAXBElement<GetHelloResponseType>(_GetHelloResponse_QNAME, GetHelloResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHelloType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jboss.org/ddoyle/howtojboss/HelloService/", name = "GetHello")
    public JAXBElement<GetHelloType> createGetHello(GetHelloType value) {
        return new JAXBElement<GetHelloType>(_GetHello_QNAME, GetHelloType.class, null, value);
    }

}
