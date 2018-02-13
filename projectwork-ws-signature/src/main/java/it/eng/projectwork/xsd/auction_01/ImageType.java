
package it.eng.projectwork.xsd.auction_01;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ImageType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ImageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="body" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="fileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contentType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageType", propOrder = {
    "body",
    "fileName",
    "contentType"
})
public class ImageType {

    @XmlElement(required = true)
    @XmlMimeType("*/*")
    protected DataHandler body;
    @XmlElement(required = true)
    protected String fileName;
    @XmlElement(required = true)
    protected String contentType;

    /**
     * Recupera il valore della proprietà body.
     * 
     * @return
     *     possible object is
     *     {@link DataHandler }
     *     
     */
    public DataHandler getBody() {
        return body;
    }

    /**
     * Imposta il valore della proprietà body.
     * 
     * @param value
     *     allowed object is
     *     {@link DataHandler }
     *     
     */
    public void setBody(DataHandler value) {
        this.body = value;
    }

    /**
     * Recupera il valore della proprietà fileName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Imposta il valore della proprietà fileName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * Recupera il valore della proprietà contentType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Imposta il valore della proprietà contentType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentType(String value) {
        this.contentType = value;
    }

}
