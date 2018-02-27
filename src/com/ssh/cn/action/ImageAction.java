package com.ssh.cn.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@Scope("prototype")
public class ImageAction {
	private InputStream image;

	public InputStream getImage() {
		return image;
	}
	public String execute() throws IOException{
		//设置图片
		BufferedImage img=new BufferedImage(200,120,BufferedImage.TYPE_3BYTE_BGR);
		//获取画笔
		Graphics2D g= img.createGraphics();
		g.setColor(Color.white);
		g.drawString("Hello World!", 20, 50);
		//将图片转成字节数组
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		ImageIO.write(img, "png", out);
		out.close();
		//将字节数组放到字节流中
		byte[] data=out.toByteArray();
		image=new ByteArrayInputStream(data);
		return "success";	
	}
}








