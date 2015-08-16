package by.ansgar.catcher2d.main;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


public class GamePanel {
	
	public static final int WIDTH = 750;
	public static final int HEIGHT = 550;
	
	
	public GamePanel(){
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle("Catcher2d");
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		
		while(!Display.isCloseRequested()){
			
			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
		
	}
	
}
