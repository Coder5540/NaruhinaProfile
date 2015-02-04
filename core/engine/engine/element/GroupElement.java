package engine.element;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Pool.Poolable;

public class GroupElement extends Group implements Poolable {

	public boolean mIgnoreUpdate;

	public boolean drawChildren = true;

	public int id = -1;

	public GroupElement() {
		super();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		if (isVisible()) {
			beginDraw(batch);

			if (drawChildren)
				super.draw(batch, parentAlpha);

			endDraw(batch);
		}
	}

	public void beginDraw(Batch batch) {
	}

	public void endDraw(Batch batch) {
	}

	public boolean isDrawChildren() {
		return drawChildren;
	}

	public void setDrawChildren(boolean drawChildren) {
		this.drawChildren = drawChildren;
	}


	public void act(float deltatime) {
		if (!mIgnoreUpdate) {
			super.act(deltatime);
		}
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
		clearChildren();
		clearActions();
		clearListeners();
		drawChildren = true;
	}
}
