package scoring.bowling;

import java.util.ArrayList;
import java.util.List;

public class ScoreCard {

	private List<Integer> rolls;
	private List<Frame> frames;

	public ScoreCard() {
	}

	public ScoreCard(List<String> rolls) {
		this.generateIntegerRolls(rolls);
		this.generateFrames();
	}

	public int getFinalScore() {
		List<Frame> frames = this.getFrames();
		int i = frames != null ? frames.size() - 1 : -1;
		int score = 0;

		if (i >= 0) {
			Frame lastFrame = frames.get(i);

			while (lastFrame.isBonus() && i > 1) {
				lastFrame = frames.get(--i);
			}

			score = lastFrame.getScore();
		}

		return score;
	}

	private List<Integer> getRolls() {
		return this.rolls;
	}

	private void setRolls(List<Integer> rolls) {
		this.rolls = rolls;
	}

	private List<Frame> getFrames() {
		return this.frames;
	}

	private void setFrames(List<Frame> frames) {
		this.frames = frames;
	}

	private void generateIntegerRolls(List<String> stringRolls) {
		List<Integer> rolls = new ArrayList<>();
		int i;

		for (i = 0; i < stringRolls.size(); i++) {
			String roll = stringRolls.get(i);
			int rollValue;

			try {
				rollValue = Integer.parseInt(roll);
			} catch (NumberFormatException ex) {
				String rollLowercase = roll.toLowerCase();

				if (rollLowercase == "x") {
					rollValue = 10;
				} else if (rollLowercase == "/") {
					rollValue = rolls.get(i - 1);
				} else {
					System.err.printf(Constants.ROLL_IS_NOT_A_NUMBER + "\n", i + 1);
					return;
				}
			}

			rolls.add(rollValue);
		}

		this.setRolls(rolls);
	}

	private void generateFrames() {
		List<Integer> rolls = this.getRolls();
		List<Frame> frames = new ArrayList<>();
		int i;
		int currentScore = 0;

		if (rolls != null) {
			for (i = 0; i < rolls.size(); i++) {
				int firstRoll = rolls.get(i);
				int secondRoll;
				int frameScore = currentScore + firstRoll;

				Frame frame = new Frame(frames.size() + 1, firstRoll);

				if (firstRoll != 10 && ++i < rolls.size()) {
					secondRoll = rolls.get(i);
					frameScore += secondRoll;
					frame.setSecondRoll(secondRoll);
				}

				if ((frame.isSpare() || frame.isStrike()) && (i + 1 < rolls.size())) {
					frameScore += rolls.get(i + 1);

					if (frame.isStrike() && (i + 2 < rolls.size())) {
						frameScore += rolls.get(i + 2);
					}
				}

				frame.setScore(frameScore);
				currentScore = frameScore;

				frames.add(frame);
			}
		}

		this.setFrames(frames);
	}

	public String toString() {

		List<Frame> frames = this.getFrames();
		String output = "";
		int i;

		if (frames != null && frames.size() > 0) {
			output += "\n\n";
			output += String.format("%-6s %-5s %-5s %-6s\n", "Frame", "PF1", "PF2", "Score");

			for (i = 0; i < frames.size(); i++) {
				output += frames.get(i).toString() + "\n";
			}
		}

		return output;
	}

}
