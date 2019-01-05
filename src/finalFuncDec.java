
public class finalFuncDec {

	String decode(String fileName, String keyImage) {

		readFile rFile = new readFile();
		createFile cFile = new createFile();
		String cipher = null;

		try {
			cipher = rFile.readText(fileName);
		}

		catch (Exception e) {
			System.out.println(e);
		}

		Steganography steg = new Steganography();
		String key_d = steg.decode("D:\\MALHI\\Design\\Frosh18", keyImage);
		decryptText dec = new decryptText();
		String s = dec.decrypt(key_d, cipher);

		try {
			cFile.writeTo(s, "D:\\MALHI\\Design\\Frosh18\\Decrypted_File.txt");
		} catch (Exception e) {
			System.out.println(e);
		}
		return s;

	}

}
