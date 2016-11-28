package com.peter.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.peter.game.GameTest;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GameTest.WIGHT;
		config.height = GameTest.HEIGHT;
		config.title = GameTest.NAME;
		new LwjglApplication(new GameTest(), config);
	}
}
