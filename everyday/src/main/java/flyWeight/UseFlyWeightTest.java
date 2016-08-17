package flyWeight;

import org.junit.Assert;
import org.junit.Test;

/**
 * 享元模式使用方法
 * @author wangweiwei
 *
 */
public class UseFlyWeightTest {
	
	@Test
	public void testWashes(){
		FPersonFactory factory = new FPersonFactory();
		IPersonInterface washObject1 = factory.getWashObject("nan");
		washObject1.toWash();
		IPersonInterface washObject2 = factory.getWashObject("nv");
		washObject2.toWash();
		Assert.assertSame(washObject1, washObject2);
		
	}
}
