package singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Assert;

public class LoadPropertiesUtil {
    
    public static String JDBC_USERNAME;
    public static String JDBC_PASSWORD;
    

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
        return DummyInstance.getInstance().getProperties();
    }
    
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        LoadPropertiesUtil instance1 = LoadPropertiesUtil.getInstance();
        LoadPropertiesUtil instance2 = LoadPropertiesUtil.getInstance();
        Assert.assertEquals(instance1, instance2);
        System.out.println(instance1.JDBC_USERNAME);
        System.out.println(instance1.JDBC_PASSWORD);
    }
    
    @SuppressWarnings("unused")
    private static LoadPropertiesUtil getProperties(){
        String jdbc = "jdbc.";
        Properties properties = new Properties();
        InputStream inStream = LoadPropertiesUtil.class.getResourceAsStream("/jdbc.properties");
        try {
            properties.load(inStream);
            JDBC_USERNAME = properties.getProperty(jdbc+"username");
            JDBC_PASSWORD = properties.getProperty(jdbc+"password");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("load properties error");
        }
        return null;
    }
    
}
