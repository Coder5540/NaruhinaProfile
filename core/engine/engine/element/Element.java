package engine.element;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Pool.Poolable;

import engine.module.updatehandler.IUpdate;
import engine.module.updatehandler.UpdateHandlerList;

public class Element extends Actor implements Poolable {

	public boolean mIgnoreUpdate;

	public UpdateHandlerList handlerList = new UpdateHandlerList(4);

	public int id = -1;

	public Element() {
		super();
	}

	public void draw(Batch batch, float parentAlpha) {
		if (isVisible()) {

			beginDrawActor(batch);

			super.draw(batch, parentAlpha);

			endDrawActor(batch);
		}
	}

	protected void beginDrawActor(Batch batch) {

	}

	protected void endDrawActor(Batch batch) {

	}

	public void registerUpdateHandler(IUpdate handler) {
		handlerList.add(handler);
	}

	public boolean unregisterUpdateHandler(IUpdate handler) {
		return handlerList.removeValue(handler, true);
	}

	public void act(float deltatime) {
		if (!mIgnoreUpdate) {
			handlerList.onUpdate(deltatime);
			super.act(deltatime);
		}
	}

	public boolean isIgnoreUpdate() {
		return mIgnoreUpdate;
	}

	public void setIgnoreUpdate(boolean pIgnoreUpdate) {
		mIgnoreUpdate = pIgnoreUpdate;
	}

	public void clearUpdateHandlers() {
		handlerList.clear();
	}

	public int getID() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void reset() {
		setTouchable(Touchable.disabled);
		setIgnoreUpdate(false);
		setId(-1);
		clearUpdateHandlers();
		clearActions();
		clearListeners();
	}
}
