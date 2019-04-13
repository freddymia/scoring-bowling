package scoring.bowling;

import java.util.List;

public class Bowler {

	private String name;
	private ScoreCard scoreCard;

	public Bowler() {
		this.setName("");
		this.setScoreCard(new ScoreCard());
	}

	public Bowler(String name) {
		this.setName(name);
		this.setScoreCard(new ScoreCard());
	}

	public Bowler(String name, List<String> rolls) {
		this.setName(name);
		this.setScoreCard(new ScoreCard(rolls));
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ScoreCard getScoreCard() {
		return this.scoreCard;
	}

	public void setScoreCard(ScoreCard scoreCard) {
		this.scoreCard = scoreCard;
	}

	public String getOwnershipName() {
		String name = this.getName();
		char lastCharacter = name.charAt(name.length() - 1);
		String ownershipName = name + "'";

		if (lastCharacter != 's') {
			ownershipName += "s";
		}

		return ownershipName;
	}

	public String toString() {
		String output = "\n";

		output += this.getOwnershipName() + " final score: " + this.getScoreCard().getFinalScore();
		output += this.getScoreCard().toString();

		return output;
	}
}
