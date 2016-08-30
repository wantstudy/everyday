package codeOptimization;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.CurrentTimeUtil;

/**
 * 有助于改善性能的技巧
 * @author wangweiwei
 *
 */
@SuppressWarnings("unused")
public class Optimization {
	
	public long startTime;
	public long endTime;

	
	@Before
	public void before(){
		startTime = CurrentTimeUtil.getCurrentTime();
	}
	
	/**
	 * 异常应置于循环体内，会给系统性能带来极大伤害
	 */
	@Test
	public void testException(){
		int a = 0;
		for (int i = 0; i < 2000000000; i++) {
			try {
				a++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*	try {
			for (int i = 0; i < 2000000000; i++) {
				a++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}*/
	}
	 
	
	
	@After
	public void after(){
		endTime = CurrentTimeUtil.getCurrentTime();
		System.out.println("difference between :" + (endTime-startTime));
	}
}
