package singleton;

public class LazySingleton {

	private LazySingleton() {
		System.out.println("LazySingleton is create");
	}
	
	private static LazySingleton lazySingleton = null;
	
	public static synchronized LazySingleton getInstance(){
		if(lazySingleton == null){
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}
}
