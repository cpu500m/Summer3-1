// 내일하자 코테 때문에 머리아프다 => 그렇게 내일이 1년이 됐고... ㅋㅋ
package Gold;

import java.io.*;
import java.util.*;

public class G5_13549 {

	public static final int MAX = 100_001;
	public static boolean[] visited;

	static class Info {
		int time;
		int pos;

		public Info(int time, int pos) {
			this.time = time;
			this.pos = pos;
		}

		public static boolean isValidPosition(int position) {
			return 0 <= position && position < MAX && !visited[position];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		visited = new boolean[MAX];

		PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));

		// 시작 상태
		pq.add(new Info(0, n));

		int result = 0;
		while (!pq.isEmpty()) {
			Info cur = pq.poll();
			if (!Info.isValidPosition(cur.pos))
				continue;

			visited[cur.pos] = true;
			// 동생 위치에 도달해다면 끝
			if (cur.pos == k) {
				result = cur.time;
				break;
			}
			pq.add(new Info(cur.time, cur.pos * 2));
			pq.add(new Info(cur.time + 1, cur.pos - 1));
			pq.add(new Info(cur.time + 1, cur.pos + 1));
		}
		bw.write(String.valueOf(result));
		bw.flush();
	}
}
