package engine.module.render;

import java.util.Comparator;
import java.util.Iterator;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RenderSystem {
	private Comparator<IRender> comparator = null;

	public WildBag<IRender> renders = null;

	public enum Layer {
		GROUND, UI, GAME;
	}

	public RenderSystem() {
		super();
		renders = new WildBag<IRender>();
		comparator = new Comparator<IRender>() {
			@Override
			public int compare(IRender o1, IRender o2) {
				return o1.getLayerID() - o2.getLayerID();
			}
		};
	}

	public void render(SpriteBatch batch, float delta) {
		renders.sort(comparator);
		final Iterator<IRender> iterator = renders.iterator();
		while (iterator.hasNext()) {
			IRender render = iterator.next();
			if (render == null)
				renders.remove(render);
			else
				iterator.next().render(batch, delta);
		}
	}

}
