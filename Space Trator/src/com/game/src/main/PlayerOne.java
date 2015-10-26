package com.game.src.main;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PlayerOne {
	
	private Rectangle bounding;
	private float f_posx;
	private float f_posy;
	private int worldsize_x;
	private int worldsize_y;
	private BufferedImage look;
	private int shipSpeed;
	
	public PlayerOne(int x, int y,int worldsize_x,int worldsize_y,int shipSpeed){
		
		try {
			look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/Spaceship.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		bounding = new Rectangle(x, y, look.getWidth(), look.getHeight());
		f_posx = x;
		f_posy = y;
		this.worldsize_x = worldsize_x;
		this.worldsize_y = worldsize_y;
		this.shipSpeed = shipSpeed;
		
		GamepadOne.init();
	}
	
	
	
	
	/**
	 * Diese Methode aktualisiert das player objekt
	 * @param up Player goes up
	 * @param down Player goes down
	 * @param left Player goes left
	 * @param right Playwe goes right
	 */
	
	public void update(float timeSinceLastFrame){
		
		GamepadOne.controller.poll();
		//Abfrage Player Keyboardtasten und setze geschwindigkeit
		if(Keyboard.isKeyDown(KeyEvent.VK_W))f_posy-=shipSpeed*timeSinceLastFrame;
		if(Keyboard.isKeyDown(KeyEvent.VK_S))f_posy+=shipSpeed*timeSinceLastFrame;
		if(Keyboard.isKeyDown(KeyEvent.VK_D))f_posx+=shipSpeed*timeSinceLastFrame;
		if(Keyboard.isKeyDown(KeyEvent.VK_A))f_posx-=shipSpeed*timeSinceLastFrame;
		
		//Gamepad Up and Down
		if(GamepadOne.controller.getAxisValue(0)<-0.6)f_posy-=shipSpeed*timeSinceLastFrame;
		if(GamepadOne.controller.getAxisValue(0)>0.6)f_posy+=shipSpeed*timeSinceLastFrame;
		//Gamepad 
		if(GamepadOne.controller.getAxisValue(1)<-0.6)f_posx-=shipSpeed*timeSinceLastFrame;
		if(GamepadOne.controller.getAxisValue(1)>0.6)f_posx+=shipSpeed*timeSinceLastFrame;
	
		
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
	 * gibt das bounding zurück!
	 * das ist der Rahmen der den player umgibt.
	 * wichtig für die kollisionsabfrage  
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

