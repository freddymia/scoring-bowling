package scoring.bowling;

import org.junit.Test;

public class FileTest {

	public static void main(String[] args) {
		File file = new File();
		file.read("D:\\work_\\scoreFile.txt");
		file.printData();
	}

	@Test
	public void testReadFile() {
		File file = new File();
		file.read("D:\\work_\\scoreFile.txt");
		file.printData();
	}

	@Test
	public void testGetMap() {
		File file = new File();
		file.read("D:\\work_\\scoreFile.txt");
		file.getMap();
	}

}
