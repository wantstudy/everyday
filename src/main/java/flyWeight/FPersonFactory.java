package flyWeight;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author wangweiwei
 * 享元模式工厂类  用于创建具体享元类，维护相同的享元对象
 */
public class FPersonFactory {

	Map<String,IPersonInterface> washes = new HashMap<String,IPersonInterface>();
	
	public IPersonInterface getWashObject(String type){
		IPersonInterface wash ;
		wash = washes.get(type);
		if(wash == null){
			wash = new Washes(type);
			washes.put(type, wash);
		}
		return wash;
	}
	
}
