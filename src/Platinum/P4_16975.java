package Platinum;

import java.io.*;
import java.util.StringTokenizer;

public class P4_16975 {
    static int N;

    static long[] seg_tree;
    static long[] lazy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        // 세그먼트 트리 생성
        seg_tree = new long[N << 2];
        lazy = new long[N << 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            update(1, 1, N, i, i, Long.parseLong(st.nextToken()));

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int act = Integer.parseInt(st.nextToken());
            if (act == 1) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                long diff = Long.parseLong(st.nextToken());
                update(1, 1, N, l, r, diff);
            } else {
                int idx = Integer.parseInt(st.nextToken());
                long val = query(1, 1, N, idx);
                sb.append(val + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }


    // update. lazy에만 값을 넣어둔다.
    static void update(int n, int s, int e, int i, int j, long d) {
        if (lazy[n] != 0) {
            if (s != e) {
                lazy[n * 2] += lazy[n];
                lazy[n * 2 | 1] += lazy[n];
            }
            seg_tree[n] += lazy[n] * (e - s + 1);
            lazy[n] = 0;
        }
        if (e < i || j < s) return;
        if (i <= s && e <= j) {
            lazy[n] += d;
            if (s != e) {
                lazy[n * 2] += lazy[n];
                lazy[n * 2 | 1] += lazy[n];
            }
            seg_tree[n] += lazy[n] * (e - s + 1);
            lazy[n] = 0;
            return;
        }

        int mid = (s + e) >> 1;
        update(n * 2, s, mid, i, j, d);
        update(n * 2 | 1, mid + 1, e, i, j, d);
        seg_tree[n] = seg_tree[n * 2] + seg_tree[n * 2 | 1];
    }

    // 쿼리 내부에서 값 갱신.
    static long query(int n, int s, int e, int i) {
        // 갱신 할 값이 있었다면 자식들에게 전파시켜주고 값 지워버림
        if (lazy[n] != 0) {
            if (s != e) {
                lazy[n * 2] += lazy[n];
                lazy[n * 2 | 1] += lazy[n];
            }
            seg_tree[n] += lazy[n] * (e - s + 1);
            lazy[n] = 0;
        }
        if (e < i || i < s) return 0;
        if (s == e) {
            return seg_tree[n];
        }

        int mid = (s + e) >> 1;

        if (i <= mid)
            return query(n * 2, s, mid, i);
        return query(n * 2 | 1, mid + 1, e, i);
    }
}
