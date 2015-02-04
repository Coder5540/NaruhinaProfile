package gdx.coder5560.cv.elements;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
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
		return this;
	}

	public Button buildOnclick(final Runnable run, final float tapScale) {
		addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				setOrigin(Align.center);
				clearActions();
				addAction(Actions.sequence(
						Actions.scaleTo(tapScale, tapScale, .1f),
						Actions.delay(.05f), Actions.scaleTo(1f, 1f, .1f),
						Actions.run(new Runnable() {

							@Override
							public void run() {
								if (run != null)
									run.run();
							}
						})));
			}

		});
		return this;
	}

}
