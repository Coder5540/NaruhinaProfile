package engine.common;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

import engine.module.render.IRender;

public class Loading implements IRender {
	private float width;
	private float height;
	private float x;
	private float y;
	private float progress;
	private Color loadingBarColor;
	private boolean visible = true;
	private NinePatch inside;
	private NinePatch outside;

	public Loading() {
		super();
	}

	public Loading buildSize(float width, float height) {
		this.width = width;
		this.height = height;
		return this;
	}

	public Loading setProgress(float progress) {
		this.progress = MathUtils.clamp(progress, 0, 1);
		return this;
	}

	public Loading buildLoadingBarColor(Color loadingBarColor) {
		this.loadingBarColor = loadingBarColor;
		return this;
	}

	public Loading buildPosition(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}

	public Loading buildInside(NinePatch ninePatch) {
		this.inside = ninePatch;
		return this;
	}

	public Loading setVisible(boolean visible) {
		this.visible = visible;
		return this;
	}

	public float getProgress() {
		return progress;
	}

	@Override
	public void render(SpriteBatch batch, float delta) {
		if (!visible)
			return;

		if (outside != null) {

		}
		if (inside != null) {
			if (loadingBarColor != null)
				inside.setColor(loadingBarColor);
			inside.draw(batch, x, y, width * getProgress(), height);
		}
	}

	@Override
	public int getLayerID() {
		return Integer.MAX_VALUE;
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}
}
