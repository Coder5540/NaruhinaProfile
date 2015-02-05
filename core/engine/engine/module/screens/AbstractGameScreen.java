package engine.module.screens;

import api.viewport.ViewportSystem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

import engine.common.AssetSystem;
import engine.common.UpdateSystem;
import engine.element.Engine;

public abstract class AbstractGameScreen implements Screen, InputProcessor,
		GestureListener {
	public GameCore _Parent;
	public SpriteBatch _Batch;
	public SpriteBatch _BatchUI;
	public Engine _Engine;
	public ViewportSystem _ViewportSystem;
	private GameState gameState;

	public enum GameState {
		INITIAL, ANIMATING, RUNING, END, NEXT;
	}

	public AbstractGameScreen(GameCore game) {
		this._Parent = game;
	}

	public abstract void resize(int width, int height);

	public void show() {
		_ViewportSystem = new ViewportSystem();
		_Engine = new Engine(_ViewportSystem.getGameViewport());
		_Batch = new SpriteBatch();
		_BatchUI = new SpriteBatch();
		_Parent.inputMultiplexer.clear();
		gameState = GameState.INITIAL;
	}

	public abstract void update(float delta);

	BitmapFont font = new BitmapFont();

	public void render(float delta) {
		{
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			AssetSystem.getInstance().onUpdate(delta);
			UpdateSystem.getInstance().update(delta);
		}
	}

	public void pause() {
	}

	public void hide() {
	}

	public void resume() {
	}

	public InputProcessor getInputProcessor() {
		return _Parent.inputMultiplexer;
	}

	public void dispose() {
		_Engine.dispose();
		_Batch.dispose();
	}

	public void switchScreen(AbstractGameScreen screen,
			ScreenTransition transition) {
		if (transition == null)
			_Parent.setScreen(screen);
		else
			_Parent.setScreen(screen, transition);
	}

	// ===================== input method =======================
	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {

		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public Engine getEngine() {
		return _Engine;
	}

	public void setEngine(Engine engine) {
		this._Engine = engine;
	}

}
