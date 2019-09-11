
package cn.com.webxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "word"
})
@XmlRootElement(name = "getEnCnTwoWayTranslator")
public class GetEnCnTwoWayTranslator {

    @XmlElement(name = "Word")
    protected String word;


    public String getWord() {
        return word;
    }


    public void setWord(String value) {
        this.word = value;
    }

}
