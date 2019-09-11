
package cn.com.webxml;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;



@WebServiceClient(name = "TranslatorWebService", targetNamespace = "http://WebXml.com.cn/", wsdlLocation = "http://www.webxml.com.cn/WebServices/TranslatorWebService.asmx?wsdl")
public class TranslatorWebService
    extends Service
{

    private final static URL TRANSLATORWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException TRANSLATORWEBSERVICE_EXCEPTION;
    private final static QName TRANSLATORWEBSERVICE_QNAME = new QName("http://WebXml.com.cn/", "TranslatorWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://www.webxml.com.cn/WebServices/TranslatorWebService.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TRANSLATORWEBSERVICE_WSDL_LOCATION = url;
        TRANSLATORWEBSERVICE_EXCEPTION = e;
    }

    public TranslatorWebService() {
        super(__getWsdlLocation(), TRANSLATORWEBSERVICE_QNAME);
    }

    public TranslatorWebService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TRANSLATORWEBSERVICE_QNAME, features);
    }

    public TranslatorWebService(URL wsdlLocation) {
        super(wsdlLocation, TRANSLATORWEBSERVICE_QNAME);
    }

    public TranslatorWebService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TRANSLATORWEBSERVICE_QNAME, features);
    }

    public TranslatorWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TranslatorWebService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }


    @WebEndpoint(name = "TranslatorWebServiceSoap")
    public TranslatorWebServiceSoap getTranslatorWebServiceSoap() {
        return super.getPort(new QName("http://WebXml.com.cn/", "TranslatorWebServiceSoap"), TranslatorWebServiceSoap.class);
    }


    @WebEndpoint(name = "TranslatorWebServiceSoap")
    public TranslatorWebServiceSoap getTranslatorWebServiceSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://WebXml.com.cn/", "TranslatorWebServiceSoap"), TranslatorWebServiceSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TRANSLATORWEBSERVICE_EXCEPTION!= null) {
            throw TRANSLATORWEBSERVICE_EXCEPTION;
        }
        return TRANSLATORWEBSERVICE_WSDL_LOCATION;
    }

}
