
import java.io.FileWriter;
import java.io.IOException;

public class createFile {

	void writeTo(String msg, String name) throws IOException {

		FileWriter fw = new FileWriter(name);

		fw.write(msg);
		fw.close();
	}
}
