package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_1434 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] boxes = new int[n];
        int[] books = new int[m];
        boolean[] check = new boolean[n];


        int result = init(br, n, m, boxes, books);

        int cur = 0;
        int turn = 0;
        // 모든 책이 박스에 들어가는 경우만 주어진대
        result = logic(n, m, boxes, books, check, result, cur, turn);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static int init(BufferedReader br, int n, int m, int[] boxes, int[] books) throws IOException {
        StringTokenizer st;
        int ret = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            boxes[i] = cur;
            ret += cur;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }
        return ret;
    }

    private static int logic(int n, int m, int[] boxes, int[] books, boolean[] check, int result, int cur, int turn) {
        while (cur != m){
            // 책이 박스안에 들어가는 경우
            if (boxes[turn] >= books[cur]) {
                // 해당 박스 봉인한경우
                if(check[turn]) {
                    turn = (turn + 1) % n;
                    continue;
                }

                // 박스 가용공간 감소
                boxes[turn] -= books[cur];
                // 낭비공간 줄어듦
                result -= books[cur];
                // 다음 책
                cur++;
            }
            // 박스안에 안들어가는 경우
            else{
                // 박스 봉인
                check[turn] = true;
                // 다음 박스 가져옴
                turn = (turn +1) % n;
            }
        }
        return result;
    }
}
