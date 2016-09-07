package nio.bufferFile;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class FileChannelMap {

	/**
	 * 把文件映射到内存
	 */
	@Test
	public void testMemeryMappedFile(){
		try {
			RandomAccessFile file = new RandomAccessFile("d:/singleton.txt", "rw");
			FileChannel fc = file.getChannel();
			MappedByteBuffer buffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, file.length()); //将文件映射到内存中
			System.out.println("0: " + (char)buffer.get(0));
			while (buffer.hasRemaining()) {
				System.out.print(buffer.get());
			}
			buffer.put(0,(byte)87);
			System.out.println("0: " + buffer.get(0));
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 聚集写操作 Scatering
	 */
	
	/**
	 * 散射读操作 Gathering
	 */
	
	/**
	 * ByteBuffer.allocateDirect(200)  直接内存访问，更解决底层
	 * 快1倍，但创建和销毁远比Bytebuffer高
	 */
}
