package engine.debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import engine.common.R;

public class FPSDebugger {

	public FPSDebugger() {
		super();
	}

	public static void debugFPS(SpriteBatch batch, BitmapFont font) {
		int fps = Gdx.graphics.getFramesPerSecond();
		String message = "FPS : " + fps;
		font.draw(batch, message, R.SCREEN_WIDTH
				- font.getBounds(message).width - 20, R.SCREEN_HEIGHT - 20
				- font.getCapHeight());
	}

	private static BitmapFont font;

	public static void debugFPS(SpriteBatch batch) {
		if (font == null)
			font = new BitmapFont();
		int fps = Gdx.graphics.getFramesPerSecond();
		String message = "FPS : " + fps;
		font.draw(batch, message, R.SCREEN_WIDTH
				- font.getBounds(message).width - 20, R.SCREEN_HEIGHT - 20
				- font.getCapHeight());
	}
}
