package engine.module.pool;

import engine.common.OnCompleteListener;
import engine.module.updatehandler.UpdateHandlerList;

public class PoolManager {
	public UpdateHandlerList listHandlers;

	public GroupElementPool groupElementPool;

	public TableElementPool tableElementPool;

	public ElementPool elementPool;

	public void onCreate(OnCompleteListener onComplete) {
		// ===========Create pool and then call the event done========

		listHandlers = new UpdateHandlerList();

		groupElementPool = new GroupElementPool();

		tableElementPool = new TableElementPool();

		elementPool = new ElementPool();

		if (onComplete != null)
			onComplete.onComplete("");

	}

	public void onUpdate(float delta) {

	}

	public void onPause() {
		
	}

	public void onDispose() {
	}

}
