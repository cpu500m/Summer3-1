package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G5_10026 {

	enum Division{
		IS_NOT_COLOR_WEAK, IS_COLOR_WEAK
	}

	private static final int[] ROW_DIR = {-1, 1, 0, 0};
	private static final int[] COL_DIR = {0, 0, -1, 1};
	private static int n;
	private static boolean[][] visited;

	static class Node {
		int row;
		int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}

		public static boolean isValidCoordinate(int row, int col) {
			return row >= 0 && row <= n - 1 && col >= 0 && col <= n - 1 && !visited[row][col];
		}
		public static boolean validateColor(char color, char targetColor, Division division){
			if(division == Division.IS_NOT_COLOR_WEAK){
				return color == targetColor;
			}
			else{
				if (color == 'R' || color == 'G') {
					return targetColor == 'R' || targetColor == 'G';
				}
				return color == targetColor;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		// 1. 입력 처리
		n = Integer.parseInt(br.readLine());

		char[][] picture = new char[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				picture[i][j] = str.charAt(j);
			}
		}

		// 2. 로직
		int result = 0;
		Queue<Node> queue = new LinkedList<>();

		char currentColor;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 방문 안했다면 큐에넣고 돌림
				if (!visited[i][j]) {
					queue.add(new Node(i, j));
					visited[i][j] = true;
					result++;
					currentColor = picture[i][j];
					while (!queue.isEmpty()) {
						Node node = queue.poll();
						for (int k = 0; k < ROW_DIR.length; k++) {
							int curRow = node.row + ROW_DIR[k];
							int curCol = node.col + COL_DIR[k];
							if (Node.isValidCoordinate(curRow, curCol)) {
								if (Node.validateColor(currentColor,picture[curRow][curCol],
									Division.IS_NOT_COLOR_WEAK)) {
									queue.add(new Node(curRow, curCol));
									visited[curRow][curCol] = true;
								}
							}
						}
					}
				}

			}
		}

		sb.append(result).append(" ");

		// 초기화
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], false);
		}
		result = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 방문 안했다면 큐에넣고 돌림
				if (!visited[i][j]) {
					queue.add(new Node(i, j));
					visited[i][j] = true;
					result++;
					currentColor = picture[i][j];
					while (!queue.isEmpty()) {
						Node node = queue.poll();
						for (int k = 0; k < ROW_DIR.length; k++) {
							int curRow = node.row + ROW_DIR[k];
							int curCol = node.col + COL_DIR[k];
							if (Node.isValidCoordinate(curRow, curCol)) {
								if(Node.validateColor(currentColor,picture[curRow][curCol],
									Division.IS_COLOR_WEAK)){
									queue.add(new Node(curRow, curCol));
									visited[curRow][curCol] = true;
								}
							}
						}
					}
				}
			}
		}
		sb.append(result);
		bw.write(sb.toString());
		bw.flush();
	}
}
