package proxy.staticproxy;

/**
 * 其实抽象接口有一个最大的原因就是约束双方的行为！什么意思呢？其实就是我逼迫Proxy必须实现某些方法，
 * 而这些方法恰恰是对外公开的主要业务方法。当然也可以靠程序员自律
 * ，但是多一个约束总归是好的，至少如果没有实现指定方法我们可以在编译期就发现错误，总比执行时才能发现错误要好。
 * @author wangweiwei
 *
 */
public interface IDBQuery {

	public String request();
}
