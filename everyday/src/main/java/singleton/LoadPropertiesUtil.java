package singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Assert;

public class LoadPropertiesUtil {
    
    public static String JDBC_TYPE;
    public static String JDBC_USERNAME;
    public static String JDBC_PASSWORD;
    public static String JDBC_CLASSNAME;
    public static String JDBC_URL;
    

    private LoadPropertiesUtil() {
        // TODO Auto-generated constructor stub
        System.out.println("LoadPropertiesUtil  create");
    }
    
    private static LoadPropertiesUtil util = null;
    
    private static class DummyInstance{
        public static LoadPropertiesUtil getInstance(){
            if(util==null){
                util = new LoadPropertiesUtil();
            } 
            return util;
        }
    }
    public static LoadPropertiesUtil getInstance(){
        return DummyInstance.getInstance();
    }
    
    static{
        Properties properties = new Properties();
        InputStream inStream = LoadPropertiesUtil.class.getResourceAsStream("/jdbc.properties");
        try {
            properties.load(inStream);
            JDBC_TYPE = properties.getProperty("jdbc.type");
            JDBC_USERNAME = properties.getProperty(JDBC_TYPE+".username");
            JDBC_PASSWORD = properties.getProperty(JDBC_TYPE+".password");
            JDBC_CLASSNAME = properties.getProperty(JDBC_TYPE+".driverClassName");
            JDBC_URL = properties.getProperty(JDBC_TYPE+".url");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("load properties error");
        }
    }	
    
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        LoadPropertiesUtil instance1 = LoadPropertiesUtil.getInstance();
        LoadPropertiesUtil instance2 = LoadPropertiesUtil.getInstance();
        Assert.assertEquals(instance1, instance2);
        System.out.println(instance1.JDBC_USERNAME);
        System.out.println(instance1.JDBC_PASSWORD);
    }
    
}
