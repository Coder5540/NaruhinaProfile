package engine.module.view;

import engine.element.Engine;
import engine.module.screens.AbstractGameScreen;
import engine.module.screens.GameCore;

public interface IViewController {

	public void update(float delta);

	public GameCore getGameCore();

	public Engine getEngine();

	public AbstractGameScreen getScreen();
	
	public boolean isContainView(ViewName name);

	public IViewElement getView(ViewName name);

	public IViewController removeView(ViewName name);

	public IViewController addView(IViewElement view);

	public IViewElement getCurrentView();

	public IViewController setCurrentView(IViewElement view);

	public IViewController onBack();

}
