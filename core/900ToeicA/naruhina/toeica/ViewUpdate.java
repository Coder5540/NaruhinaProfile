package naruhina.toeica;

import engine.module.updatehandler.IUpdate;

public class ViewUpdate implements IUpdate {
	private boolean ignoreUpdate = false;

	@Override
	public boolean ignoreUpdate() {
		return ignoreUpdate;
	}

	@Override
	public void setIgnoreUpdate(boolean ignoreUpdate) {
		this.ignoreUpdate = ignoreUpdate;
	}

	@Override
	public void onUpdate(float delta) {

	}

}
