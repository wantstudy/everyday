//package wsdl.server;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
//import org.apache.cxf.endpoint.Server;
//import org.apache.cxf.interceptor.LoggingInInterceptor;
//import org.apache.cxf.interceptor.LoggingOutInterceptor;
//import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
//
//public class StartWsdlServer {
//	public static void main(String[] args) throws UnknownHostException {
//		//服务端工厂对象
//		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
//		//工厂对象设置提供服务的类
//		factory.setServiceClass(CalculateServiceImpl.class);
//		//设置消息进入的日志拦截器
//		factory.getInInterceptors().add(new LoggingInInterceptor());
//		//设置消息出去的日志拦截器
//		factory.getOutInterceptors().add(new LoggingOutInterceptor());
//		//设置发布服务的地址
//		factory.setAddress("http://localhost:12345/ws/caculate");
//		//创建服务端对象
//		Server server = factory.create();
//		//服务端对象启动
//		server.start();
//
//	}
//
//	private static String getLocalIpAddress() throws UnknownHostException {
//		return  InetAddress.getLocalHost()+"";
//	}
//	
//}
