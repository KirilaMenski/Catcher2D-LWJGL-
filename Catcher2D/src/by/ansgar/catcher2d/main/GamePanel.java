package by.ansgar.catcher2d.main;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import by.ansgar.catcher2d.entity.Background;
import by.ansgar.catcher2d.entity.MainHero;
import by.ansgar.catcher2d.util.Input;


public class GamePanel {
	
	public static final int WIDTH = 750;
	public static final int HEIGHT = 550;
	
	public static MainHero hero;
	private Input input;
	private Background background;
	Texture heroSprite;
	
	public GamePanel(){
		
		hero = new MainHero();
		input = new Input();
		background = new Background();
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle("Catcher2d");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		heroSprite = hero.loadTexture("heroSprite");
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		
		while(!Display.isCloseRequested()){
			
			
			glClear(GL_COLOR_BUFFER_BIT);
			input.input();
//			background.draw();
			
			heroSprite.bind();
			
			
			hero.draw();
			hero.moving();
			input.moveHero();
			
			
			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
		
	}
	
}
