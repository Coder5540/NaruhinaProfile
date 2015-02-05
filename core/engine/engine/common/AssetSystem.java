package engine.common;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import engine.module.updatehandler.Update;

public class AssetSystem extends Update {
	public AssetManager assetManager = new AssetManager();
	private boolean loaded = false;
	private static AssetSystem instance = null;

	public static AssetSystem getInstance() {
		if (instance == null) {
			instance = new AssetSystem();
		}
		return instance;
	}

	public AssetSystem() {
		super();
		Texture.setAssetManager(assetManager);
	}

	@Override
	public void onUpdate(float delta) {
		if (ignoreUpdate())
			return;
		
		if (!loaded && assetManager.update()) {
			loaded = true;
		}
	}

	public boolean isLoaded() {
		return loaded;
	}

}
