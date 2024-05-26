package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Dijkstra 추가 연습
public class S2_18352 {
	static class Node{
		int curNode;
		int curDist;

		public Node(int curNode, int curDist) {
			this.curNode = curNode;
			this.curDist = curDist;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);
		int x = Integer.parseInt(input[3]);

		Map<Integer,Boolean>[] map = new HashMap[n + 1];
		for (int i = 0; i < n + 1; i++) {
			map[i] = new HashMap<>();
		}

		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int s = Integer.parseInt(input[0]);
			int e = Integer.parseInt(input[1]);
			map[s].put(e,true);
		}
		int[] result = dijkstra(x, map);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n + 1; i++) {
			if(result[i] == k)
				sb.append(i).append("\n");
		}
		if(sb.length() == 0)
			sb.append("-1");
		bw.write(sb.toString());
		bw.flush();
	}
	private static int[] dijkstra(int start, Map<Integer,Boolean>[] map) {
		int n = map.length+1;
		int[] dist = new int[n+1];
		for (int i = 0; i < n + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.curDist));
		pq.add(new Node(start,0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int curDist = cur.curDist;
			int curNode = cur.curNode;
			for (Integer next : map[curNode].keySet()) {
				int nextDist = curDist + 1;
				if(dist[next] > nextDist){
					dist[next] = nextDist;
					pq.add(new Node(next, nextDist));
				}
			}
		}

		return dist;
	}
}
