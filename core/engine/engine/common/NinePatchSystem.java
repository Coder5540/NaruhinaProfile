package engine.common;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;

public class NinePatchSystem {

	public enum NinePatchName {
		NONE, OUTLINE, ROUNDED, SHADOW_BOTTOM, STOCK
	}

	private static NinePatchSystem instance = null;
	private HashMap<NinePatchName, NinePatch> ninePatchs;

	public static NinePatchSystem getInstance() {
		if (instance == null) {
			instance = new NinePatchSystem();
			instance.initial();
		}
		return instance;
	}

	private void initial() {
		ninePatchs = new HashMap<NinePatchName, NinePatch>();
		NinePatch none = new NinePatch(new Texture(
				Gdx.files.internal("ninepatchs/ninepatch_none.png")));
		NinePatch outline = new NinePatch(new Texture(
				Gdx.files.internal("ninepatchs/ninepatch_outline.png")), 6, 6,
				6, 6);
		NinePatch rounded = new NinePatch(new Texture(
				Gdx.files.internal("ninepatchs/ninepatch_rounded.png")), 6, 6,
				6, 6);
		NinePatch shadowButton = new NinePatch(new Texture(
				Gdx.files.internal("ninepatchs/ninepatch_shadow_bottom.png")),
				6, 6, 6, 6);
		NinePatch stock = new NinePatch(new Texture(
				Gdx.files.internal("ninepatchs/ninepatch_stock.png")), 6, 6, 6,
				6);
		ninePatchs.put(NinePatchName.NONE, none);
		ninePatchs.put(NinePatchName.OUTLINE, outline);
		ninePatchs.put(NinePatchName.ROUNDED, rounded);
		ninePatchs.put(NinePatchName.SHADOW_BOTTOM, shadowButton);
		ninePatchs.put(NinePatchName.STOCK, stock);
	}

	public NinePatch getNinePatch(NinePatchName name) {
		return ninePatchs.get(name);
	}
}
