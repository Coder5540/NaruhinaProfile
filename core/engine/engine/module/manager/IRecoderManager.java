package engine.module.manager;

public interface IRecoderManager {

	public void startRecording();

	public void stopRecording();

	public void saveToFile(String fileName);

	public void reset();
}
