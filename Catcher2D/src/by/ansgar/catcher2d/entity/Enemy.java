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

	private int x;
	private int y;

	private int speed;

	public Enemy() {
		x = GamePanel.WIDTH / 2 - 50;
		y = 55;
		speed = 3;
	}

	public void update(int dx, int dy) {
		x += dx * speed;
		y += dy * speed;
	}

	public void draw() {

		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2i(x, y);
		glTexCoord2f(1, 0);
		glVertex2i(x + 50, y);
		glTexCoord2f(1, 1);
		glVertex2i(x + 50, y + 50);
		glTexCoord2f(0, 1);
		glVertex2i(x, y + 50);
		glEnd();

	}

	public void moving() {
		if (x < 0) update(1, 1);
		if (x > (GamePanel.WIDTH - 50)) update(-1, 1);
		if (y < 5) update(1, 1);
		if (y > (GamePanel.HEIGHT - 55)) update(-1, -1);
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
