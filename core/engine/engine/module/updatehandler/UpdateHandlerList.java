package engine.module.updatehandler;

import com.badlogic.gdx.utils.Array;

public class UpdateHandlerList extends Array<IUpdate>{

	public UpdateHandlerList() {

	}

	public UpdateHandlerList(final int pCapacity) {
		super(pCapacity);
	}

	public void onUpdate(final float pSecondsElapsed) {
		final IUpdate[] list = this.items;
		final int handlerCount = list.length;
		for(int i = handlerCount - 1; i >= 0; i--) {
			list[i].onUpdate(pSecondsElapsed);
		}
	}

}
