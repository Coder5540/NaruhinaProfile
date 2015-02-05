package engine.common;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import engine.module.updatehandler.IUpdate;

public class AssetSystem implements IUpdate {
	public AssetManager assetManager = new AssetManager();
	private boolean isloading = false;
	private boolean ignoreupdate = false;

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
	public boolean ignoreUpdate() {
		return ignoreupdate;
	}

	@Override
	public void setIgnoreUpdate(boolean ignoreUpdate) {
		this.ignoreupdate = ignoreUpdate;
	}

	@Override
	public void onUpdate(float delta) {
		if (ignoreUpdate())
			return;
		if (isloading && assetManager.update()) {
			isloading = false;
		}
	}

	public void unload(String atlas) {

	}

	public void load(String atlas) {
		isloading = true;
		assetManager.load(atlas, TextureAtlas.class);
	}

	public boolean isLoaded(String atlas) {
		return assetManager.isLoaded(atlas);
	}

	public boolean isLoading() {
		return isloading;
	}

	public boolean isLoaded() {
		return assetManager.update();
	}

}
