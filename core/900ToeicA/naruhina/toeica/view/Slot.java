package naruhina.toeica.view;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import engine.common.OnCompleteListener;
import engine.element.GroupElement;

public class Slot extends GroupElement {
	private boolean isSelected = false;
	public SlotData slotData;

	public Slot() {
		super();
		slotData = new SlotData();
	}

	public Slot loadAsset() {

		return this;
	}

	public Slot buildSize(float width, float height) {
		setSize(width, height);
		return this;
	}

	public Slot buildPosition(float x, float y) {
		this.setPosition(x, y);
		return this;
	}

	public Slot buildPosition(float x, float y, int align) {
		this.setPosition(x, y, align);
		return this;
	}

	public Slot buildComponent() {

		return this;
	}

	public Slot buildState(boolean select) {
		this.isSelected = select;
		return this;
	}

	public boolean isSlected() {
		return isSelected;
	}

	public Slot buildSlotID(int id) {
		slotData.setId(id);
		return this;
	}

	public Slot buildSlotData(String data) {
		slotData.setData(data);
		return this;
	}

	public Slot buildOnClick(final float tapScale,
			final OnCompleteListener onClickListener) {
		clearListeners();
		addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				setOrigin(Align.center);
				setTransform(true);
				addAction(Actions.sequence(
						Actions.touchable(Touchable.disabled),
						Actions.scaleTo(tapScale, tapScale, .05f),
						Actions.delay(.05f), Actions.scaleTo(1f, 1f, .05f),
						Actions.run(new Runnable() {
							@Override
							public void run() {
								if (onClickListener != null) {
									onClickListener.onComplete("");
								}
							}
						}), Actions.touchable(Touchable.enabled)));
				event.cancel();
			}
		});
		return this;
	}

}
