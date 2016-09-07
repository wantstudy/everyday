package supervene.future;

import java.util.concurrent.Callable;

public class RealData implements Callable<String> {
	
	private String para;
	public RealData(String para) {
		this.para = para;
	}

	@Override
	public String call() throws Exception {
		//真正的业务逻辑，执行很慢
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			buffer.append(para);
		}
		Thread.sleep(100);
		return buffer.toString();
	}

}
