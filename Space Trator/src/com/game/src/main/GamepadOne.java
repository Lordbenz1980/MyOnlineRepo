package com.game.src.main;

import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;
import org.lwjgl.LWJGLException;

public class GamepadOne {
	static Controller controller;
	
	public static void init(){
			try {
				Controllers.create();
			} catch (LWJGLException e) {
				e.printStackTrace();
			}
			
			Controllers.poll();
			
			controller=Controllers.getController(13);
			
			controller.setDeadZone(0, 0.3f);
			controller.setDeadZone(1, 0.3f);
			controller.setDeadZone(2, 0.3f);
			controller.setDeadZone(3, 0.3f);
			controller.setDeadZone(4, 0.3f);	
	}

}
