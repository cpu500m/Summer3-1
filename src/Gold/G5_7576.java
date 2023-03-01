package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_7576 {

    static class Info {
        int row;
        int col;
        int day;

        Info(int row, int col, int day) {
            this.row = row;
            this.col = col;
            this.day = day;
        }
    }

    static int[] r_dir = {-1, 0, 0, 1};
    static int[] c_dir = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 시간 복잡도 조금 늘리기보단 차라리 메모리 조금 더쓰자는 마인드 ( 사실 조건문 걸기 귀찮아서 )
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] box = new int[n + 2][m + 2];
        for (int i = 0; i < n + 2; i++)
            Arrays.fill(box[i], -1);
        boolean[][] is_visited = new boolean[n + 2][m + 2];


        Queue<Info> queue = new LinkedList<>();
        int object = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v != -1) object++;
                if (v == 1)
                    queue.add(new Info(i,j,0));
                box[i][j] = v;
            }
        }

        int cnt = 0;


        while (!queue.isEmpty()) {
            Info cur = queue.poll();
            int row = cur.row;
            int col = cur.col;
            cnt = cur.day;
            // 토마토 익고
            box[row][col] = 1;
            for (int k = 0; k < 4; k++) {
                int cur_row = row + r_dir[k];
                int cur_col = col + c_dir[k];
                // 안 익은 토마토가 인접해있고 방문 안했다면 방문해줘야지
                if (box[cur_row][cur_col] == 0 && !is_visited[cur_row][cur_col]) {
                    queue.add(new Info(cur_row, cur_col, cnt + 1));
                    is_visited[cur_row][cur_col] = true;
                }
            }
        }

        // 다 찾아봐 어차피 최대 백만번임
        int c = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (box[i][j] == 1) c++;

        if (c == object)
            bw.write(String.valueOf(cnt));
        else bw.write("-1");
        bw.flush();
    }
}
