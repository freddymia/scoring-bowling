package scoring.bowling;

public class Main {

	public static void main(String[] args) {
		File file = new File();
		file.read("D:\\work_\\scoreFile.txt");

		Game game = new Game();
		game.run(file.getMap());
	}

}
