package singleton;

public class StaticSingleton {

	private StaticSingleton() {
		System.out.println("staticSingleton is create");
	}
	
	private static class SingletonHolder{
		private static StaticSingleton singleton = new StaticSingleton();
	}
	
	public static StaticSingleton getInstance(){
		return SingletonHolder.singleton;
	}
	
}
