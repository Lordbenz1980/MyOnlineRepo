package com.game.src.main;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public class BulletPlayerOne {
	
	private static BufferedImage look;
	private List<BulletPlayerOne>bullets;
	
	static{
		try {
			look = ImageIO.read(BulletPlayerOne.class.getClassLoader().getResourceAsStream("gfx/schuss.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private float f_posx;
	private float f_posy;
	private float f_speedx;
	private float f_speedy;
	private Rectangle bounding;
	private float timeAlive;
	private final float TIMETOLIVE = 10;
	
	public BulletPlayerOne(float x,float y,float speedx,float speedy,List<BulletPlayerOne>bullets){
		this.f_posx = x;
		this.f_posy = y;
		this.f_speedx = speedx;
		this.f_speedy = speedy;
		bounding = new Rectangle((int)x,(int)y,look.getWidth(),look.getHeight());
		this.bullets = bullets;
	}
	
	public void update(float timeSinceLastFrame){
		timeAlive+=timeSinceLastFrame;
		
		if (timeAlive>TIMETOLIVE){
			bullets.remove(this);
		}
		
		f_posx+=f_speedx*timeSinceLastFrame;
		f_posy+=f_speedy*timeSinceLastFrame;
		
		bounding.x=(int)f_posx;
		bounding.y=(int)f_posy;
	}

	public Rectangle getBounding() {
		return bounding;
	}
	
	public static BufferedImage getLook(){
		return look;
	}
}
