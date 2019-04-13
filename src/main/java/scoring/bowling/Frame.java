package scoring.bowling;

public class Frame {

	private String number;

	private int firstRoll;
	private int secondRoll;

	private int score;

	private boolean isBonus;
	private boolean isStrike;
	private boolean isSpare;

	public Frame() {
		this.setNumber("");
	}

	public Frame(int number) {
		this.setNumber(this.calculateNumber(number));
	}

	public Frame(int number, int firstRoll) {
		this(number);
		this.setFirstRoll(firstRoll);
		this.setSecondRoll(-1);
	}

	public Frame(int frameNumber, int firstRoll, int secondRoll) {
		this(frameNumber, firstRoll);
		this.setSecondRoll(secondRoll);
	}

	private String calculateNumber(int frameNumber) {
		String frameNumberOutput = Integer.toString(frameNumber);

		if (frameNumber > 10) {
			frameNumberOutput = "*";
			this.setIsBonus(true);
		}

		return frameNumberOutput;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getFirstRoll() {
		return this.firstRoll;
	}

	public void setFirstRoll(int firstRoll) {
		this.firstRoll = firstRoll;
		this.calculateFrameType();
	}

	public int getSecondRoll() {
		return this.secondRoll;
	}

	public void setSecondRoll(int secondRoll) {
		this.secondRoll = secondRoll;
		this.calculateFrameType();
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isStrike() {
		return this.isStrike;
	}

	private void setIsStrike(boolean isStrike) {
		this.isStrike = isStrike;
	}

	public boolean isSpare() {
		return this.isSpare;
	}

	private void setIsSpare(boolean isSpare) {
		this.isSpare = isSpare;
	}

	public boolean isBonus() {
		return this.isBonus;
	}

	private void setIsBonus(boolean isBonus) {
		this.isBonus = isBonus;
	}

	private void calculateFrameType() {
		if (this.getFirstRoll() == 10) {
			this.setIsStrike(true);
		} else if (this.getFirstRoll() + this.getSecondRoll() == 10) {
			this.setIsSpare(true);
		} else {
			this.setIsStrike(false);
			this.setIsSpare(false);
		}
	}

	private String getRollDisplay(boolean isFirstRoll) {
		return isFirstRoll ? getFirstRollDisplay() : getSecondRollDisplay();
	}

	private String getFirstRollDisplay() {
		return this.isStrike() ? "X" : Integer.toString(this.getFirstRoll());
	}

	private String getSecondRollDisplay() {
		String display = "";
		int secondRoll = this.getSecondRoll();

		if (this.isStrike() || secondRoll == -1) {
			display = " ";
		} else if (this.isSpare()) {
			display = "/";
		} else if (secondRoll == 0) {
			display = "-";
		} else {
			display = Integer.toString(secondRoll);
		}

		return display;
	}

	public String toString() {

		return String.format("%2s %6s %6s  %6s", this.getNumber(), this.getRollDisplay(true),
				this.getRollDisplay(false), this.isBonus() ? "" : this.getScore());

	}

}
