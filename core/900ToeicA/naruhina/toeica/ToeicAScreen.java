package naruhina.toeica;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import engine.debug.FPSDebugger;
import engine.module.screens.AbstractGameScreen;
import engine.module.screens.GameCore;

public class ToeicAScreen extends AbstractGameScreen {
	GameViewController gameViewController;

	public ToeicAScreen(GameCore game) {
		super(game);
	}

	@Override
	public void show() {
		super.show();
		gameViewController = new GameViewController(_Parent, _Engine, this);
		gameViewController.buildController();
		_Parent.inputMultiplexer.addProcessor(_Engine);
		Gdx.input.setInputProcessor(getInputProcessor());
	}

	@Override
	public void resize(int width, int height) {
		_ViewportSystem.onGameResize(width, height);
	}

	@Override
	public void update(float delta) {
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		_Engine.act(delta);
		_Engine.draw();

		_BatchUI.setProjectionMatrix(_ViewportSystem.getUiViewport()
				.getCamera().combined);

		_BatchUI.begin();
		onDrawUI(_BatchUI);
		_BatchUI.end();
	}

	private void onDrawUI(SpriteBatch batch) {
		FPSDebugger.debugFPS(batch);
	}

}
