package dev.hyperlisk.nintanks.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import dev.hyperlisk.nintanks.Nintanks;
import dev.hyperlisk.nintanks.util.Reference;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Reference.VIEWPORT_WIDTH;
		config.height = Reference.VIEWPORT_HEIGHT;
		new LwjglApplication(Nintanks.getInstance(), config);
	}
}
