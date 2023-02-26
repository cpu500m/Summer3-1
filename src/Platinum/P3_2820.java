package Platinum;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P3_2820 {

    static class Node {
        int virtual_idx;
        int end_idx;
        int lazy;
        int salary;
        List<Integer> child;

        Node() {
            child = new ArrayList<>();
            lazy = 0;
        }

    }

    // 노드
    static Node[] nodes;
    // 세그먼트 트리
    static int[] seg_tree;
    static int[] lazy;

    static int mark = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 세그먼트 트리를 생성한다.
        seg_tree = new int[N << 2];
        lazy = new int[N << 2];

        nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++)
            nodes[i] = new Node();
        nodes[1].salary = Integer.parseInt(br.readLine());
        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            // 해당 직원 객체 생성 및 부모의 인접 리스트에 저장.
            nodes[i].salary = Integer.parseInt(st.nextToken());
            nodes[Integer.parseInt(st.nextToken())].child.add(i);
        }
        // 인덱스를 설정한다.
        set_idx(nodes[1]);

        // 세그먼트 트리를 생성한다.
        seg_tree = new int[N << 2];
        lazy = new int[N << 2];

        // 세그먼트 트리의 리프노드 값을 갱신해준다.
        for (int i = 1; i <= N; i++) {
            update(1, 1, N, nodes[i].virtual_idx, nodes[i].virtual_idx, nodes[i].salary);
        }

        // 쿼리 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            char act = st.nextToken().charAt(0);
            // 갱신.
            // virtual_idx +1 부터 end_idx까지의 범위를 갱신하면 된다.
            if (act == 'p') {
                Node cur = nodes[Integer.parseInt(st.nextToken())];
                int s = Integer.parseInt(st.nextToken());
                if (cur.virtual_idx != cur.end_idx)
                    update(1, 1, N, cur.virtual_idx + 1, cur.end_idx, s);
            }
            // 출력
            else {
                Node cur = nodes[Integer.parseInt(st.nextToken())];
                int res = query(1, 1, N, cur.virtual_idx);
                sb.append(res + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    // virtual index를 설정하고 , 영향을 미치는 범위를 DFS를 통해 구한다.
    static void set_idx(Node node) {
        node.virtual_idx = mark;
        for (int idx : node.child) {
            mark++;
            set_idx(nodes[idx]);
        }
        node.end_idx = mark;
    }

    static void update(int n, int s, int e, int i, int j, int d) {
        if (lazy[n] != 0) {
            if (s != e) {
                lazy[n * 2] += lazy[n];
                lazy[n * 2 | 1] += lazy[n];
            }
            seg_tree[n] += lazy[n];
            lazy[n] = 0;
        }
        if (j < s || e < i) return;

        if (i <= s && e <= j) {
            lazy[n] += d;
            if (s != e) {
                lazy[n * 2] += lazy[n];
                lazy[n * 2 | 1] += lazy[n];
            }
            seg_tree[n] += lazy[n];
            lazy[n] = 0;

            return;
        }

        int mid = (s + e) >> 1;
        update(n * 2, s, mid, i, j, d);
        update(n * 2 | 1, mid + 1, e, i, j, d);
    }

    static int query(int n, int s, int e, int i) {
        if (lazy[n] != 0) {
            if (s != e) {
                lazy[n * 2] += lazy[n];
                lazy[n * 2 | 1] += lazy[n];
            }
            seg_tree[n] += lazy[n];
            lazy[n] = 0;
        }
        if (i < s || e < i) return 0;
        if (s == e) {
            seg_tree[n] += lazy[n];
            lazy[n] = 0;

            return seg_tree[n];
        }
        int mid = (s + e) >> 1;

        if (i > mid)
            return query(n * 2 | 1, mid + 1, e, i);
        return query(n * 2, s, mid, i);
    }
}
