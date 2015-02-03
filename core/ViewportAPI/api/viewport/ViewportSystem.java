package api.viewport;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sun.java_cup.internal.runtime.virtual_parse_stack;

import engine.common.R;

public class ViewportSystem {
	private ShapeRenderer shapeRenderer;
	private OrthographicCamera gameCamera;
	private OrthographicCamera uiCamera;
	private Viewport gameViewport;
	private Viewport uiViewport;

	public ViewportSystem() {
		super();

		gameCamera = new OrthographicCamera(R.SCREEN_WIDTH, R.SCREEN_HEIGHT);
		uiCamera = new OrthographicCamera(R.SCREEN_WIDTH, R.SCREEN_HEIGHT);

		gameViewport = new StretchViewport(R.SCREEN_WIDTH, R.SCREEN_HEIGHT,
				gameCamera);
		uiViewport = new StretchViewport(R.SCREEN_WIDTH, R.SCREEN_HEIGHT,
				uiCamera);
		shapeRenderer = new ShapeRenderer();
	}

	public void onGameResize(int width, int height) {
		gameViewport.update(width, height, true);
		uiViewport.update(width, height, true);
	}

	public Viewport getGameViewport() {
		return gameViewport;
	}

	public void setGameViewport(Viewport gameViewport) {
		this.gameViewport = gameViewport;
	}

	public Viewport getUiViewport() {
		return uiViewport;
	}

	public void setUiViewport(Viewport uiViewport) {
		this.uiViewport = uiViewport;
	}

	public ShapeRenderer getShapeRenderer() {
		return shapeRenderer;
	}

	public void setShapeRenderer(ShapeRenderer shapeRenderer) {
		this.shapeRenderer = shapeRenderer;
	}

	public OrthographicCamera getGameCamera() {
		return gameCamera;
	}

	public void setGameCamera(OrthographicCamera gameCamera) {
		this.gameCamera = gameCamera;
	}

	public void updateCamera() {
		gameViewport.getCamera().update();
		uiViewport.getCamera().update();
	}

}
