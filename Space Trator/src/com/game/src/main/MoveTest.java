package com.game.src.main;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.JFrame;

public class MoveTest {
	public static void main(String[] args) {
		java.util.List<Bullet> bullets = new LinkedList<Bullet>();
		PlayerOne playerOne = new PlayerOne(300,300,Frame.window_width,Frame.window_height,600,bullets);
		PlayerTwo playerTwo = new PlayerTwo(300,300,Frame.window_width,Frame.window_height,300);
		
		Background bg = new Background(200);
		
		Frame f = new Frame(playerOne,playerTwo,bg,bullets);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(Frame.window_width,Frame.window_height);
		f.setVisible(true);
		f.setResizable(false);
		
		f.makeStrat();
		
		//Frameberechnung
		long lastFrame = System.currentTimeMillis();
		
		
		
		while(true){
			if(Keyboard.isKeyDown(KeyEvent.VK_ESCAPE)){System.exit(0);}
			//Frameberechnung
			long thisFrame = System.currentTimeMillis();
			float timeSinceLastFrame = ((float)(thisFrame-lastFrame))/1000f;
			lastFrame=thisFrame;
			
			//Update der Objekte
			playerOne.update(timeSinceLastFrame);
			playerTwo.update(timeSinceLastFrame);
			bg.update(timeSinceLastFrame);
			
			for(int i = 0;i<bullets.size();i++){
				bullets.get(i).update(timeSinceLastFrame);
			}
			
			//Frame repaint
			f.repaintScreen();
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}