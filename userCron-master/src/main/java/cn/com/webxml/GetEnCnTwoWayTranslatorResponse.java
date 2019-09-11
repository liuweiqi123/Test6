
package cn.com.webxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getEnCnTwoWayTranslatorResult"
})
@XmlRootElement(name = "getEnCnTwoWayTranslatorResponse")
public class GetEnCnTwoWayTranslatorResponse {

    protected ArrayOfString getEnCnTwoWayTranslatorResult;


    public ArrayOfString getGetEnCnTwoWayTranslatorResult() {
        return getEnCnTwoWayTranslatorResult;
    }


    public void setGetEnCnTwoWayTranslatorResult(ArrayOfString value) {
        this.getEnCnTwoWayTranslatorResult = value;
    }

}
