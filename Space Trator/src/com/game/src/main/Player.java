package com.game.src.main;

import java.awt.Rectangle;

public class Player {
	private Rectangle bounding;
	private float f_posx;
	private float f_posy;
	private int worldsize_x;
	private int worldsize_y;
	
	
	public Player(int x, int y, int size, int worldsize_x,int worldsize_y){
		bounding = new Rectangle(x, y, size, size);
		f_posx = x;
		f_posy = y;
		this.worldsize_x = worldsize_x;
		this.worldsize_y = worldsize_y;
	}
	
	/**
	 * Diese Methode aktualisiert das player objekt
	 * @param up Player goes up
	 * @param down Player goes down
	 * @param left Player goes left
	 * @param right Playwe goes right
	 */
	
	public void update(boolean up, boolean down, boolean left, boolean right){
		//Abfrage Player Keyboardtasten und setze geschwindigkeit
		if(up)f_posy-=5;
		if(down)f_posy+=5;
		if(right)f_posx+=5;
		if(left)f_posx-=5;
		
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
}

