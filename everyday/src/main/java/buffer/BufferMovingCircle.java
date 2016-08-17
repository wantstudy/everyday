package buffer;

import java.awt.Color;
import java.awt.Graphics;

public class BufferMovingCircle extends NoBufferMovingCircle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Graphics doubleBuffer = null; //缓冲区

	public void init(){
		super.init();
		doubleBuffer = screenImage.getGraphics();
	}

	public void paint(Graphics g){
		doubleBuffer.setColor(Color.WHITE); //使用缓冲区，优化原有paint方法
		doubleBuffer.fillRect(0, 0, 200, 100);//现在内存中画图
		drawCircle(doubleBuffer);
		g.drawImage(screenImage, 0, 0, this);//一次性显示出来
	}
}
