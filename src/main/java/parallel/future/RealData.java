package parallel.future;


public class RealData implements Data{
	
	protected String result; 
	
	public RealData(String param) {
		//这里是真实的业务逻辑，执行可能很慢
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 10; i++) {
//			System.out.println("组装数据");
			buffer.append(param);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		result = buffer.toString();
	}
	
	@Override
	public String getResult() {
		return result;
	}
}
