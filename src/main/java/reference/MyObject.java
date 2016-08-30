package reference;

public class MyObject {

	/**
	 * 对象销毁时调用，只调用一次
	 */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("MyObject finalize called");//被回收时调用
		
	}
	
	@Override
	public String toString() {
		return "Im MyObject";
	}
}
