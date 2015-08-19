package by.ansgar.catcher2d.entity;

import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import by.ansgar.catcher2d.main.GamePanel;

public class Enemy implements GameObject {

	private double x;
	private double y;
	private double dx;
	private double dy;

	private int speed;

	public Enemy() {
		x = GamePanel.WIDTH / 2 - 50;
		y = 55;
		speed = 3;

		double angle = Math.toRadians(Math.random() * 360);
		dx = (Math.sin(angle) * speed);
		dy = (Math.cos(angle) * speed);
	}

	public void update() {
		// x += dx * speed;
		// y += dy * speed;
		x += dx;
		y += dy;

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

	public void moving() {

		if (x < 0 && dx < 0) dx = -dx;
		if (x > GamePanel.WIDTH - 50 && dx > 0) dx = -dx;
		if (y < 0 && dy < 0) dy = -dy;
		if (y > GamePanel.HEIGHT - 50 && dy > 0) dy = -dy;
	}

	public Texture loadTexture(String key) {
		try {

			return TextureLoader.getTexture("PNG", new FileInputStream(
					new File("res/sprites/enemys/image.png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
