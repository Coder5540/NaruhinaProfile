package engine.element;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;

import engine.module.screens.GameCore;
import engine.module.updatehandler.IUpdate;

public class Engine extends Stage {

	private Array<IUpdate>	listHandler	= new Array<IUpdate>();

	private GameCore				_GameCore;
	
	public Engine(Viewport viewport, Batch batch) {
		super(viewport, batch);
	}

	public Engine(Viewport viewport) {
		super(viewport);
	}

	@Override
	public void act(float delta) {
		updateHandler(delta);
		super.act(delta);
	}

	private void updateHandler(float delta) {
		final Array<IUpdate> runnables = listHandler;
		final int runnableCount = runnables.size;
		for (int i = runnableCount - 1; i >= 0; i--) {
			runnables.get(i).onUpdate(delta);
		}
	}

	public void addHandler(IUpdate handler) {
		listHandler.add(handler);
	}

	public GameCore getGameCore() {
		return _GameCore;
	}

	public void setGameCore(GameCore _GameCore) {
		this._GameCore = _GameCore;
	}

}
