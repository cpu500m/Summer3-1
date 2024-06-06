package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class G5_3079 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		/* 입력 처리 */
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[] time = new int[n];
		for (int i = 0; i < n; i++) {
			time[i] = Integer.parseInt(br.readLine());
		}

		/* 로직 */

		long result = parametricSearch(m, time);
		bw.write(String.valueOf(result));
		bw.flush();
	}
	private static long parametricSearch(int m, int[] time){
		long left = 1;
		long right = (long)1e18;
		int len = time.length;

		while (left < right){
			long mid = left + (right - left)/2;
			long cnt = 0;
			for (int t : time) {
				cnt += (mid / t);
				// cnt가 long의 범위를 넘을 수 있으므로 최대 인원 넘으면 그냥 루프 탈출
				if (cnt > 1e9)
					break;
			}
			if(cnt < m){
				left = mid +1;
			} else right = mid;
		}
		return right;
	}
}
