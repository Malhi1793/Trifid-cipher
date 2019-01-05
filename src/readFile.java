import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readFile {

	String readText(String name) throws IOException {

		int ch;
		StringBuilder text = new StringBuilder();

		FileReader fr = null;
		try {
			fr = new FileReader(name);
		} catch (FileNotFoundException fe) {
			System.out.println("File not found");
		}

		while ((ch = fr.read()) != -1)
		text.append((char) ch);

		fr.close();
		
		return text.toString();
	}

}