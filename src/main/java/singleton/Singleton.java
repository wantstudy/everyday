package singleton;

import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * 序列化与反序列化后是同一个对象 -->io.SingletonReadResolveTest
 * @author wangweiwei
 *
 */
public class Singleton implements Serializable{

	private static final long serialVersionUID = 1L;

	//测试序列化，反序列化
	String name ="";

	private static Logger logger = Logger.getLogger(Singleton.class);
	/**
	 */
	private Singleton() {
		// TODO Auto-generated constructor stub
		System.out.println(" singleton is create"); 
		name = "111";
	}
	
	private static Singleton singleton = new Singleton();
	
	public static Singleton getInstance(){
		return singleton;
	}
	
	/**
	 *  singleton is create
	 *  createString in singleton
	 *  */
	public static void createString(){
		logger.debug("createString in singleton");
	}

	/**
	 * 总是返回一个对象
	 * @return
	 */
	private Object readResolve(){
		return singleton;
	}
}
