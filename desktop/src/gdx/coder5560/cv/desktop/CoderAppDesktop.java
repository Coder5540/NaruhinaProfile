package gdx.coder5560.cv.desktop;

import naruhina.toeica.ToeicAScreen;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import engine.common.R;
import engine.loading.LoadingScreen;
import engine.module.screens.GameCore;
import engine.module.screens.ScreenTransitionFade;

public class CoderAppDesktop {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		GameCore game = new GameCore() {
			@Override
			public void create() {
				super.create();
//				setScreen(new Games(this));
				LoadingScreen loadingScreen = new LoadingScreen(this, new ToeicAScreen(this), ScreenTransitionFade.init(1f));
				setScreen(loadingScreen);
				
//				setScreen(new ToeicAScreen(this));
			}
		};
		config.width = R.SCREEN_WIDTH;
		config.height = R.SCREEN_HEIGHT;
		config.title = "Coder 5560";
		new LwjglApplication(game, config);
	}
}
