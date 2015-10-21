package com.game.src.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.GrayFilter;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame{
	
	final Player player;
	final Background bg;

	private boolean key_up = false;
	private boolean key_down = false;
	private boolean key_left = false;
	private boolean key_right = false;
	
	
	
	final public static int window_width = 1280;
	final public static int window_height = 1024;
	
	private BufferStrategy strat;
	
	
	public Frame(Player player,Background bg){
		super("MoveTest");
		addKeyListener(new KeyHandler());
		this.player = player;
		this.bg =  bg;
			
	}
	
	public void makeStrat(){
		createBufferStrategy(2);
		strat= getBufferStrategy();
	}
	
	
	public boolean getUp(){
		return key_up;
	}
	public boolean getDown(){
		return key_down;
	}
	public boolean getLeft(){
		return key_left;
	}
	public boolean getRight(){
		return key_right;
	}
	
	
	/**
	 * Zeichnet den Sreeen Neu
	 */
	public void repaintScreen(){
		Graphics g = strat.getDrawGraphics();
		draw (g);
		g.dispose();
		strat.show();
	}
	
	private void draw(Graphics g){
		g.drawImage(bg.getLook(),
				bg.getX(),
				0, null);
	g.drawImage(bg.getLook(),
				bg.getX()+bg.getLook().getWidth(),
				0, null);
	
	//Player zeichnen
	g.drawImage(player.getLook(),
				player.getBounding().x,
				player.getBounding().y,
				null);
	}
		
	/**
	 * Ist für die Keyboardabfrage zuständig
	 * @author Lordbenz
	 *
	 */
	private class KeyHandler implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_S)key_down = true;
			if(e.getKeyCode() == KeyEvent.VK_W)key_up = true;
			if(e.getKeyCode() == KeyEvent.VK_D)key_right = true;
			if(e.getKeyCode() == KeyEvent.VK_A)key_left = true;
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_S)key_down = false;
			if(e.getKeyCode() == KeyEvent.VK_W)key_up = false;
			if(e.getKeyCode() == KeyEvent.VK_D)key_right = false;
			if(e.getKeyCode() == KeyEvent.VK_A)key_left = false;
		}

		//Unnötig
		@Override
		public void keyTyped(KeyEvent arg0) {}
		
	}
	
}