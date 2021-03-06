package com.game.src.main;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public class PlayerTwo {
	private Rectangle bounding;
	private float f_posx;
	private float f_posy;
	private int worldsize_x;
	private int worldsize_y;
	private BufferedImage look;
	private int shipSpeed;
	private List<BulletPlayerTwo> bullets;
	
	public PlayerTwo(int x, int y,int worldsize_x,int worldsize_y,int shipSpeed,List<BulletPlayerTwo> bullets){
		
		try {
			look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/attackship.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		bounding = new Rectangle(x, y, look.getWidth(), look.getHeight());
		f_posx = x;
		f_posy = y;
		this.worldsize_x = worldsize_x;
		this.worldsize_y = worldsize_y;
		this.shipSpeed = shipSpeed;
		this.bullets = bullets;
	}
	
	/**
	 * Diese Methode aktualisiert das player objekt
	 * @param up Player goes up
	 * @param down Player goes down
	 * @param left Player goes left
	 * @param right Playwe goes right
	 */
	
	public void update(float timeSinceLastFrame){
		//Abfrage Player Keyboardtasten und setze geschwindigkeit
		if(Keyboard.isKeyDown(KeyEvent.VK_UP))f_posy-=shipSpeed*timeSinceLastFrame;
		if(Keyboard.isKeyDown(KeyEvent.VK_DOWN))f_posy+=shipSpeed*timeSinceLastFrame;
		if(Keyboard.isKeyDown(KeyEvent.VK_RIGHT))f_posx+=shipSpeed*timeSinceLastFrame;
		if(Keyboard.isKeyDown(KeyEvent.VK_LEFT))f_posx-=shipSpeed*timeSinceLastFrame;
		
		if(Keyboard.isKeyDown(KeyEvent.VK_SPACE)){
			bullets.add(new BulletPlayerTwo(f_posx+look.getWidth()/2-BulletPlayerTwo.getLook().getWidth()/2,
								   f_posy+look.getHeight()/2-BulletPlayerTwo.getLook().getHeight()/2,500,0,bullets));
		}
		
		
		//Abfrage Player Bildschirmrand
		if(f_posx<0)f_posx=0;
		if(f_posy<0)f_posy=0;
		if(f_posx>worldsize_x-bounding.width)f_posx=worldsize_x-bounding.width;
		if(f_posy>worldsize_y-bounding.height)f_posy=worldsize_y-bounding.height;
		
		//Rahmen
		bounding.x=(int)f_posx;
		bounding.y=(int)f_posy;
	}
	/**
	 * gibt das bounding zur�ck!
	 * das ist der Rahmen der den player umgibt.
	 * wichtig f�r die kollisionsabfrage  
	 * @return bounding
	 */
	public Rectangle getBounding(){
		return bounding;
	}
	
	public BufferedImage getLook(){
		return look;
	}

	public int getShipSpeed() {
		return shipSpeed;
	}

	public void setShipSpeed(int shipSpeed) {
		this.shipSpeed = shipSpeed;
	}
	
	
}

