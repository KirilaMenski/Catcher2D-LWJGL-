package by.ansgar.catcher2d.entity;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.opengl.Texture;

import by.ansgar.catcher2d.main.GamePanel;

public class Background implements GameObject {

	public void update(int dx, int dy) {
		
	}

	public void draw() {
		glColor3f(0.1f, 1.0f, 0.1f);
		glRectf(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
	}

	public void moving() {
		
	}

	public Texture loadTexture(String key) {
		return null;
	}

}
