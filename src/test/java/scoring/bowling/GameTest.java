package scoring.bowling;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class GameTest {

	@Test
	public void testRun() {
		Game game = new Game();
		Map<String, List<String>> map = new HashMap<>();
//		map.put("Jeff", Arrays.asList("10", "7", "3", "9", "0", "10", "0", "8", "8", "2", "0", "6", "10", "10", "10",
//				"8", "1"));

		map.put("John", Arrays.asList("3", "7", "6", "3", "10", "8", "1", "10", "10", "9", "0", "7", "3", "4", "4",
				"10", "9", "0"));

		game.run(map);
		System.out.println(game);
	}

}
