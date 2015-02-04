package engine.module.view;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;

import engine.common.BroadcastHandler;
import engine.common.OnCompleteListener;
import engine.common.BroadcastHandler.BroadcastEvent;
import engine.module.updatehandler.IUpdate;

public interface IViewElement {

	public enum ViewState {
		SHOW, HIDE
	}

	public IViewElement buildComponent();

	public void show(Stage stage, float duration,
			final OnCompleteListener listener);

	public void hide(float duration, final OnCompleteListener listener);

	public void act(float deltatime);

	public void onBeginDraw(Batch batch);

	public void onEndDraw(Batch batch);

	public void registerUpdateHandler(IUpdate handler);

	public boolean unregisterUpdateHandler(IUpdate handler);

	public boolean clearUpdatehandler(IUpdate handler);

	public void clearUpdateHandlers();

	public IViewElement setViewState(ViewState state);

	public ViewState getViewState();

	public boolean isIgnoreUpdate();

	public void setIgnoreUpdate(boolean pIgnoreUpdate);

	public IViewElement setViewName(ViewName viewName);

	public ViewName getParentViewName();

	public ViewName getViewName();

	public IViewElement setAutoRemoveWhenSwitchView(boolean autoRemove);

	public boolean isAutoRemoveWhenSwitchView();

	public IViewController getController();

	public void setPosition(float x, float y);

	public Rectangle getBound();

	public IViewElement setBroadcastHandler(BroadcastHandler broadcastHandler);

	public void onBroadcastHandler(BroadcastEvent broadcastEvent);

	public IViewElement destroyElement();

	public void back();
}
