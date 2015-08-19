package by.ansgar.catcher2d.entity;

import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import by.ansgar.catcher2d.main.GamePanel;

public class MainHero implements GameObject {

	private int health;
	private double x;
	private double y;
	private int speed;

	public MainHero() {
		x = GamePanel.WIDTH / 2 - 25;
		y = GamePanel.HEIGHT - 55;
		speed = 2;
	}

	public void update(int dx, int dy) {
		x += dx * speed;
		y += dy * speed;
	}

	public void moving() {
		if (x < 0) x = 0;
		if (x > (GamePanel.WIDTH - 50)) x = GamePanel.WIDTH - 50;
		if (y < 5) y = 5;
		if (y > (GamePanel.HEIGHT - 55)) y = GamePanel.HEIGHT - 55;
	}

	public Texture loadTexture(String key) {
		try {
			return TextureLoader.getTexture("PNG", new FileInputStream(
					new File("res/sprites/hero/man.png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void draw() {

		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2d(x, y);
		glTexCoord2f(1, 0);
		glVertex2d(x + 50, y);
		glTexCoord2f(1, 1);
		glVertex2d(x + 50, y + 50);
		glTexCoord2f(0, 1);
		glVertex2d(x, y + 50);
		glEnd();

	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
