import java.util.ArrayList;

public class decryptText {

	private int[] encKey = { 2, 5, 7, 5, 8, 4, 5, 3, 2, 4, 6, 6, 3, 9, 4, 7, 3, 2, 6, 2, 7, 8, 1, 4, 2, 6, 3, 1, 4, 5, 9, 6 };

	private char[][][] initializeCipher(char key[]) {
		char[][][] cube = new char[5][5][5];
		int u = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					cube[i][j][k] = key[u];
					u++;
				}
			}
		}

		return cube;
	}

	private char[] generateKey(String userKey) {
		char[] key = new char[125];
		ArrayList<Character> atoz = new ArrayList<>();
		for (int i = 0; i < 125; i++) {
			atoz.add((char) (i));
		}

		for (int i = 0; i < 125; i++) {
			int product = userKey.charAt(i%32) * encKey[i%32];
			int index = product % atoz.size();
			key[i] = atoz.remove(index);

		}
		return key;
	}

	private int[][] getpDeCipher(char[][][] cube, String msg) {

		int[][] pDeCipher = new int[msg.length()][3];
		int i = 0, j = 0, k = 0, m = 0;
		int foundAt[] = { -1, -1, -1 };
		ArrayList<Integer> line = new ArrayList<>();

		for (m = 0; m < msg.length(); m++) {
			i = 0;
			while (i < 5) {
				j = 0;
				while (j < 5) {
					k = 0;
					while (k < 5) {
						if (msg.charAt(m) == cube[i][j][k]) {
							foundAt[0] = i;
							foundAt[1] = j;
							foundAt[2] = k;
						}
						k++;
					}
					j++;
				}
				i++;
			}
			line.add(foundAt[0]);
			line.add(foundAt[1]);
			line.add(foundAt[2]);
			

		}
		for (int v = 0; v < 3; v++) {
			for (int w = 0; w < msg.length(); w++) {
				pDeCipher[w][v] = line.remove(0);
			}
		}
		return pDeCipher;
	}

	private String getMsg(char[][][] cube, int[][] pDeCipher) {

		StringBuilder stb = new StringBuilder();

		int count = 0;
		ArrayList<Integer> line = new ArrayList<>();
		for (int i = 0; i < pDeCipher.length; i++) {
			for (int j = 0; j < 3; j++) {
				line.add(pDeCipher[i][j]);
			}
		}

		ArrayList<Integer> indices = new ArrayList<>();
		for (int k = 0; k < line.size(); k++) {
			if (count < 3) {
				indices.add(line.get(k));
				count++;
			} else {
				int x = indices.remove(0);
				int y = indices.remove(0);
				int z = indices.remove(0);
				stb.append(cube[x][y][z]);
				k--;
				count = 0;
			}
		}
		int x = indices.remove(0);
		int y = indices.remove(0);
		int z = indices.remove(0);
		stb.append(cube[x][y][z]);

		return stb.toString();

	}

	public String decrypt(String userKey, String msg) {
		char[] key = generateKey(userKey);
		char[][][] cube = initializeCipher(key);
		int[][] pDeCipher = getpDeCipher(cube, msg);
		return getMsg(cube, pDeCipher);
	}
}
