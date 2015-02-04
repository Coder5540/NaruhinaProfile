package engine.loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import engine.common.Loading;
import engine.common.NinePatchSystem;
import engine.common.NinePatchSystem.NinePatchName;
import engine.common.R;
import engine.module.screens.AbstractGameScreen;
import engine.module.screens.GameCore;
import engine.module.screens.ScreenTransition;

public class LoadingScreen extends AbstractGameScreen {
	private AssetManager assetManager;
	private AbstractGameScreen nextScreen;
	private ScreenTransition screenTransition;

	private boolean switchScreen = false;
	private boolean ignoreUpdate = false;
	private boolean isProcessing = false;
	private Loading loading;
	private Runnable onDone = null;

	public LoadingScreen(GameCore game, AbstractGameScreen nextScreen,
			ScreenTransition screenTransition) {
		super(game);
		this.nextScreen = nextScreen;
		this.screenTransition = screenTransition;
	}

	public void load() {
		assetManager.load("packs/ui.pack", TextureAtlas.class);
		assetManager.finishLoading();
		this.isProcessing = true;
		this.onDone = new Runnable() {
			@Override
			public void run() {
				switchScreen();
			}
		};
	}

	@Override
	public void show() {
		super.show();
		this.assetManager = _Parent._AssetSystem.assetManager;
		NinePatch ninePatch = NinePatchSystem.getInstance().getNinePatch(
				NinePatchName.STOCK);
		loading = new Loading();
		loading.buildSize(R.SCREEN_WIDTH / 2, 20)
				.buildPosition(R.SCREEN_WIDTH / 4, 40).buildInside(ninePatch)
				.buildLoadingBarColor(Color.GREEN).setProgress(0f);
		load();
	}

	@Override
	public void resize(int width, int height) {
		_ViewportSystem.onGameResize(width, height);
	}

	@Override
	public void update(float delta) {
		if (ignoreUpdate)
			return;

		if (isProcessing) {
			if (_Parent._AssetSystem.isLoaded()) {
				if (onDone != null) {
					onDone.run();
				}
			}
		}
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		update(delta);

		_BatchUI.setProjectionMatrix(_ViewportSystem.getUiViewport()
				.getCamera().combined);
		_BatchUI.begin();
		onDrawBatchUI(_BatchUI);
		_BatchUI.end();

	}

	float x = R.SCREEN_WIDTH / 4;
	float width = R.SCREEN_WIDTH / 2;

	private void onDrawBatchUI(SpriteBatch batch) {
		loading.setProgress(loading.getProgress() + .01f);
		loading.render(batch, Gdx.graphics.getDeltaTime());
	}

	public void switchScreen() {
		if (!switchScreen) {
			setIgnoreUpdate(true);
			if (screenTransition == null)
				_Parent.setScreen(nextScreen);
			else
				_Parent.setScreen(nextScreen, screenTransition);
			switchScreen = true;
		}
	}

	public boolean isIgnoreUpdate() {
		return ignoreUpdate;
	}

	public void setIgnoreUpdate(boolean ignoreUpdate) {
		this.ignoreUpdate = ignoreUpdate;
	}
}
