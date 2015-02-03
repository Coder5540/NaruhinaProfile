package gdx.coder5560.cv;

import api.viewport.CameraHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.MathUtils;

import engine.common.R;
import engine.debug.FPSDebugger;
import engine.module.render.RenderSystem;
import engine.module.render.RenderSystem.Layer;
import engine.module.screens.AbstractGameScreen;
import engine.module.screens.GameCore;
import gdx.coder5560.cv.elements.Img;

public class Games extends AbstractGameScreen {
	CameraHandler cameraHandler;
	public RenderSystem renderSystem;

	public Games(GameCore game) {
		super(game);
	}

	@Override
	public void show() {
		super.show();
		renderSystem = new RenderSystem();
		cameraHandler = new CameraHandler(_ViewportSystem.getGameCamera());
		cameraHandler.setBlock(false);
		_Parent.inputMultiplexer
				.addProcessor(new GestureDetector(cameraHandler));
		_Parent.inputMultiplexer.addProcessor(new GestureDetector(this));
		_Parent.inputMultiplexer.addProcessor(this);
		_Parent.inputMultiplexer.addProcessor(_Engine);
		Gdx.input.setInputProcessor(getInputProcessor());

		for (int i = 0; i < 100; i++) {
			Img img = new Img(texture, Layer.GAME);
			img.setPosition(MathUtils.random(0, R.SCREEN_WIDTH),
					MathUtils.random(0, R.SCREEN_HEIGHT));
			renderSystem.renders.add(img);
		}
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
		update(delta);
		_Engine.act(delta);
		cameraHandler.onUpdate(delta);
		_ViewportSystem.updateCamera();

		_Engine.draw();
		_Batch.setProjectionMatrix(_ViewportSystem.getGameCamera().combined);
		_Batch.begin();
		onDrawBatch(_Batch);
		_Batch.end();

		_BatchUI.setProjectionMatrix(_ViewportSystem.getUiViewport()
				.getCamera().combined);
		_BatchUI.begin();
		onDrawBatchUI(_BatchUI);
		_BatchUI.end();

	}

	private void onDrawBatchUI(SpriteBatch _BatchUI) {
		FPSDebugger.debugFPS(_BatchUI);
	}

	Texture texture = new Texture(Gdx.files.internal("badlogic.jpg"));

	private void onDrawBatch(SpriteBatch batch) {
		renderSystem.render(batch, Gdx.graphics.getDeltaTime());
		if (texture == null) {
			texture = new Texture(Gdx.files.internal("badlogic.jpg"));
		}
		batch.draw(texture, 240, 200);
	}
}
