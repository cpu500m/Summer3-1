package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 개똥같은 코드를 짜서 죄송합니다 (_ _)
public class G4_1958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] strings = new String[3];
		for (int i = 0; i < strings.length; i++)
			strings[i] = br.readLine();

		int len1 = strings[0].length() + 1;
		int len2 = strings[1].length() + 1;
		int len3 = strings[2].length() + 1;
		int[][][] arr = new int[len1][len2][len3];
		for (int i = 0; i < len1; i++)
			for (int j = 0; j < len2; j++)
				Arrays.fill(arr[i][j], 0);

		// 그냥 두 문자열 LCS 에서 한차원 추가하면 될듯
		for (int i = 1; i < len1; i++) {
			for (int j = 1; j < len2; j++) {
				for (int k = 1; k < len3; k++) {
					int max = Math.max(arr[i - 1][j][k], arr[i][j - 1][k]);
					max = Math.max(max, arr[i][j][k - 1]);
					arr[i][j][k] = max;
					if (strings[0].charAt(i - 1) == strings[1].charAt(j - 1))
						if (strings[1].charAt(j - 1) == strings[2].charAt(k - 1))
							arr[i][j][k] = arr[i - 1][j - 1][k - 1] + 1;
				}
			}
		}

		bw.write(String.valueOf(arr[len1 - 1][len2 - 1][len3 - 1]));
		bw.flush();
	}
}
