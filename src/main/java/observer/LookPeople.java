package observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 被观察者
 * @author wangweiwei
 *
 */
public class LookPeople extends Observable {


	//新增观察者
	@Override
	public synchronized void addObserver(Observer paramObserver) {
		// TODO Auto-generated method stub
		super.addObserver(paramObserver);
	}

	//删除观察者
	@Override
	public synchronized void deleteObserver(Observer paramObserver) {
		// TODO Auto-generated method stub
		super.deleteObserver(paramObserver);
	}

	//通知观察者
	@Override
	public void notifyObservers(Object paramObject) {
		// TODO Auto-generated method stub
		super.notifyObservers(paramObject);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		setChanged();
		/**		
		setChange()方法用来设置一个内部标志位注明数据发生了变化；notifyObservers()方法会去
		调用观察者对象列表中所有的Observer的update()方法，通知它们数据发生了变化。
		只有在setChange()被调用后，notifyObservers()才会去调用update()。
		 */
		super.notifyObservers();
	}
}
