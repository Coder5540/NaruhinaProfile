package engine.module.updatehandler;

import engine.common.UpdateSystem;
import engine.module.updatehandler.IUpdate;

public class Update implements IUpdate {
	private boolean ignoreUpdate = false;
	private float time;
	private float STEP = UpdateSystem.STEP;

	@Override
	public void onUpdate(float delta) {

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
