package scoring.bowling;

import org.junit.Test;

public class FileTest {

	public static void main(String[] args) {
		File file = new File();
		file.read("D:\\work_\\scoreFile.txt");
		// file.printData();
		file.getMap();
	}

	@Test
	public void testReadFile() {
		File file = new File();

	}

}
