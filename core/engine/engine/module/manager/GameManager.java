package engine.module.manager;

public class GameManager {
	private INetworkManager _NetworkManager;
	
	public GameManager() {
		super();
	}


	public void onCreate(Object object) {
		
	}


	public INetworkManager getNetworkManager() {
		return _NetworkManager;
	}

	public void setNetworkManager(INetworkManager _NetworkManager) {
		this._NetworkManager = _NetworkManager;
	}


	
}
