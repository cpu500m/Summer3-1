package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

// 이게 예시를 보면은 결국 10 , 20, 40은 합에 들어갈 수 밖에없음.
// 그러면 이제 두 개를 합쳐서 나오는 숫자가 중요한건데
// 이는 그때그때 가장 작은 수 두개 더한 값이 best 일 수 밖에 없음.
public class G4_1715 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력 처리
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compareTo);
		for (int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		int result = 0;
		while (pq.size() != 1) {
			int sum = pq.poll() + pq.poll();
			result += sum;
			pq.add(sum);
		}
		bw.write(String.valueOf(result));
		bw.flush();
	}
}
