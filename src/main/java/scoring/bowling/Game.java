package scoring.bowling;

import java.util.List;
import java.util.Map;

public class Game {

	private Bowler bowler;

	public void run(Map<String, List<String>> map) {
		if (map != null && !map.isEmpty()) {
			for (Map.Entry<String, List<String>> entry : map.entrySet()) {
				bowler = new Bowler(entry.getKey(), entry.getValue());
				System.out.println(bowler.toString());
			}
		}
	}

	public String toString() {
		String output = "";
		if (bowler != null) {
			output = bowler.toString();
		}
		return output;
	}
}
