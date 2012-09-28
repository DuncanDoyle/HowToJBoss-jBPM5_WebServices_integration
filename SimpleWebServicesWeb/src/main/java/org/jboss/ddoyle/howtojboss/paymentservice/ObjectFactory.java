
package org.jboss.ddoyle.howtojboss.paymentservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jboss.ddoyle.howtojboss.paymentservice package. 
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

    private final static QName _CheckPayment_QNAME = new QName("http://www.jboss.org/ddoyle/howtojboss/PaymentService/", "CheckPayment");
    private final static QName _CheckPaymentResponse_QNAME = new QName("http://www.jboss.org/ddoyle/howtojboss/PaymentService/", "CheckPaymentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jboss.ddoyle.howtojboss.paymentservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckPaymentType }
     * 
     */
    public CheckPaymentType createCheckPaymentType() {
        return new CheckPaymentType();
    }

    /**
     * Create an instance of {@link CheckPaymentResponseType }
     * 
     */
    public CheckPaymentResponseType createCheckPaymentResponseType() {
        return new CheckPaymentResponseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPaymentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jboss.org/ddoyle/howtojboss/PaymentService/", name = "CheckPayment")
    public JAXBElement<CheckPaymentType> createCheckPayment(CheckPaymentType value) {
        return new JAXBElement<CheckPaymentType>(_CheckPayment_QNAME, CheckPaymentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPaymentResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jboss.org/ddoyle/howtojboss/PaymentService/", name = "CheckPaymentResponse")
    public JAXBElement<CheckPaymentResponseType> createCheckPaymentResponse(CheckPaymentResponseType value) {
        return new JAXBElement<CheckPaymentResponseType>(_CheckPaymentResponse_QNAME, CheckPaymentResponseType.class, null, value);
    }

}
