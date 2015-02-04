package engine.common;

import com.badlogic.gdx.math.Rectangle;

public class R {
	public static int SCREEN_WIDTH = 800;
	public static int SCREEN_HEIGHT = 480;

	public static Rectangle getGameBound() {
		return new Rectangle(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
	}
}
