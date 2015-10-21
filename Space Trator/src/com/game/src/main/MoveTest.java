package com.game.src.main;
import javax.swing.JFrame;

public class MoveTest {
	public static void main(String[] args) {
		Player player = new Player(300,300,1920,1080);
		
		Frame f = new Frame(player);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1920, 1080);
		f.setVisible(true);
		f.setResizable(false);
		
		long lastFrame = System.currentTimeMillis();
		
		while(true){
			long thisFrame = System.currentTimeMillis();
			float timeSinceLastFrame = ((float)(thisFrame-lastFrame))/1000f;
			lastFrame=thisFrame;
			
			player.update(timeSinceLastFrame,f.getUp(),f.getDown(),f.getLeft() ,f.getRight());
			
			f.repaintScreen();
			
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}