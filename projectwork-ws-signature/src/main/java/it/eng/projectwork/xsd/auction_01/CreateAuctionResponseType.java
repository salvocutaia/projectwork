
package it.eng.projectwork.xsd.auction_01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per CreateAuctionResponseType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="CreateAuctionResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oidAuction" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="oidProduct" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="oidSupplier" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateAuctionResponseType", propOrder = {
    "oidAuction",
    "oidProduct",
    "oidSupplier"
})
public class CreateAuctionResponseType {

    protected long oidAuction;
    protected long oidProduct;
    protected long oidSupplier;

    /**
     * Recupera il valore della proprietà oidAuction.
     * 
     */
    public long getOidAuction() {
        return oidAuction;
    }

    /**
     * Imposta il valore della proprietà oidAuction.
     * 
     */
    public void setOidAuction(long value) {
        this.oidAuction = value;
    }

    /**
     * Recupera il valore della proprietà oidProduct.
     * 
     */
    public long getOidProduct() {
        return oidProduct;
    }

    /**
     * Imposta il valore della proprietà oidProduct.
     * 
     */
    public void setOidProduct(long value) {
        this.oidProduct = value;
    }

    /**
     * Recupera il valore della proprietà oidSupplier.
     * 
     */
    public long getOidSupplier() {
        return oidSupplier;
    }

    /**
     * Imposta il valore della proprietà oidSupplier.
     * 
     */
    public void setOidSupplier(long value) {
        this.oidSupplier = value;
    }

}
