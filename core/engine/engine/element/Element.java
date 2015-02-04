package engine.element;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Pool.Poolable;

public class Element extends Actor implements Poolable {

	public boolean mIgnoreUpdate;


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

	public boolean isIgnoreUpdate() {
		return mIgnoreUpdate;
	}

	public void setIgnoreUpdate(boolean pIgnoreUpdate) {
		mIgnoreUpdate = pIgnoreUpdate;
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
		clearActions();
		clearListeners();
	}
}
