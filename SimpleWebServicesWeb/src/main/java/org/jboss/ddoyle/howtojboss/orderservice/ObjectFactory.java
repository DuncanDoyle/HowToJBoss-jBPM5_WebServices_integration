
package org.jboss.ddoyle.howtojboss.orderservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jboss.ddoyle.howtojboss.orderservice package. 
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

    private final static QName _PlaceOrder_QNAME = new QName("http://www.jboss.org/ddoyle/howtojboss/OrderService/", "PlaceOrder");
    private final static QName _PlaceOrderResponse_QNAME = new QName("http://www.jboss.org/ddoyle/howtojboss/OrderService/", "PlaceOrderResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jboss.ddoyle.howtojboss.orderservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PlaceOrderType }
     * 
     */
    public PlaceOrderType createPlaceOrderType() {
        return new PlaceOrderType();
    }

    /**
     * Create an instance of {@link PlaceOrderResponseType }
     * 
     */
    public PlaceOrderResponseType createPlaceOrderResponseType() {
        return new PlaceOrderResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceOrderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jboss.org/ddoyle/howtojboss/OrderService/", name = "PlaceOrder")
    public JAXBElement<PlaceOrderType> createPlaceOrder(PlaceOrderType value) {
        return new JAXBElement<PlaceOrderType>(_PlaceOrder_QNAME, PlaceOrderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceOrderResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jboss.org/ddoyle/howtojboss/OrderService/", name = "PlaceOrderResponse")
    public JAXBElement<PlaceOrderResponseType> createPlaceOrderResponse(PlaceOrderResponseType value) {
        return new JAXBElement<PlaceOrderResponseType>(_PlaceOrderResponse_QNAME, PlaceOrderResponseType.class, null, value);
    }

}
