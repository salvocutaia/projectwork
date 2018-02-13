
package it.eng.projectwork.xsd.auction_01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per FaultMessageType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="FaultMessageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="descriptionError" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="systemToken" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaultMessageType")
public class FaultMessageType {

    @XmlAttribute(name = "descriptionError", required = true)
    protected String descriptionError;
    @XmlAttribute(name = "systemToken")
    protected String systemToken;

    /**
     * Recupera il valore della proprietà descriptionError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescriptionError() {
        return descriptionError;
    }

    /**
     * Imposta il valore della proprietà descriptionError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescriptionError(String value) {
        this.descriptionError = value;
    }

    /**
     * Recupera il valore della proprietà systemToken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemToken() {
        return systemToken;
    }

    /**
     * Imposta il valore della proprietà systemToken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemToken(String value) {
        this.systemToken = value;
    }

}
