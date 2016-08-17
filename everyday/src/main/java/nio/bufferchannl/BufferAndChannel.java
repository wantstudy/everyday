package nio.bufferchannl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.log4j.Logger;
import org.junit.Test;

public class BufferAndChannel {
    private static Logger logger = Logger.getLogger(BufferAndChannel.class);

    @Test
    public void testgetbyteChannel() throws IOException{
        String infile = "C:\\log_network.txt";  
        String outfile = "C:\\copy.txt";  
        // ��ȡԴ�ļ���Ŀ���ļ������������  
        FileInputStream fin = new FileInputStream(infile);  
        FileOutputStream fout = new FileOutputStream(outfile);  
        // ��ȡ�������ͨ��  
        FileChannel fcin = fin.getChannel();  
        FileChannel fcout = fout.getChannel();  
        // ����������  
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {  
            // clear�������軺������ʹ�����Խ��ܶ��������  
            buffer.clear();  
            // ������ͨ���н����ݶ���������  
            int r = fcin.read(buffer);  
            // read�������ض�ȡ���ֽ���������Ϊ�㣬�����ͨ���ѵ�������ĩβ���򷵻�-1  
            if (r == -1) {  
                break;  
            }  
            // flip�����û��������Խ��¶��������д����һ��ͨ��  
            buffer.flip();  
            // �����ͨ���н�����д�뻺����  
            fcout.write(buffer); 
            logger.debug("success");
        }
    }
}
