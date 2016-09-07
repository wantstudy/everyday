package wsdl.server;

import javax.jws.WebService;

/**
 * 计算器运算 
 * @author wangweiwei
 *
 */
@WebService
public interface CalculateService {
	//加法
	public float plus(float x, float y) ;
	//减法
	public float minus(float x, float y);
	//乘法
	public float multiply(float x, float y);
	//除法
	public float divide(float x, float y) ;
}
