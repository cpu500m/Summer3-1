package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class G4_17951 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		/* 입력 처리 */
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int[] scores = new int[n];
		input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(input[i]);
		}

		int result = search(k, scores);
		bw.write(String.valueOf(result));
		bw.flush();
	}

	private static int search(int k, int[] scores) {
		int scoreLength = scores.length;
		int left = 0;
		int right = (int)(1e5 * 20);

		while (left <= right) {
			int mid = left + (right - left) / 2;
			int currentGroupSum = 0;
			int groupCount = 0;
			for (int score : scores) {
				currentGroupSum += score;
				if (currentGroupSum >= mid) {
					groupCount++;
					currentGroupSum = 0;
				}
			}
			if(groupCount < k)
				right = mid-1;
			else left = mid+1;
		}
		return right;
	}
}
