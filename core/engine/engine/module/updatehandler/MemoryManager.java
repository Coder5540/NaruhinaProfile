package engine.module.updatehandler;

import com.badlogic.gdx.Gdx;

public class MemoryManager implements IUpdate {

	float count = 0;
	long last_mem = Gdx.app.getJavaHeap() / 1024;


	private boolean ignoreUpdate = false;
	private float time;
	private float STEP = 5f;

	@Override
	public void onUpdate(float delta) {
			long current_mem = Gdx.app.getJavaHeap() / 1024;
			if (current_mem - last_mem >= 2048) {
				System.gc();
				last_mem = Gdx.app.getJavaHeap() / 1024;
			}
	}
	
	@Override
	public boolean ignoreUpdate() {
		return ignoreUpdate;
	}

	@Override
	public void setIgnoreUpdate(boolean ignoreUpdate) {
		this.ignoreUpdate = ignoreUpdate;
	}

	@Override
	public float getDeltaTime() {
		return time;
	}

	@Override
	public void setDeltaTime(float delta) {
		this.time = delta;
	}

	@Override
	public float getStep() {
		return STEP;
	}

	@Override
	public void setStep(float STEP) {
		this.STEP = STEP;
	}

}
