package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 1. 선후 관계일때 ex) 1->2 , 2->3
// 2. 여러 작업의 전처리 작업에 포함될 때 ex) 1->2 , 1->3
// 전체 시간 기록 배열을 따로 만들어서 더 큰 값을 가져간다면 될듯
public class G4_2056 {

	static class Node {

		int time;
		List<Integer> outNode;
		int inNodeCount;

		Node(int time) {
			this.time = time;
			inNodeCount = 0;
			outNode = new ArrayList<>();
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력 처리
		int n = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[n];
		int[] totalTime = new int[n];

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			nodes[i] = new Node(Integer.parseInt(line[0]));
			totalTime[i] = nodes[i].time;
			for (int j = 2; j < line.length; j++) {
				int curNodeIndex = Integer.parseInt(line[j]) - 1;
				nodes[curNodeIndex].outNode.add(i);
				nodes[i].inNodeCount++;
			}
		}

		// 위상정렬
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if(nodes[i].inNodeCount == 0)
				queue.add(i);
		}

		while (!queue.isEmpty()) {
			int nodeIndex = queue.poll();

			for (int i = 0; i < nodes[nodeIndex].outNode.size(); i++) {
				int curNodeIndex = nodes[nodeIndex].outNode.get(i);
				totalTime[curNodeIndex] = Math.max(totalTime[curNodeIndex]
					, totalTime[nodeIndex] + nodes[curNodeIndex].time);
				nodes[curNodeIndex].inNodeCount--;

				if(nodes[curNodeIndex].inNodeCount == 0) queue.add(curNodeIndex);
			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			result = Math.max(result, totalTime[i]);
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
