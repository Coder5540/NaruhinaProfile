package naruhina.toeica;

import com.badlogic.gdx.utils.Array;

public class Data {

	private static Data instance = null;

	public static Data getInstance() {

		if (instance == null) {

			instance = new Data();
			instance.initial();

		}
		return instance;
	}

	private String question;
	private Array<String> answers;

	private void initial() {
		question = "The city's development plan includes the addition of more cycling ...... to our streets.";
		answers = new Array<String>();
		answers.add("notify");
		answers.add("speak");
		answers.add("report");
		answers.add("attend");
	}

	public String getQuestion() {
		return question;
	}

	public Array<String> getAnswers() {
		return answers;
	}

}
