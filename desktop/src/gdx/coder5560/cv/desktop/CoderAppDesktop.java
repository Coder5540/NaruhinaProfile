package gdx.coder5560.cv.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import engine.common.R;
import engine.module.screens.GameCore;
import gdx.coder5560.cv.Games;

public class CoderAppDesktop {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		GameCore game = new GameCore() {
			@Override
			public void create() {
				super.create();
				setScreen(new Games(this));
			}
		};
		config.width = R.SCREEN_WIDTH;
		config.height = R.SCREEN_HEIGHT;
		config.title = "Coder 5560";
		new LwjglApplication(game, config);
	}
}
