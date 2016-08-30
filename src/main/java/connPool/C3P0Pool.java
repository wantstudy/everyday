package connPool;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

import singleton.LoadPropertiesUtil;

public class C3P0Pool{

	public static Connection getPoolCoon() throws Exception{
		//连接mysql数据库
//		DataSource unpool = DataSources.unpooledDataSource(SystemValue.URL,SystemValue.USERNAME,SystemValue.PASSWORD);
		DataSource unpool = DataSources.unpooledDataSource(LoadPropertiesUtil.JDBC_URL,LoadPropertiesUtil.JDBC_USERNAME,LoadPropertiesUtil.JDBC_PASSWORD);
		//创建连接池
		DataSource pooledDataSource = DataSources.pooledDataSource(unpool);
		//获取连接
		Connection connection = pooledDataSource.getConnection();
		return connection;
	}
	
	public static void main(String[] args) {
		try {
			Class.forName(LoadPropertiesUtil.JDBC_CLASSNAME);
			//连接mysql数据库
			DataSource unpool = DataSources.unpooledDataSource(LoadPropertiesUtil.JDBC_URL,LoadPropertiesUtil.JDBC_USERNAME,LoadPropertiesUtil.JDBC_PASSWORD);
			//创建连接池
			DataSource pooledDataSource = DataSources.pooledDataSource(unpool);
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			
			connection = pooledDataSource.getConnection();//第一次获取的连接
			System.out.println("connection : " + connection.getClass().getName());
			Object o1 = getInnter(connection); //获取内部实际数据库连接
			System.out.println("o1 实际内部类： " + o1.getClass().getName());
			System.out.println();
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from users limit 0,10");
			while(resultSet.next()){
				System.out.println("DB : " + resultSet.getString(1));
			}
			
			resultSet.close();
			statement.close();
			connection.close();
			
			Thread.sleep(1000);
			
			connection = pooledDataSource.getConnection(); //第2次获取的连接
			Object o2 = getInnter(connection); //获取内部实际数据库连接
			
			if(o1 == o2){
				System.out.println("o1 same o2");
			}
			System.out.println();
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from users limit 0,10");
			while(resultSet.next()){
				System.out.println("DB : " + resultSet.getString(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object getInnter(Object con){
		Object re = null;
		Field f;
		try {
			/**
			 * getDeclaredField：获取所有方法（包括私有）
			 * inner:获取内部实际类   value:获取value属性在内存中的位置
			 * valueOffset = unsafe.objectFieldOffset  
           					(AtomicInteger.class.getDeclaredField("value")); 
           					是用来获取AtomicInteger实例中的value属性在内存中的位置。
           					这里使用了Unsafe的objectFieldOffset方法。
           					这个方法是一个本地方法， 该方法用来获取一个给定的静态属性的位置
			 */
			f = con.getClass().getDeclaredField("inner"); //获取内部实际类 inner
			f.setAccessible(true); //connection类中的成员变量为private,故必须进行此操作  
			re = f.get(con);  //获取当前对象中当前Field的value  
			f.setAccessible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}
}
