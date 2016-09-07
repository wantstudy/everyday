package wsdl.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.9
 * Tue Sep 06 16:54:24 CST 2016
 * Generated source version: 2.2.9
 * 
 */
 
@WebService(targetNamespace = "http://localhost:12345/ws/caculate", name = "CalculateService")
@XmlSeeAlso({ObjectFactory.class})
public interface CalculateService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "divide", targetNamespace = "http://localhost:12345/ws/caculate", className = "com.chit.email.utils.Divide")
    @WebMethod
    @ResponseWrapper(localName = "divideResponse", targetNamespace = "http://localhost:12345/ws/caculate", className = "com.chit.email.utils.DivideResponse")
    public float divide(
        @WebParam(name = "arg0", targetNamespace = "")
        float arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        float arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "multiply", targetNamespace = "http://localhost:12345/ws/caculate", className = "com.chit.email.utils.Multiply")
    @WebMethod
    @ResponseWrapper(localName = "multiplyResponse", targetNamespace = "http://localhost:12345/ws/caculate", className = "com.chit.email.utils.MultiplyResponse")
    public float multiply(
        @WebParam(name = "arg0", targetNamespace = "")
        float arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        float arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "plus", targetNamespace = "http://localhost:12345/ws/caculate", className = "com.chit.email.utils.Plus")
    @WebMethod
    @ResponseWrapper(localName = "plusResponse", targetNamespace = "http://localhost:12345/ws/caculate", className = "com.chit.email.utils.PlusResponse")
    public float plus(
        @WebParam(name = "arg0", targetNamespace = "")
        float arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        float arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "minus", targetNamespace = "http://localhost:12345/ws/caculate", className = "com.chit.email.utils.Minus")
    @WebMethod
    @ResponseWrapper(localName = "minusResponse", targetNamespace = "http://localhost:12345/ws/caculate", className = "com.chit.email.utils.MinusResponse")
    public float minus(
        @WebParam(name = "arg0", targetNamespace = "")
        float arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        float arg1
    );
}
