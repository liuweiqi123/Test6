
package cn.com.webxml;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;



@WebService(name = "TranslatorWebServiceSoap", targetNamespace = "http://WebXml.com.cn/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TranslatorWebServiceSoap {



    @WebMethod(action = "http://WebXml.com.cn/getEnCnTwoWayTranslator")
    @WebResult(name = "getEnCnTwoWayTranslatorResult", targetNamespace = "http://WebXml.com.cn/")
    @RequestWrapper(localName = "getEnCnTwoWayTranslator", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.GetEnCnTwoWayTranslator")
    @ResponseWrapper(localName = "getEnCnTwoWayTranslatorResponse", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.GetEnCnTwoWayTranslatorResponse")
    public ArrayOfString getEnCnTwoWayTranslator(
            @WebParam(name = "Word", targetNamespace = "http://WebXml.com.cn/")
                    String word);


    @WebMethod(operationName = "HelloWebXml", action = "http://WebXml.com.cn/HelloWebXml")
    @WebResult(name = "HelloWebXmlResult", targetNamespace = "http://WebXml.com.cn/")
    @RequestWrapper(localName = "HelloWebXml", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.HelloWebXml")
    @ResponseWrapper(localName = "HelloWebXmlResponse", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.HelloWebXmlResponse")
    public String helloWebXml();

}
