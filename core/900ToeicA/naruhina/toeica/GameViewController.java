package naruhina.toeica;

import naruhina.toeica.view.BackgroundView;
import engine.common.OnComplete;
import engine.common.R;
import engine.element.Engine;
import engine.module.screens.AbstractGameScreen;
import engine.module.screens.GameCore;
import engine.module.view.IViewController;
import engine.module.view.ViewController;
import engine.module.view.ViewName;

public class GameViewController extends ViewController {

	public GameViewController(GameCore _GameCore, Engine _Engine,
			AbstractGameScreen _Screen) {
		super(_GameCore, _Engine, _Screen);
	}

	@Override
	public IViewController buildController() {
		BackgroundView backgroundView = new BackgroundView(ViewName.DEFAULT,
				this, ViewName.BACK_GROUND, R.getGameBound());
		backgroundView.buildComponent();
		addView(backgroundView);
		backgroundView.show(_Engine, 1f, new OnComplete() {
			@Override
			public void onComplete(Object data) {
				
			}
		});
		return this;
	}

	@Override
	public void update(float delta) {
		super.update(delta);

	}

	@Override
	public IViewController onBack() {
		return super.onBack();
	}

}
