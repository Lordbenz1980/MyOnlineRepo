package com.game.src.main;
import javax.swing.JFrame;

public class MoveTest {
	public static void main(String[] args) {
		Player player = new Player(300,300,Frame.window_width,Frame.window_height);
		Background bg = new Background(200);
		
		Frame f = new Frame(player,bg);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(Frame.window_width,Frame.window_height);
		f.setVisible(true);
		f.setResizable(false);
		
		//Frameberechnung
		long lastFrame = System.currentTimeMillis();
		
		while(true){
			//Frameberechnung
			long thisFrame = System.currentTimeMillis();
			float timeSinceLastFrame = ((float)(thisFrame-lastFrame))/1000f;
			lastFrame=thisFrame;
			player.update(timeSinceLastFrame,f.getUp(),f.getDown(),f.getLeft() ,f.getRight());
			bg.update(timeSinceLastFrame);
			
			f.repaintScreen();
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}