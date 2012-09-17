
package org.jboss.ddoyle.howtojboss.worldservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jboss.ddoyle.howtojboss.worldservice package. 
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

    private final static QName _GetWorld_QNAME = new QName("http://www.jboss.org/ddoyle/howtojboss/WorldService/", "GetWorld");
    private final static QName _GetWorldResponse_QNAME = new QName("http://www.jboss.org/ddoyle/howtojboss/WorldService/", "GetWorldResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jboss.ddoyle.howtojboss.worldservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetWorldType }
     * 
     */
    public GetWorldType createGetWorldType() {
        return new GetWorldType();
    }

    /**
     * Create an instance of {@link GetWorldResponseType }
     * 
     */
    public GetWorldResponseType createGetWorldResponseType() {
        return new GetWorldResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWorldType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jboss.org/ddoyle/howtojboss/WorldService/", name = "GetWorld")
    public JAXBElement<GetWorldType> createGetWorld(GetWorldType value) {
        return new JAXBElement<GetWorldType>(_GetWorld_QNAME, GetWorldType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWorldResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jboss.org/ddoyle/howtojboss/WorldService/", name = "GetWorldResponse")
    public JAXBElement<GetWorldResponseType> createGetWorldResponse(GetWorldResponseType value) {
        return new JAXBElement<GetWorldResponseType>(_GetWorldResponse_QNAME, GetWorldResponseType.class, null, value);
    }

}
