package engine.module.view;

import java.util.Iterator;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

import engine.common.BroadcastHandler;
import engine.common.BroadcastHandler.BroadcastEvent;
import engine.common.OnCompleteListener;
import engine.element.TableElement;
import engine.module.updatehandler.IUpdate;

/**
 * @author Administrator
 * 
 */
public abstract class ViewElement extends TableElement implements IViewElement {

	private IViewController _Controller;

	private ViewName _ViewName;

	private ViewName _ViewParentName;

	private ViewState _ViewState;

	private BroadcastHandler broadcastHandler;

	public Array<IUpdate> handlerList = new Array<IUpdate>();

	public boolean mIgnoreUpdate = false;

	public boolean drawChildren = true;

	public boolean isDoneAction = true;

	public boolean isAutoRemove = true;

	public ViewElement(ViewName viewParentName, IViewController viewController,
			ViewName viewName, Rectangle bound) {
		super();
		this.setBounds(bound.x, bound.y, bound.width, bound.height);
		this._ViewParentName = viewParentName;
		this._Controller = viewController;
		this._ViewName = viewName;
		this.setTransform(true);
		this.setClip(true);
		this.setCullingArea(bound);
		this.setTouchable(Touchable.disabled);
	}

	public IViewElement buildComponent() {
		return this;
	}

	/*
	 * onDone : setTouchable
	 */

	@Override
	public void show(Stage stage, float duration, OnCompleteListener listener) {
		stage.addActor(this);
		this.setVisible(true);
		this.setTouchable(Touchable.enabled);
		this.setIgnoreUpdate(false);
		_Controller.setCurrentView(this);
	}

	/*
	 * onDone : remove or not
	 */
	@Override
	public void hide(float duration, OnCompleteListener listener) {
		this.setVisible(false);
		this.setTouchable(Touchable.disabled);
		this.setIgnoreUpdate(true);
	}

	public void act(float deltatime) {
		if (!mIgnoreUpdate) {
			final Iterator<IUpdate> iterator = handlerList.iterator();
			while (iterator.hasNext()) {
				IUpdate iUpdate = (IUpdate) iterator.next();
				iUpdate.onUpdate(deltatime);
			}
			super.act(deltatime);
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		if (isVisible()) {
			onBeginDraw(batch);
			if (drawChildren)
				super.draw(batch, parentAlpha);
			onEndDraw(batch);
		}
	}

	@Override
	public void onBeginDraw(Batch batch) {

	}

	@Override
	public void onEndDraw(Batch batch) {

	}

	public boolean isDrawChildren() {
		return drawChildren;
	}

	public void setDrawChildren(boolean drawChildren) {
		this.drawChildren = drawChildren;
	}

	public void registerUpdateHandler(IUpdate handler) {
		handlerList.add(handler);
	}

	public boolean unregisterUpdateHandler(IUpdate handler) {
		return handlerList.removeValue(handler, true);
	}

	public boolean isIgnoreUpdate() {
		return mIgnoreUpdate;
	}

	public void setIgnoreUpdate(boolean pIgnoreUpdate) {
		mIgnoreUpdate = pIgnoreUpdate;
	}

	public boolean clearUpdatehandler(IUpdate handler) {
		if (handlerList == null)
			return false;

		return handlerList.removeValue(handler, true);
	}

	public void clearUpdateHandlers() {
		if (handlerList != null) {
			handlerList.clear();
		}
	}

	@Override
	public IViewElement setViewState(ViewState state) {
		this._ViewState = state;
		return this;
	}

	@Override
	public ViewState getViewState() {
		return _ViewState;
	}

	@Override
	public ViewName getParentViewName() {
		return _ViewParentName;
	}

	@Override
	public IViewElement setViewName(ViewName viewName) {
		this._ViewName = viewName;
		return this;
	}

	public IViewElement setAutoRemoveWhenSwitchView(boolean autoRemove) {
		this.isAutoRemove = autoRemove;
		return this;
	}

	public boolean isAutoRemoveWhenSwitchView() {
		return isAutoRemove;
	}

	@Override
	public ViewName getViewName() {
		return _ViewName;
	}

	@Override
	public IViewController getController() {
		return _Controller;
	}

	@Override
	public Rectangle getBound() {
		return new Rectangle(0, 0, getWidth(), getHeight());
	}

	@Override
	public IViewElement setBroadcastHandler(BroadcastHandler broadcastHandler) {
		this.broadcastHandler = broadcastHandler;
		return this;
	}

	@Override
	public void onBroadcastHandler(BroadcastEvent broadcastEvent) {
	}

	@Override
	public IViewElement destroyElement() {
		clearActions();
		clearListeners();
		clearChildren();
		remove();
		return this;
	}

	@Override
	public void back() {
		hide(0, null);
		System.out.println("View Current : " + _ViewName.getName());
		System.out.println("View Parent : " + _ViewParentName.getName());
		getController().getView(_ViewParentName).show(
				getController().getEngine(), 1, null);
	}
}
