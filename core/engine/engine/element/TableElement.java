package engine.element;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.utils.Pool.Poolable;

public class TableElement extends Table implements Poolable {
	public int id = -1;

	public boolean mIgnoreUpdate;

	public boolean drawChildren = true;

	public TableElement() {
		super();
		setUp();
	}

	public TableElement(Skin skin) {
		super(skin);
		setUp();
	}

	private void setUp() {
		setClip(true);
		setTransform(true);
		setOrigin(Align.center);
	}

	public void act(float deltatime) {
		if (!mIgnoreUpdate) {
			super.act(deltatime);
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		if (isVisible()) {
			drawBehind(batch);
			if (drawChildren)
				super.draw(batch, parentAlpha);
			drawInfront(batch);
		}
	}

	public void drawBehind(Batch batch) {
	}

	public void drawInfront(Batch batch) {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isDrawChildren() {
		return drawChildren;
	}

	public void setDrawChildren(boolean drawChildren) {
		this.drawChildren = drawChildren;
	}

	public boolean isIgnoreUpdate() {
		return mIgnoreUpdate;
	}

	public void setIgnoreUpdate(boolean pIgnoreUpdate) {
		mIgnoreUpdate = pIgnoreUpdate;
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
		setUp();
	}
}
