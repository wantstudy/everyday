package util;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class StringUtils {

	public static void main(String[] args) {
		String[] split = ",10".split(",");
		System.out.println(split[0]+","+split[1]);
	}
	
	
	@Test
	public void testGetERPUserInfo(){
		String str = "http://172.28.4.224:8099/ClientCreditSystem/photo/2010/7/10/11453_page-0032.jpg";
		String substring = str.substring(str.lastIndexOf("/"));
		System.out.println(substring);
	}

	@Test
	public void testGetERPUrl(){
		String str = "http://172.28.4.224:8099/ClientCreditSystem/photo/2010/7/10/11453_page-0032.jpg";
		try {
			URL url = new URL(str);
			String content = url.getFile();
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
