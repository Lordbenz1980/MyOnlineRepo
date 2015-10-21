package com.game.src.main;
import javax.swing.JFrame;

public class MoveTest {
	public static void main(String[] args) {
		Player player = new Player(300,300, 50,800,600);
		
		Frame f = new Frame(player);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 600);
		f.setVisible(true);
		f.setResizable(false);
		
		
		while(true){
			
			player.update(f.getUp(),f.getDown(),f.getLeft() ,f.getRight());
			
			f.repaintScreen();
			
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}