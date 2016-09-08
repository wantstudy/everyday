package nio.bufferchannl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class BufferAndChannel {
 
	private static Logger logger = Logger.getLogger(BufferAndChannel.class);

	File file ;
	File dfile = new File("d:/copy.txt");
	ByteBuffer buffer;
	
    @Before
    public void getFile(){
    	file = new File("d:/singleton.txt");
    	if(!dfile.exists()){
    		try {
				dfile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				logger.debug("create file fair");
			}
    	}
    	
    	//创建Buffer
    	buffer = ByteBuffer.allocate(15);
    	buffer.clear();
    	for (int i = 0; i < 10; i++) {
			buffer.put((byte) i);
		}
    }
    
    @SuppressWarnings("resource")
	@Test
    public void testgetbyteChannel() throws IOException{
		FileInputStream inputStream = new FileInputStream(file);
    	FileOutputStream outputStream = new FileOutputStream(dfile);
    	FileChannel readchannel = inputStream.getChannel(); //获取通道
    	FileChannel writechannel = outputStream.getChannel();
    	
    	ByteBuffer buffer = ByteBuffer.allocate(1024);//获取缓冲
    	
    	while(true){
//    		buffer.rewind(); 为读取buffer中有效数据做准备
    		buffer.clear(); //为重新写入buffer做准备
    		int readlen = readchannel.read(buffer);  //从通道中读取文件到缓冲
    		if(readlen == -1){
    			break;
    		}
    		buffer.flip();  //在读写切换时操作
    		writechannel.write(buffer);
    	}
    	
    	readchannel.close();
    	writechannel.close();
    	
    }
    
    /**
     * mark()  记录当期位置
     * reset() 恢复到记录的位置
     */
    @Test
    public void testBufferMark(){
    	buffer.flip();
    	for (int i = 0; i < buffer.limit(); i++) {
			System.out.println(buffer.get());
			if(i==4){
				buffer.mark();
				System.out.println("buffer mark at i : " + i);
			}
		}
    	buffer.reset(); //回到mark
    	System.out.println("reset to mark");
    	while (buffer.hasRemaining()) {   //输出从mark之后的数据
			System.out.println(buffer.get());
		}
    }
    
    
    /**
     * duplicate() 复制buffer
     */
    @Test
    public void testCopyBuffer(){
    	ByteBuffer newBuffer = buffer.duplicate(); //复制缓冲区
    	System.out.println("after duplicate");
    	System.out.println(buffer);
    	System.out.println(newBuffer);
    	
    	newBuffer.flip();
    	System.out.println("after flip");
    	System.out.println(buffer);
    	System.out.println(newBuffer);
    	
    	newBuffer.put((byte) 100); //新缓冲区第一位存入数据100
    	System.out.println("after put");
    	System.out.println(buffer);		//有各自的缓冲区的位置信息
    	System.out.println(newBuffer);
    	
    	System.out.println(buffer.get(0));   //两个缓冲区都改变了
    	System.out.println(newBuffer.get(0));
    }
    
    
    /**
     * 只读缓冲区的操作
     */
    @Test
    public void testReadOnlyBuffer(){
    	ByteBuffer readBuffer = buffer.asReadOnlyBuffer(); //生成只读缓冲
    	
    	readBuffer.flip(); //读写转换
    	
    	while (readBuffer.hasRemaining()) {
			System.out.print(readBuffer.get() + " ");
		}
    	
    	buffer.put(2,(byte)20); //修改原始缓存，只读缓冲可见
//    	readBuffer.put(2,(byte) 20); //抛异常，不可修改
    	
    	readBuffer.flip(); //读写转换
    	System.out.println();
    	
    	while (readBuffer.hasRemaining()) {
			System.out.print(readBuffer.get() + " ");
		}
    	
    }
}
