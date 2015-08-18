package by.ansgar.catcher2d.main;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import by.ansgar.catcher2d.entity.Background;
import by.ansgar.catcher2d.entity.Enemy;
import by.ansgar.catcher2d.entity.MainHero;
import by.ansgar.catcher2d.util.Input;

public class GamePanel {

	public static final int WIDTH = 750;
	public static final int HEIGHT = 550;

	public static MainHero hero;
	public static Enemy enemy;
	public static List<Enemy> enemys;
	private Input input;
	private Background background;
	Texture heroSprite, enemySprite;

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

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);

		while (!Display.isCloseRequested()) {

			glClear(GL_COLOR_BUFFER_BIT);

			input();
			update();
			draw();

			// background.draw();

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
		}

		// Player
		hero.moving();
	}

	private void draw() {
		// Enemy
		enemySprite.bind();
		for (int i = 0; i < enemys.size(); i++) {
			enemys.get(i).draw();
			enemys.get(i).update();
		}

		// Player
		heroSprite.bind();
		hero.draw();
	}

}
