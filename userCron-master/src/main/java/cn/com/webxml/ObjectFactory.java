
package cn.com.webxml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;



@XmlRegistry
public class ObjectFactory {

    private final static QName _String_QNAME = new QName("http://WebXml.com.cn/", "string");
    private final static QName _ArrayOfString_QNAME = new QName("http://WebXml.com.cn/", "ArrayOfString");


    public ObjectFactory() {
    }


    public GetEnCnTwoWayTranslatorResponse createGetEnCnTwoWayTranslatorResponse() {
        return new GetEnCnTwoWayTranslatorResponse();
    }


    public ArrayOfString createArrayOfString() {
        return new ArrayOfString();
    }


    public HelloWebXmlResponse createHelloWebXmlResponse() {
        return new HelloWebXmlResponse();
    }


    public HelloWebXml createHelloWebXml() {
        return new HelloWebXml();
    }


    public GetEnCnTwoWayTranslator createGetEnCnTwoWayTranslator() {
        return new GetEnCnTwoWayTranslator();
    }


    @XmlElementDecl(namespace = "http://WebXml.com.cn/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }


    @XmlElementDecl(namespace = "http://WebXml.com.cn/", name = "ArrayOfString")
    public JAXBElement<ArrayOfString> createArrayOfString(ArrayOfString value) {
        return new JAXBElement<ArrayOfString>(_ArrayOfString_QNAME, ArrayOfString.class, null, value);
    }

}
