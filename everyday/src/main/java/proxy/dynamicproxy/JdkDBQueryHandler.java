package proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import proxy.staticproxy.DBQuery;
import proxy.staticproxy.IDBQuery;

/**
 * jdk动态代理
 * @author wangweiwei
 *
 */
public class JdkDBQueryHandler implements InvocationHandler {
	//主题接口
	IDBQuery query;
	
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		if(query == null){
			query = new DBQuery(); //第一次调用，生成真实对象
		}
		return query.request(); //使用真实主题完成实际操作
	}
	
	public static IDBQuery createJdkProxy(){
		IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IDBQuery.class}, new JdkDBQueryHandler());
		return jdkProxy;
	}

}
