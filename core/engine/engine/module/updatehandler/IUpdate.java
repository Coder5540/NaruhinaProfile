package engine.module.updatehandler;

public interface IUpdate {

	public boolean ignoreUpdate();

	public void setIgnoreUpdate(boolean ignoreUpdate);

	public void onUpdate(float delta);
	
}
