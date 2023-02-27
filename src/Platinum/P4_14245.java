package Platinum;

import java.io.*;
import java.util.StringTokenizer;

public class P4_14245 {
    static long[] seg_tree;
    static int[] lazy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        seg_tree = new long[N << 2];
        lazy = new int[N << 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            update(1, 1, N, i, i, Integer.parseInt(st.nextToken()));

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int act = Integer.parseInt(st.nextToken());
            if (act == 1) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                update(1, 1, N, l + 1, r + 1, k);
            } else {
                int idx = Integer.parseInt(st.nextToken());
                long val = query(1, 1, N, idx+1);
                sb.append(val + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static void update(int n, int s, int e, int i, int j, int d) {
        if (lazy[n] != 0) {
            if (s != e) {
                lazy[n * 2] ^= lazy[n];
                lazy[n * 2 | 1] ^= lazy[n];
            }     else seg_tree[n] ^= lazy[n];
            lazy[n] = 0;
        }
        if (e < i || j < s) return;

        if (i <= s && e <= j) {
            lazy[n] ^= d;
            if (s != e) {
                lazy[n * 2] ^= lazy[n];
                lazy[n * 2 | 1] ^= lazy[n];
            }
            else seg_tree[n] ^= lazy[n];
            lazy[n] = 0;
            return;
        }

        int mid = (s + e) >> 1;

        update(n * 2, s, mid, i, j, d);
        update(n * 2 | 1, mid + 1, e, i, j, d);

    }

    static long query(int n, int s, int e, int i) {
        if (lazy[n] != 0) {
            if (s != e) {
                lazy[n * 2] ^= lazy[n];
                lazy[n * 2 | 1] ^= lazy[n];
            }  else seg_tree[n] ^= lazy[n];
            lazy[n] = 0;
        }
        if (e < i || i < s) return 0;

        if (s == e) {
            seg_tree[n] ^= lazy[n];
            lazy[n] = 0;
            return seg_tree[n];
        }

        int mid = (s + e) >> 1;

        if(i <= mid)
            return query(n * 2, s, mid, i);
        return query(n * 2 | 1, mid + 1, e, i);
    }
}
