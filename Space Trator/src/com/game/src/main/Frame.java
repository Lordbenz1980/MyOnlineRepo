package com.game.src.main;

import java.awt.GradientPaint;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame  {
	
	private Screen screen;
	
	public Frame(){
		super("MoveTest");	
	}
	
	private class Screen extends JLabel{
		
		@Override
		protected void paintComponent(Graphics g)	{
			super.paintComponent(g);
		}
		
	}

}
