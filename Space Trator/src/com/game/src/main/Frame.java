package com.game.src.main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;


public class Frame extends JFrame{
	
	final PlayerOne playerOne;
	final PlayerTwo playerTwo;
	final Background bg;

	final public static int window_width = 1280;
	final public static int window_height = 600;
	
	private BufferStrategy strat;
	
	
	public Frame(PlayerOne playerOne,PlayerTwo playerTwo,Background bg){
		super("Space Trator");
		addKeyListener(new Keyboard());
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.bg =  bg;
			
	}
	
	public void makeStrat(){
		createBufferStrategy(2);
		strat= getBufferStrategy();
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
	g.drawImage(playerOne.getLook(),
				playerOne.getBounding().x,
				playerOne.getBounding().y,
				null);
	
	g.drawImage(playerTwo.getLook(),
			playerTwo.getBounding().x,
			playerTwo.getBounding().y,
			null);
	}
			
}