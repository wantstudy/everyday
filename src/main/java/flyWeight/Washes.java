package flyWeight;

/**
 * 具体享元类，实现抽象享元，完成一定业务逻辑
 * @author wangweiwei
 *
 */
public class Washes implements IPersonInterface {

	protected String type;
	
	public Washes(String type) {
		this.type = type;
	}

	public void toWash() {
		System.out.println("to washes :" + type);
	}
	
	
}
