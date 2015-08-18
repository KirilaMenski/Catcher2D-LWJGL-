package by.ansgar.catcher2d.util;

import java.awt.RenderingHints.Key;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import by.ansgar.catcher2d.entity.Enemy;
import by.ansgar.catcher2d.entity.MainHero;
import by.ansgar.catcher2d.main.GamePanel;

public class Input {

	public void input() {

		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			Display.destroy();
			System.exit(0);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_R)){
			GamePanel.enemys.add(new Enemy());
		}

	}

	public void moveHero() {

		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			GamePanel.hero.update(-1, 0);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			GamePanel.hero.update(1, 0);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			GamePanel.hero.update(0, -1);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			GamePanel.hero.update(0, 1);
		}
	}

}
