package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Assert;
import org.junit.Test;

import singleton.Singleton;

public class SingletonReadResolveTest {

	@SuppressWarnings("resource")
	@Test
	public void testResloveObject() throws Exception{
		Singleton s1 = null;
		Singleton s2 = Singleton.getInstance();
		//win10 C盘只能创建文件夹， 选c盘会包拒绝访问
		File file = new File("D:/singleton.txt");
		 if(!file.exists()){       
	            System.out.println("不存在");
	            System.out.println("file.createNewFile()");
	            file.createNewFile();
	        } 
		//先将实例串行化到文件
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(s2);
		objectOutputStream.flush();
		objectOutputStream.close();
		
		//再从文件获取实例
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		s1 = (Singleton) objectInputStream.readObject();
		
		//比较两者
		Assert.assertEquals(s1, s2);
	}
}
