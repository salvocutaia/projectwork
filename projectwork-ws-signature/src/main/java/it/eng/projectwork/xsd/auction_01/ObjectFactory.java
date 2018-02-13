
package it.eng.projectwork.xsd.auction_01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.eng.projectwork.xsd.auction_01 package. 
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

    private final static QName _FaultMessageType_QNAME = new QName("http://it/eng/projectwork/xsd/auction_01", "faultMessageType");
    private final static QName _CreateAuctionResponseType_QNAME = new QName("http://it/eng/projectwork/xsd/auction_01", "createAuctionResponseType");
    private final static QName _CreateAuctionRequestType_QNAME = new QName("http://it/eng/projectwork/xsd/auction_01", "createAuctionRequestType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.eng.projectwork.xsd.auction_01
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateAuctionRequestType }
     * 
     */
    public CreateAuctionRequestType createCreateAuctionRequestType() {
        return new CreateAuctionRequestType();
    }

    /**
     * Create an instance of {@link CreateAuctionResponseType }
     * 
     */
    public CreateAuctionResponseType createCreateAuctionResponseType() {
        return new CreateAuctionResponseType();
    }

    /**
     * Create an instance of {@link FaultMessageType }
     * 
     */
    public FaultMessageType createFaultMessageType() {
        return new FaultMessageType();
    }

    /**
     * Create an instance of {@link AuctionType }
     * 
     */
    public AuctionType createAuctionType() {
        return new AuctionType();
    }

    /**
     * Create an instance of {@link SupplierType }
     * 
     */
    public SupplierType createSupplierType() {
        return new SupplierType();
    }

    /**
     * Create an instance of {@link ProductType }
     * 
     */
    public ProductType createProductType() {
        return new ProductType();
    }

    /**
     * Create an instance of {@link ImageType }
     * 
     */
    public ImageType createImageType() {
        return new ImageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it/eng/projectwork/xsd/auction_01", name = "faultMessageType")
    public JAXBElement<FaultMessageType> createFaultMessageType(FaultMessageType value) {
        return new JAXBElement<FaultMessageType>(_FaultMessageType_QNAME, FaultMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateAuctionResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it/eng/projectwork/xsd/auction_01", name = "createAuctionResponseType")
    public JAXBElement<CreateAuctionResponseType> createCreateAuctionResponseType(CreateAuctionResponseType value) {
        return new JAXBElement<CreateAuctionResponseType>(_CreateAuctionResponseType_QNAME, CreateAuctionResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateAuctionRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it/eng/projectwork/xsd/auction_01", name = "createAuctionRequestType")
    public JAXBElement<CreateAuctionRequestType> createCreateAuctionRequestType(CreateAuctionRequestType value) {
        return new JAXBElement<CreateAuctionRequestType>(_CreateAuctionRequestType_QNAME, CreateAuctionRequestType.class, null, value);
    }

}
