
package cn.com.webxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "helloWebXmlResult"
})
@XmlRootElement(name = "HelloWebXmlResponse")
public class HelloWebXmlResponse {

    @XmlElement(name = "HelloWebXmlResult")
    protected String helloWebXmlResult;


    public String getHelloWebXmlResult() {
        return helloWebXmlResult;
    }


    public void setHelloWebXmlResult(String value) {
        this.helloWebXmlResult = value;
    }

}
