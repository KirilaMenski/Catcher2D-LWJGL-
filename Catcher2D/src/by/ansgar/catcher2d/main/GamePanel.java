package by.ansgar.catcher2d.main;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import by.ansgar.catcher2d.entity.Background;
import by.ansgar.catcher2d.entity.Enemy;
import by.ansgar.catcher2d.entity.GameObject;
import by.ansgar.catcher2d.entity.MainHero;
import by.ansgar.catcher2d.util.Input;

public class GamePanel {

	public static final int WIDTH = 750;
	public static final int HEIGHT = 550;
	
	private long lastFrame;

	public static GameObject hero, enemy;
//	public static MainHero hero;
//	public static Enemy enemy;
	public static List<Enemy> enemys;
	private Input input;
	private Background background;
	Texture heroSprite, enemySprite, backgroundImage;
	public GamePanel() {
		
		hero = new MainHero();
		enemy = new Enemy();
		enemys = new ArrayList<Enemy>();
		input = new Input();
		background = new Background();

		enemys.add(new Enemy());
		

		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle("Catcher2d");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		heroSprite = hero.loadTexture("heroSprite");
		enemySprite = enemy.loadTexture("enemySprite");
		backgroundImage = background.loadTexture("backgroundImage");

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		
		lastFrame = getTime();

		while (!Display.isCloseRequested()) {

			glClear(GL_COLOR_BUFFER_BIT);

			input();
			update();
			draw();

//			System.out.println(getDelta());
			
			Display.update();
			Display.sync(60);

		}

		Display.destroy();

	}

	private void input() {
		// KeyBoarder
		input.input();
		input.moveHero();
	}

	private void update() {
		// Enemy
		for (int i = 0; i < enemys.size(); i++) {
			enemys.get(i).update();
			enemys.get(i).moving();
//			 System.out.println("Hero y =" + (int)hero.getY());
//			 System.out.println("Enemy y =" + (int)enemys.get(i).getY());
//			if ((int)hero.getY() == (int)enemys.get(i).getY() && (int)hero.getX() == (int)enemys.get(i).getX()) {
//				 System.out.println("You are dead!");
//			}
			
			if(enemys.get(i).intersects(hero)){
				System.out.println("You are dead!");
				enemys.remove(i);
				hero.setR(hero.getR() + 0.1);
				System.out.println(hero.getR());
			}
		}

		// Player
		hero.moving();

	}

	private void draw() {
		
		//Background
		backgroundImage.bind();
		background.draw();
		
		// Enemy
		enemySprite.bind();
		for (int i = 0; i < enemys.size(); i++) {
			enemys.get(i).draw();
		}

		// Player
		heroSprite.bind();
		hero.draw();
	}
	
	private long getTime(){
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	private int getDelta(){
		long currentTime = getTime();
		int delta =(int) (currentTime - lastFrame);
		lastFrame = getTime();
		return delta;
	}

}
