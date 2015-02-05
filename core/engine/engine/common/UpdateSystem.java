package engine.common;

import java.util.Iterator;

import engine.module.render.WildBag;
import engine.module.updatehandler.IUpdate;

public class UpdateSystem {
	private WildBag<IUpdate> bags = new WildBag<IUpdate>();
	private static UpdateSystem instance = null;
	public static final float STEP = 0.015f;
	public float delta;

	private UpdateSystem() {
		super();
	}

	public static UpdateSystem getInstance() {
		if (instance == null) {
			instance = new UpdateSystem();
			instance.initialize();
		}
		return instance;
	}

	private void initialize() {

	}

	private static float accumulate = 0;

	public void update(float delta) {
		accumulate += delta;
		while (accumulate > STEP) {
			setDelta(STEP);
			process();
			accumulate -= STEP;
		}
	}

	public void setDelta(float step) {
		this.delta = step;
	}

	private void process() {
		final Iterator<IUpdate> iterator = bags.iterator();
		while (iterator.hasNext()) {
			IUpdate iUpdate = (IUpdate) iterator.next();
			if (iUpdate == null)
				bags.remove(iUpdate);
			else {
				iUpdate.setDeltaTime(iUpdate.getDeltaTime() + delta);
				if (iUpdate.getDeltaTime() >= iUpdate.getStep()) {
					iUpdate.onUpdate(delta);
					iUpdate.setDeltaTime(iUpdate.getDeltaTime()
							- iUpdate.getStep());
				}
			}
		}
	}

	public void registerUpdateHandler(IUpdate iUpdate) {
		bags.add(iUpdate);
	}

	public void registerUpdateHandler(IUpdate iUpdate, float STEP) {
		iUpdate.setStep(STEP);
		bags.add(iUpdate);
	}

	public synchronized void unRegisterUpdateHandler(IUpdate iUpdate) {
		bags.remove(iUpdate);
	}

}
