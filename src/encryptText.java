import java.util.ArrayList;

public class encryptText {
	private int[] encKey = { 2, 5, 7, 5, 8, 4, 5, 3, 2, 4, 6, 6, 3, 9, 4, 7, 3, 2, 6, 2, 7, 8, 1, 4, 2, 6, 3, 1, 4, 5, 9, 6 };

	encryptText() {
	}

	public String encrypt(String userKey, String msg) {
		char[] key = generateKey(userKey);
		char[][][] cube = initializeCipher(key);
		int[][] pCipher = getpCipher(cube, msg);
		return getCipher(cube, pCipher);
	}

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

	private int[][] getpCipher(char[][][] cube, String msg) {

		int[][] pCipher = new int[msg.length()][3];
		int i = 0, j = 0, k = 0, m = 0;
		int foundAt[] = { -1, -1, -1 };

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

			int x = 0;
			for (int c = 0; c < 3; c++) {
				pCipher[m][c] = foundAt[x];
				x++;
			}
			x = 0;
		}

		return pCipher;
	}

	private String getCipher(char[][][] cube, int[][] pCipher) {

		StringBuilder stb = new StringBuilder();

		int count = 0;
		ArrayList<Integer> line = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < pCipher.length; j++) {
				line.add(pCipher[j][i]);
			}
		}

		ArrayList<Integer> indices = new ArrayList<>();
		int x=0,y=0,z=0;
		for (int k = 0; k < line.size(); k++) {
			if (count < 3) {
				indices.add(line.get(k));
				count++;
			} else {
				x = indices.remove(0);
				y = indices.remove(0);
				z = indices.remove(0);
				stb.append(cube[x][y][z]);
				k--;
				count = 0;
			}
		}
		x = indices.remove(0);
		y = indices.remove(0);
		z = indices.remove(0);
		stb.append(cube[x][y][z]);

		return stb.toString();

	}

}
