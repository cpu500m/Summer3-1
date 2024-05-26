package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class G4_1504 {
	private final static int MAX_VALUE = 500_000_000;
	static class Info {
		int curNode;
		int distance;

		public Info(int distance, int curNode) {
			this.distance = distance;
			this.curNode = curNode;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력 처리
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int e = Integer.parseInt(s[1]);
		Map<Integer, Integer>[] map = new Map[n + 1];
		for (int i = 0; i < n + 1; i++) {
			map[i] = new HashMap<Integer, Integer>();
		}
		for (int i = 0; i < e; i++) {
			String[] str = br.readLine().split(" ");
			int n1 = Integer.parseInt(str[0]);
			int n2 = Integer.parseInt(str[1]);
			int d = Integer.parseInt(str[2]);
			map[n1].put(n2, d);
			map[n2].put(n1, d);
		}
		s = br.readLine().split(" ");
		int n1 = Integer.parseInt(s[0]);
		int n2 = Integer.parseInt(s[1]);

		/* 로직 */
		// result1 : n1을 먼저 거친 경우
		// result2 : n2를 먼저 거친 경우
		int result1 = 0;
		int result2 = 0;

		int[] startsAtFirst = dijkstra(1, map);

		int[] startsAtN1 = dijkstra(n1, map);
		int[] startsAtN2 = dijkstra(n2, map);
		result1 += startsAtFirst[n1];
		result1 += startsAtN1[n2];
		result1 += startsAtN2[n];

		result2 += startsAtFirst[n2];
		result2 += startsAtN2[n1];
		result2 += startsAtN1[n];

		int result = Math.min(result1, result2);
		if(result >= MAX_VALUE)
			bw.write("-1");
		else
			bw.write(String.valueOf(result));
		bw.flush();
	}

	private static int[] dijkstra(int start, Map<Integer, Integer>[] map) {
		// 로직
		int n = map.length;
		PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.distance));
		int[] dist = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			dist[i] = MAX_VALUE;
		}
		dist[start] = 0;
		pq.add(new Info(0, start));
		while (!pq.isEmpty()) {
			Info cur = pq.poll();
			int curDist = cur.distance;
			int curNode = cur.curNode;

			for (Integer key : map[curNode].keySet()) {
				int nextDist = curDist + map[curNode].get(key);
				if(nextDist < dist[key]){
					dist[key] = nextDist;
					pq.add(new Info(nextDist, key));
				}
			}
		}
		return dist;
	}
}
