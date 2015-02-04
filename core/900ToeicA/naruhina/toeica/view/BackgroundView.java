package naruhina.toeica.view;

import naruhina.toeica.ViewUpdate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

import engine.common.OnCompleteListener;
import engine.module.view.IViewController;
import engine.module.view.IViewElement;
import engine.module.view.ViewElement;
import engine.module.view.ViewName;

public class BackgroundView extends ViewElement {
	private ViewUpdate viewUpdate;
	private Image background;
	private Image table;

	public BackgroundView(ViewName viewParentName,
			IViewController viewController, ViewName viewName, Rectangle bound) {
		super(viewParentName, viewController, viewName, bound);
	}

	@Override
	public IViewElement buildComponent() {
		super.buildComponent();
		{
			Texture txtBackground = new Texture(
					Gdx.files.internal("toeic/textures/background.jpg"));
			background = new Image(txtBackground);
			background.setSize(getWidth(), getHeight());
			background.setOrigin(Align.center);
			background.setTouchable(Touchable.disabled);
		}
		
		{
			Texture txtTable = new Texture(
					Gdx.files.internal("toeic/textures/table.png"));
			table = new Image(txtTable);
			table.setSize(getWidth(), getHeight()/2);
			table.setOrigin(Align.center);
			table.setTouchable(Touchable.disabled);
		}

		{
			addActor(background);
			addActor(table);

		}

		viewUpdate = new ViewUpdate() {
			@Override
			public void onUpdate(float delta) {

			}
		};
		registerUpdateHandler(viewUpdate);
		return this;
	}

	@Override
	public void show(Stage stage, float duration, OnCompleteListener listener) {
		super.show(stage, duration, listener);
	}

	@Override
	public void hide(float duration, OnCompleteListener listener) {
		super.hide(duration, listener);
	}

	@Override
	public void back() {
		super.back();
	}
}
