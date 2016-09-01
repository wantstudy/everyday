package parallel.future;

import java.util.concurrent.Callable;

public class RealDataJDK implements Callable<String>{
	
	private String para;
	public RealDataJDK(String para) {
		this.para = para;
	}
	
	@Override
	public String call() throws Exception {
		//这里是真实的业务逻辑，执行可能很慢
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			System.out.println("组装数据");
			buffer.append(para);
			Thread.sleep(100);
		}
		return buffer.toString();
	}

}
