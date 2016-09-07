//package wsdl.client;
//
//import java.util.List;
//
//import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
//import org.junit.Test;
//
//
//public class StartWsdlClient {
//	@Test
//	public void testClient(){
//		String wsUrl = "http://localhost:12345/ws/caculate";
//		JaxWsProxyFactoryBean factory=new JaxWsProxyFactoryBean();
//		factory.setServiceClass(CalculateService.class);
//		factory.setAddress(wsUrl);
//		CalculateService service = (CalculateService) factory.create();
//		float plus = service.plus(1, 2);
//		System.out.println(plus);
//	}
//}
