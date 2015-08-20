package by.ansgar.catcher2d.entity;

import org.newdawn.slick.opengl.Texture;

public interface GameObject {

	// public void update(int dx, int dy);

	public void draw();

	public void moving();

	public Texture loadTexture(String key);

	public boolean intersects(GameObject entity);

	public double getX();

	public double getY();

	public void setX(double x);

	public void setY(double y);

}
