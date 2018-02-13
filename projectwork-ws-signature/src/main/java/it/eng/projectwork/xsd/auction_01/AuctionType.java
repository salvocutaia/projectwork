
package it.eng.projectwork.xsd.auction_01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per AuctionType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="AuctionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;choice>
 *           &lt;element name="oidProduct" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *           &lt;element name="product" type="{http://it/eng/projectwork/xsd/auction_01}ProductType"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element name="oidSupplier" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *           &lt;element name="supplier" type="{http://it/eng/projectwork/xsd/auction_01}SupplierType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuctionType", propOrder = {
    "title",
    "description",
    "startDate",
    "endDate",
    "oidProduct",
    "product",
    "oidSupplier",
    "supplier"
})
public class AuctionType {

    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    protected Long oidProduct;
    protected ProductType product;
    protected Long oidSupplier;
    protected SupplierType supplier;

    /**
     * Recupera il valore della proprietà title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Imposta il valore della proprietà title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Recupera il valore della proprietà description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Imposta il valore della proprietà description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Recupera il valore della proprietà startDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Imposta il valore della proprietà startDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Recupera il valore della proprietà endDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Imposta il valore della proprietà endDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Recupera il valore della proprietà oidProduct.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOidProduct() {
        return oidProduct;
    }

    /**
     * Imposta il valore della proprietà oidProduct.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOidProduct(Long value) {
        this.oidProduct = value;
    }

    /**
     * Recupera il valore della proprietà product.
     * 
     * @return
     *     possible object is
     *     {@link ProductType }
     *     
     */
    public ProductType getProduct() {
        return product;
    }

    /**
     * Imposta il valore della proprietà product.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductType }
     *     
     */
    public void setProduct(ProductType value) {
        this.product = value;
    }

    /**
     * Recupera il valore della proprietà oidSupplier.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOidSupplier() {
        return oidSupplier;
    }

    /**
     * Imposta il valore della proprietà oidSupplier.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOidSupplier(Long value) {
        this.oidSupplier = value;
    }

    /**
     * Recupera il valore della proprietà supplier.
     * 
     * @return
     *     possible object is
     *     {@link SupplierType }
     *     
     */
    public SupplierType getSupplier() {
        return supplier;
    }

    /**
     * Imposta il valore della proprietà supplier.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplierType }
     *     
     */
    public void setSupplier(SupplierType value) {
        this.supplier = value;
    }

}
