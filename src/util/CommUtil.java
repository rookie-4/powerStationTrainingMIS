package util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.UUID;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class CommUtil {
	
	public static String getId(){
		String id = UUID.randomUUID().toString();
		
		return id;
	}
	
	//设置界面位置
	public static void setFrameLoaction(JFrame frame) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		int width = screen.width;
		int height = screen.height;
		
		int left = (width - frame.getSize().width) / 2;
		int top = (height - frame.getSize().height) / 2;
		frame.setLocation(left, top);

	}
	
	//设置界面位置
	public static void setDialogLoaction(JDialog dialog) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		int width = screen.width;
		int height = screen.height;
		
		int left = (width - dialog.getSize().width) / 2;
		int top = (height - dialog.getSize().height) / 2;
		dialog.setLocation(left, top);

	}

}
