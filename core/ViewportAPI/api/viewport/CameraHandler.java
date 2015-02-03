package api.viewport;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import engine.debug.Log;
import engine.module.updatehandler.IUpdate;

public class CameraHandler implements GestureListener, IUpdate {

	private OrthographicCamera camera;
	private boolean isCameraBlock = false;
	private boolean isDoneAction = false;
	private boolean ignoreUpdate = false;
	private Rectangle bound;

	public CameraHandler(OrthographicCamera camera) {
		super();
		this.camera = camera;
	}

	public CameraHandler() {
		super();
	}

	@Override
	public void onUpdate(float delta) {
		if (ignoreUpdate())
			return;
		updateFling(delta);
	}

	@Override
	public boolean ignoreUpdate() {
		return ignoreUpdate;
	}

	@Override
	public void setIgnoreUpdate(boolean ignoreUpdate) {
		this.ignoreUpdate = ignoreUpdate;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public CameraHandler setCamera(OrthographicCamera camera) {
		this.camera = camera;
		return this;
	}

	public Rectangle getBound() {
		return bound;
	}

	public CameraHandler setBound(Rectangle bound) {
		this.bound = bound;
		return this;
	}

	public boolean isCameraBlock() {
		return isCameraBlock;
	}

	public CameraHandler setBlock(boolean block) {
		this.isCameraBlock = block;
		return this;
	}

	public boolean isDoneAction() {
		return isDoneAction;
	}

	public CameraHandler setDoneAction(boolean doneAction) {
		this.isDoneAction = doneAction;
		return this;
	}

	public boolean isCameraAvailable() {
		return camera != null;
	}

	void updateFling(float delta) {
		if (flingTimer > 0) {
			float alpha = flingTimer / flingTime;
			amountX = velocityX * alpha * delta;
			amountY = velocityY * alpha * delta;
			flingTimer -= delta;
			Log.d("Process Fling");
			if (flingTimer <= 0) {
				velocityX = 0;
				velocityY = 0;
				Log.d("Not Move Camera");
			} else {
				camera.position.x -= amountX * camera.zoom;
				camera.position.y += amountY * camera.zoom;
				Log.d("On Move Camera");
				camera.update();
			}
		}
	}

	float flingTimer = 0f;
	float flingTime = .4f;
	float velocityX = 0f;
	float velocityY = 0f;
	float amountX = 0f;
	float amountY = 0f;
	float initialScale = 1;
	boolean canfling = false;
	
	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		if (isCameraBlock() || !isCameraAvailable())
			return false;
		canfling = true;
		flingTimer = 0f;
		velocityX = 0;
		velocityY = 0;
		amountX = 0;
		amountY = 0;
		initialScale = camera.zoom;
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		if (isCameraBlock() || !isCameraAvailable())
			return false;

		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		if (isCameraBlock() || !isCameraAvailable())
			return false;
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		if (isCameraBlock() || !isCameraAvailable())
			return false;
		if (canfling) {
			this.velocityX = velocityX;
			this.velocityY = velocityY;
			this.flingTimer = flingTime;
			Log.d("fling camera");
		}
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		if (isCameraBlock() || !isCameraAvailable())
			return false;
		camera.position.add(-deltaX * camera.zoom, deltaY
				* camera.zoom, 0);
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		if (isCameraBlock() || !isCameraAvailable())
			return false;
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		if (isCameraBlock() || !isCameraAvailable())
			return false;
		float ratio = initialDistance / distance;
		camera.zoom = initialScale * ratio;
		canfling = false;

		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		if (isCameraBlock() || !isCameraAvailable())
			return false;
		return false;
	}

}
