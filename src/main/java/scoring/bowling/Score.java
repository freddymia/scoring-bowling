package scoring.bowling;

public class Score {

	private String frame;
	private Pinfall pinfall;
	private String score;

	/**
	 * @return the frame
	 */
	public String getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(String frame) {
		this.frame = frame;
	}

	/**
	 * @return the pinfall
	 */
	public Pinfall getPinfall() {
		return pinfall;
	}

	/**
	 * @param pinfall the pinfall to set
	 */
	public void setPinfall(Pinfall pinfall) {
		this.pinfall = pinfall;
	}

	/**
	 * @return the score
	 */
	public String getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(String score) {
		this.score = score;
	}

}
