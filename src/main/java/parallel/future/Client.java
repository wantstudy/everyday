package parallel.future;

/**
 * 获取FutureData，快速返回，并开启构造RealData的线程
 * @author wangweiwei
 *
 */
public class Client {
	
	//构建FutureData并返回
	private FutureData futureData = new FutureData();
	
	public Data request(final String requestParam){
		//开启构造RealData的线程
		new Thread(new Runnable() {
			public void run() {
				RealData realData = new RealData(requestParam);
				futureData.setRealData(realData);
			}
		}).start();;
		
		return futureData;
	}
	
}
