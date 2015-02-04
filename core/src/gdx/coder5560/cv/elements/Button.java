package gdx.coder5560.cv.elements;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

public class Button extends TextButton {

	public Button() {
		super("", buildStyle());
	}

	private static TextButtonStyle buildStyle() {
		TextButtonStyle style = new TextButtonStyle();
		style.font = new BitmapFont();
		return style;
	}

	void setup() {
		getStyle().font = new BitmapFont();
	}

	public Button buildText(String text) {
		this.setText(text);
		return this;
	}

	public Button buildFontColor(Color fontColor) {
		getStyle().fontColor = fontColor;
		return this;
	}

	public Button buildDrawableUp(Drawable up) {
		this.getStyle().up = up;
		return this;
	}

	public Button buildDrawableDown(Drawable down) {
		this.getStyle().down = down;
		return this;
	}

	public Button buildBackground(NinePatch ninePatch) {
		setBackground(new NinePatchDrawable(ninePatch));
		getStyle().down = new NinePatchDrawable(new NinePatch(ninePatch,
				new Color(.8f, .8f, .8f, 1f)));
		getStyle().up = new NinePatchDrawable(new NinePatch(ninePatch,
				new Color(1f, 1f, 1f, 1f)));

		float h = getStyle().font.getCapHeight();
		float w = getStyle().font.getBounds(getText()).width;
		setSize((int) (1.2f * w), (int) (1.5f * h));
		return this;
	}

	public Button buildOnclick(final Runnable run, final float tapScale) {
		addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				setOrigin(Align.center);
				setTransform(true);
				clearActions();

				addAction(Actions.sequence(
						Actions.touchable(Touchable.disabled),
						Actions.scaleTo(tapScale, tapScale, .05f),
						Actions.delay(.05f), Actions.scaleTo(1f, 1f, .05f),
						Actions.run(new Runnable() {

							@Override
							public void run() {
								if (run != null)
									run.run();
							}
						}), Actions.touchable(Touchable.enabled)));
			}

		});
		return this;
	}

}
