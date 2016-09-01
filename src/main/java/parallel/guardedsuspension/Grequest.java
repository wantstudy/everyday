package parallel.guardedsuspension;

import parallel.future.Data;

/**
 * 请求的内容
 * @author wangweiwei
 *
 *客户端请求放入请求队列，服务器从队列中获取请求
 */
public class Grequest {
	
	private String name;
	
	//服务端处理完请求后的返回结果
	private Data response;

	public Grequest(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Grequest name : " + name;
	}

	public synchronized Data getResponse() {
		return response;
	}

	public synchronized void setResponse(Data response) {
		this.response = response;
	}
	
}
