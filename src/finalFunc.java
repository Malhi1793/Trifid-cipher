
public class finalFunc {

	private String key = "QWERTYUIOPASDFGHJKLZXCVBNMGXBYTS";

	String encode(String fileName, String outputFile, String ImageName, String outputImageName) {

		readFile rFile = new readFile();
		createFile cFile = new createFile();
		String text = null;

		try {
			text = rFile.readText(fileName);
		} catch (Exception e) {
			System.out.println("File not found");
		}

		encryptText enc = new encryptText();
		String s = enc.encrypt(key, text);

		try {
			cFile.writeTo(s, "D:\\MALHI\\Design\\Frosh18\\"+outputFile+".txt");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Steganography steg = new Steganography();
		steg.encode("D:\\MALHI\\Design\\Frosh18", ImageName, "png", outputImageName, key);
		return s;

	}

}
