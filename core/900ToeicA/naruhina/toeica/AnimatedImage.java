package naruhina.toeica;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import engine.common.OnCompleteListener;
import engine.common.UpdateSystem;
import engine.module.updatehandler.IUpdate;

public  class AnimatedImage extends Image implements IUpdate{
	
	private Animation animation;
	
	public AnimatedImage(Animation animation) {
		
		this.animation = animation;
	}

	public AnimatedImage(Drawable drawable) {
		super(drawable);
		initialization();
	}

	public AnimatedImage(NinePatch patch) {
		super(patch);
		initialization();
	}

	public AnimatedImage(Texture texture) {
		super(texture);
		initialization();
	}

	public AnimatedImage(TextureRegion region) {
		super(region);
		initialization();
	}

	private void initialization() {
		this.setOrigin(Align.center);
	}

	public AnimatedImage buildSize(float width, float height) {
		this.setSize(width, height);
		return this;
	}

	public AnimatedImage buildPosition(float x, float y) {
		this.setPosition(x, y);
		return this;
	}

	public AnimatedImage buildPosition(float x, float y, int align) {
		this.setPosition(x, y, align);
		return this;
	}

	public AnimatedImage buildOnClick(final float tapScale,
			final OnCompleteListener onClickListener) {
		final float currentScaleX = getScaleX();
		final float currentScaleY = getScaleX();
		final float offset = tapScale - 1;
		clearListeners();
		addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				AnimatedImage.this.clearActions();
				AnimatedImage.this.setOrigin(Align.center);
				AnimatedImage.this.addAction(Actions.sequence(Actions
						.touchable(Touchable.disabled), Actions.scaleTo(
						currentScaleX + offset, currentScaleY + offset, .1f,Interpolation.linear),
						Actions.scaleTo(currentScaleX,
								currentScaleY, .2f, Interpolation.swingOut), Actions
								.run(new Runnable() {
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

	@Override
	public void act(float delta) {
		if(ignoreUpdate) return;
		super.act(delta);
		onUpdate(delta);
	}
	
	public  void process(){
		
	}
	
	private boolean ignoreUpdate = false;
	private float time;
	private float STEP = UpdateSystem.STEP;

	@Override
	public void onUpdate(float delta) {
		time += delta;
		while (time>STEP) {
			time -= STEP;
			process();
		}
	}
	
	@Override
	public boolean ignoreUpdate() {
		return ignoreUpdate;
	}

	@Override
	public void setIgnoreUpdate(boolean ignoreUpdate) {
		this.ignoreUpdate = ignoreUpdate;
	}

	@Override
	public float getDeltaTime() {
		return time;
	}

	@Override
	public void setDeltaTime(float delta) {
		this.time = delta;
	}

	@Override
	public float getStep() {
		return STEP;
	}

	@Override
	public void setStep(float STEP) {
		this.STEP = STEP;
	}

	
	
	
}
