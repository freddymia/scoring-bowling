package scoring.bowling;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String path = enterPathMessage();

		if (path == null) {
			path = "scoreFile.txt"; // default file
		}
		File file = new File();
		file.read(path);

		Game game = new Game();
		game.run(file.getMap());
	}

	static String enterPathMessage() {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		System.out.flush();

		return scanner.nextLine();
	}

}
