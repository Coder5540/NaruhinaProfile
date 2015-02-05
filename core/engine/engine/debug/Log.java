package engine.debug;

public class Log {

	public final static boolean DEBUG_ENABLE = true;

	public static void s(String message) {
		if (DEBUG_ENABLE) {
			System.out.println("SEND : " + message);
		}
	}

	public static void r(String message) {
		if (DEBUG_ENABLE) {
			System.out.println("RECEIVED : " + message);
		}
	}

	public static void r(String title, String message) {
		if (DEBUG_ENABLE) {
			System.out.println("RECEIVED " + title + " : " + message);
		}
	}

	public static void d(String message) {
		if (DEBUG_ENABLE) {
			System.out.println("DEBUG : " + message);
		}
	}

	public static void d(String title, String message) {
		if (DEBUG_ENABLE) {
			System.out.println("DEBUG : " + title + " : " + message);
		}
	}

	public static void d(Class<?> t, String message) {
		if (DEBUG_ENABLE) {
			System.out
					.println("DEBUG : " + t.getSimpleName() + " : " + message);
		}
	}
	public static void d(Object o, String message) {
		if (DEBUG_ENABLE) {
			System.out
			.println(o.getClass().getSimpleName() + " : " + message);
		}
	}
//	public <T extends Log>  void dsda(Class<T> t, String message) {
//		if (DEBUG_ENABLE) {
//			System.out
//			.println("DEBUG : " + t.getSimpleName() + " : " + message);
//		}
//	}

	public static void d(String title, int value) {
		d(title, value + "");
	}

	public static void l(String message) {
		if (DEBUG_ENABLE) {
			System.out.println("LOG : " + message);
		}
	}
}
