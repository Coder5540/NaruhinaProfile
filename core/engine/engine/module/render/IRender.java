package engine.module.render;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IRender {

	public void render(SpriteBatch batch, float delta);

	public int getLayerID();

	public float getX();

	public float getY();
}
