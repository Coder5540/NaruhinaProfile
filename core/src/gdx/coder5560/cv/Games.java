package gdx.coder5560.cv;

import api.viewport.CameraHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import engine.debug.FPSDebugger;
import engine.module.render.RenderSystem;
import engine.module.screens.AbstractGameScreen;
import engine.module.screens.GameCore;
import gdx.coder5560.cv.elements.Button;

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

		AssetManager assetManager = _Parent._AssetSystem.assetManager;
		assetManager.load("packs/ui.pack", TextureAtlas.class);
		assetManager.finishLoading();
	}

	boolean initial = false;

	public void initial(AssetManager assetManager) {
		initial = true;
		TextureAtlas atlas = assetManager.get("packs/ui.pack",
				TextureAtlas.class);

		Button button = new Button();
		NinePatch ninePatch = new NinePatch(
				atlas.findRegion("ninepatch_outline"));
		button.setPosition(100, 100);
		button.buildText("Button").buildFontColor(Color.WHITE)
				.buildBackground(ninePatch).buildOnclick(new Runnable() {

					@Override
					public void run() {
						System.out.println("clicked on me");
					}
				}, 1.2f);
		
		_Engine.addActor(button);

		Image image = new Image(new NinePatch(ninePatch));
		image.setPosition(200, 200);
		image.setColor(Color.GRAY);
		_Engine.addActor(image);
	}

	@Override
	public void resize(int width, int height) {
		_ViewportSystem.onGameResize(width, height);
	}

	@Override
	public void update(float delta) {
		_Parent._AssetSystem.onUpdate(delta);
		if (initial == false && !_Parent._AssetSystem.isLoading()) {
			initial(_Parent._AssetSystem.assetManager);
		}
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

	@Override
	public void pause() {
		super.pause();
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
