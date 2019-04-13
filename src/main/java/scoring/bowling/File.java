package scoring.bowling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class File {

	private List<Input> docInput;

	public File() {
		this.docInput = null;
	}

	public void read(String path) {

		try {

			FileReader fileReader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = null;
			int index = 1;

			List<Input> docInput = new ArrayList<>();

			while ((line = bufferedReader.readLine()) != null) {
				Input input = this.processLine(line, index);
				docInput.add(input);
				index++;
			}

			this.setDocInput(docInput);

			bufferedReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file '" + path + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + path + "'");
		}

	}

	private Input processLine(String line, int index) {

		Input input = null;

		if (line != null) {

			String[] data = line.trim().split(" ");

			// Error
			if (data.length > 2) {
				System.err.println("There is an error in the line :" + index + "\n" + line);
				System.exit(0);
			}

			input = new Input();
			input.setPlayer(data[0]);
			input.setChance(data[1]);

		}

		return input;
	}

	public void printData() {
		if (this.docInput != null) {
			for (Input input : docInput) {
				System.out.println("player: " + input.getPlayer() + " chance: " + input.getChance());
			}

		}
	}

	public Map<String, List<String>> getMap() {

		Map<String, List<String>> scoreMap = new HashMap<>();

		if (this.docInput != null) {
			for (Input input : docInput) {
				if (!scoreMap.containsKey(input.getPlayer())) {
					List<String> chances = new ArrayList<>();
					chances.add(input.getChance());
					scoreMap.put(input.getPlayer(), chances);
				} else {
					scoreMap.get(input.getPlayer()).add(input.getChance());
				}
			}
		}

		this.printMap(scoreMap);
		return scoreMap;
	}

	private void printMap(Map<String, List<String>> scoreMap) {
		for (Map.Entry<String, List<String>> entry : scoreMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue().toString());
		}
	}

	/**
	 * @return the docInput
	 */
	public List<Input> getDocInput() {
		return docInput;
	}

	/**
	 * @param docInput the docInput to set
	 */
	private void setDocInput(List<Input> docInput) {
		this.docInput = docInput;
	}

}
