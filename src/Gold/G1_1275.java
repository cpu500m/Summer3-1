package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G1_1275 {
    static int N;

    static long[] seg_tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        // 세그먼트 트리 생성
        seg_tree = new long[N << 2];

        // 값 넣어줌
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            update(1, 1, N, i, Long.parseLong(st.nextToken()));

        /// 업데이트 또는 쿼리 처리
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if( r < l ){
                int temp = l;
                l = r;
                r = temp;
            }
            long val = query(1, 1, N, l, r);

            sb.append(val + "\n");
            int idx = Integer.parseInt(st.nextToken());
            val = Long.parseLong(st.nextToken());
            update(1, 1, N, idx,val);
        }
        bw.write(sb.toString());
        bw.flush();
    }


    static void update(int n, int s, int e, int i, long v) {

        if (e < i || i < s) return;
        if (s == e) {
            seg_tree[n] = v;
            return;
        }

        int mid = (s + e) >> 1;
        update(n * 2, s, mid, i,v);
        update(n * 2 | 1, mid + 1, e, i, v);
        seg_tree[n] = seg_tree[n * 2] + seg_tree[n * 2 | 1];
    }

    static long query(int n, int s, int e, int i, int j) {

        if (e < i || j < s) return 0;
        if (i <= s && e <= j) {
            return seg_tree[n];
        }

        int mid = (s + e) >> 1;
        long l = query(n * 2, s, mid, i, j);
        long r = query(n * 2 | 1, mid + 1, e, i, j);
        return l + r;
    }
}
