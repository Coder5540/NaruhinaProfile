package engine.module.updatehandler;

public interface IUpdate {

	public boolean ignoreUpdate();

	public void setIgnoreUpdate(boolean ignoreUpdate);

	public float getDeltaTime();
	
	public void setDeltaTime(float delta);
	
	/* return the time determine when it will be process */
	public float getStep();
	
	public void setStep(float STEP);
	
	public void onUpdate(float delta);

	
}
