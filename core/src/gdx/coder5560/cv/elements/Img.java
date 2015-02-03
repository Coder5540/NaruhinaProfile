package gdx.coder5560.cv.elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import engine.module.render.IRender;
import engine.module.render.RenderSystem.Layer;

public class Img extends Sprite implements IRender {
	public Layer layer;

	public Img(Layer layer) {
		super();
		this.layer = layer;
	}

	public Img(Texture texture, Layer layer) {
		super(texture);
		this.layer = layer;
	}

	public Img(TextureRegion region, Layer layer) {
		super(region);
		this.layer = layer;
	}

	@Override
	public void render(SpriteBatch batch, float delta) {
		draw(batch);
	}

	@Override
	public int getLayerID() {
		return layer.ordinal();
	}

}
