package singleton;

import org.apache.log4j.Logger;

public class Singleton {

	private static Logger logger = Logger.getLogger(Singleton.class);
	/**
	 */
	private Singleton() {
		// TODO Auto-generated constructor stub
		logger.debug(" singleton is create"); 
	}
	
	private static Singleton singleton = new Singleton();
	
	public Singleton getInstance(){
		return singleton;
	}
	
	public static void createString(){
		logger.debug("createString in singleton");
	}

	/**
	 *  singleton is create
	 *  createString in singleton
	 *  */
}
