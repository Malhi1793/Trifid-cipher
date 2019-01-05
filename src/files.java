import java.util.Scanner;

public class files {

	void encryptFile(String inputFile, String outputFile, String ImageName, String outputImage) {
		finalFunc ff = new finalFunc();

		finalFuncDec dff = new finalFuncDec();

		String cipher = ff.encode("D:\\MALHI\\Design\\Frosh18\\" + inputFile + ".txt", outputFile, ImageName,
				outputImage);
		

	}

	void decryptFile(String outputFile, String keyImage) {
		finalFuncDec dff = new finalFuncDec();
		dff.decode("D:\\MALHI\\Design\\Frosh18\\" + outputFile + ".txt", keyImage);

	}

}
