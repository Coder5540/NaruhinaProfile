package engine.common;

public interface BroadcastHandler {

	public enum BroadcastEvent {
		ON_CLICK, ON_BACK
	}

	public void broadcastEvent(BroadcastEvent broadcastEvent);

	public void broadcastEvent(BroadcastEvent broadcastEvent, Object data);

}
