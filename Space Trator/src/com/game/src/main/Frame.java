package com.game.src.main;

import java.awt.Graphics;
import java.util.List;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;


public class Frame extends JFrame{
	
	final PlayerOne playerOne;
	final PlayerTwo playerTwo;
	final Background bg;

	final public static int window_width = 1280;
	final public static int window_height = 600;
	
	private BufferStrategy strat;
	private List<BulletPlayerOne> bullets;
	private List<BulletPlayerTwo> bullets2;
	
	public Frame(PlayerOne playerOne,PlayerTwo playerTwo,Background bg,List<BulletPlayerOne> bullets,List<BulletPlayerTwo> bullets2){
		super("Space Trator");
		addKeyListener(new Keyboard());
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.bg =  bg;
		this.bullets = bullets;
		this.bullets2 = bullets2;
			
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
	
	//PlayerOne zeichnen
	g.drawImage(playerOne.getLook(),
				playerOne.getBounding().x,
				playerOne.getBounding().y,
				null);
	
	for(int i =0;i<bullets.size();i++){
		BulletPlayerOne b = bullets.get(i);
		g.drawImage(BulletPlayerOne.getLook(),b.getBounding().x,b.getBounding().y,null);
	}
		
	//PlayerTwo zeichnen
	g.drawImage(playerTwo.getLook(),
				playerTwo.getBounding().x,
				playerTwo.getBounding().y,
				null);
	
	
	for(int i =0;i<bullets2.size();i++){
		BulletPlayerTwo b2 = bullets2.get(i);
		g.drawImage(BulletPlayerTwo.getLook(),b2.getBounding().x,b2.getBounding().y,null);
		}
	}		
}