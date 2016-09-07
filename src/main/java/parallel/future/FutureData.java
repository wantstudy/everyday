package parallel.future;

/**
 * RealData的包装类
 * @author wangweiwei
 *
 */
public class FutureData implements Data{

	protected RealData realData = null;
	protected boolean isReady = false;
	
	//构建真实数据
	public synchronized void setRealData(RealData realData){
		if(isReady){
			return;
		}
		this.realData = realData;
		isReady = true;
		//realData已经注入，通知getResult
		notifyAll(); 
	}

	@Override
	public String getResult() {
		//如果数据没有构造好，线程进入阻塞状态
		while (!isReady) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return realData.result;
	}

}
