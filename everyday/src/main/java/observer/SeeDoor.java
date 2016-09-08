package observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者，java内置的观察者模式
 * @author wangweiwei
 *
 */
public class SeeDoor implements Observer{

	//事件发生后，具体的业务处理
	public void update(Observable paramObservable, Object paramObject) {
		System.out.println("i konw");
		System.out.println("111111111111111111");
	}
	
	
	

}
