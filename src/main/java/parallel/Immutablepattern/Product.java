package parallel.Immutablepattern;

/**
 * 不变模式
 * 对象创建后，内部状态和数据不再发生任何变化
 * 对象需要被共享/多线程频繁访问
 * @author wangweiwei
 * 
 * 确保为不变模式
 * 去除sertter方法以及所有修改自身属性的方法
 * 将所有属性设置为私有，并final标记
 * 没有子类可以重载修改
 * 有一个可以创建完整对象的构造函数
 *
 */
public final class Product { //确保无子类

	private final String no;      //私有属性，不会被其他对象获取
	private final String name;		//final保证不会被二次赋值
	private final double price;

	
	//创建对象时必须指定数据，因为创建后无法修改
	public Product(String no, String name, double price) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
	}


	public String getNo() {
		return no;
	}


	public String getName() {
		return name;
	}


	public double getPrice() {
		return price;
	}	
	
	
	
	
}
