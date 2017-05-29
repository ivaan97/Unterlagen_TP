
package webservice.gen.Service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetDataUsingDataContractResult" type="{http://schemas.datacontract.org/2004/07/}CompositeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getDataUsingDataContractResult"
})
@XmlRootElement(name = "GetDataUsingDataContractResponse")
public class GetDataUsingDataContractResponse {

    @XmlElementRef(name = "GetDataUsingDataContractResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<CompositeType> getDataUsingDataContractResult;

    /**
     * Ruft den Wert der getDataUsingDataContractResult-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CompositeType }{@code >}
     *     
     */
    public JAXBElement<CompositeType> getGetDataUsingDataContractResult() {
        return getDataUsingDataContractResult;
    }

    /**
     * Legt den Wert der getDataUsingDataContractResult-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CompositeType }{@code >}
     *     
     */
    public void setGetDataUsingDataContractResult(JAXBElement<CompositeType> value) {
        this.getDataUsingDataContractResult = value;
    }

}
