package wsdl.server;


/**
 * 计算器运算 
 * @author wangweiwei
 *
 */
public class CalculateServiceImpl implements CalculateService{
	//加法
	public float plus(float x, float y) {
		return x + y;
	}
	//减法
	public float minus(float x, float y) {
		return x - y;
	}
	//乘法
	public float multiply(float x, float y) {
		return x * y;
	}
	//除法
	public float divide(float x, float y) {
		if(y!=0)
		{
			return x / y;
		}
		else
			return -1;
	}
}
