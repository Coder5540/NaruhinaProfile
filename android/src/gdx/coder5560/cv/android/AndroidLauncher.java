package gdx.coder5560.cv.android;

import naruhina.toeica.ToeicAScreen;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import engine.module.screens.GameCore;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useAccelerometer = false;
		config.useCompass = false;
		GameCore gameCore = new GameCore() {
			@Override
			public void create() {
				super.create();
				setScreen(new ToeicAScreen(this));
			}
		};
		initialize(gameCore, config);
	}
}
