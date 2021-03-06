package by.ansgar.catcher2d.entity;

import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import by.ansgar.catcher2d.main.GamePanel;

public class Background implements GameObject {
	
	private double x;
	private double y;
	
	public Background(){
		x = 0;
		y = 0;
	}

	public void update(int dx, int dy) {
		
	}

	public void draw() {
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2d(x, y);
		glTexCoord2f(1, 0);
		glVertex2d(x + GamePanel.WIDTH, y);
		glTexCoord2f(1, 1);
		glVertex2d(x + GamePanel.WIDTH, y + GamePanel.WIDTH);
		glTexCoord2f(0, 1);
		glVertex2d(x, y + GamePanel.WIDTH);
		glEnd();
	}

	public void moving() {
		
	}

	public Texture loadTexture(String key) {
		try {

			return TextureLoader.getTexture("PNG", new FileInputStream(
					new File("res/sprites/background/backgroundImage.png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean intersects(GameObject entity) {
		return false;
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(double x) {
		this.x = x;
		
	}

	@Override
	public void setY(double y) {
		this.y = y;
		
	}

	@Override
	public void setR(double r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getR() {
		// TODO Auto-generated method stub
		return 0;
	}

}
