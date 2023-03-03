package Platinum;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P3_16404 {

    static class Node {
        int score;
        int virtual_idx;
        int end_idx;
        List<Node> child;

        Node() {
            this.score = 0;
            child = new ArrayList<>();
        }

    }

    // 칭찬 점수만 저장하면 됨
    static int[] seg_tree;
    static int[] lazy;
    static Node[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb  =new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        seg_tree = new int[n << 2];
        lazy = new int[n << 2];

        nodes = new Node[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++)
            nodes[i] = new Node();
        //1. 노드 생성
        for (int i = 0; i < n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            if(boss == -1) continue;
            nodes[boss-1].child.add(nodes[i]);
        }

        // 2 . 오일러 경로를 통한 가상 인덱스 생성
        set_idx(nodes[0], 1);

        // 3. 세그먼트 트리 빌드
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int act  =Integer.parseInt(st.nextToken());
            if(act == 1){
                int idx = Integer.parseInt(st.nextToken());
               Node cur = nodes[idx-1];
                update(1,1,n,cur.virtual_idx,cur.end_idx,Integer.parseInt(st.nextToken()));
            }
            else{
                Node cur = nodes[Integer.parseInt(st.nextToken())-1];
                int res = query(1,1,n,cur.virtual_idx,cur.virtual_idx);
                sb.append(res+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    // 오일러 경로를 통한 range 설정
    static int set_idx(Node cur, int v_idx) {
        cur.virtual_idx = v_idx;
        for (Node n : cur.child) {
            v_idx = set_idx(n, v_idx + 1);
        }
        cur.end_idx = v_idx;
        return v_idx;
    }

    static void update(int n, int s, int e, int i, int j, int d) {
        if (lazy[n] != 0) {
            // 전파
            if (s != e) {
                lazy[n * 2] += lazy[n];
                lazy[n * 2 | 1] += lazy[n];
            }
            seg_tree[n] += lazy[n];
            lazy[n] = 0;
        }
        if (e < i || j < s) return;
        if (i <= s && e <= j) {
            lazy[n] += d;
            // 전파
            if (s != e) {
                lazy[n * 2] += lazy[n];
                lazy[n * 2 | 1] += lazy[n];
            }
            seg_tree[n] += lazy[n];
            lazy[n] = 0;
            return ;
        }

        int mid = (s+e)>>1;
        update(n*2,s,mid,i,j,d);
        update(n*2|1,mid+1,e,i,j,d);
        seg_tree[n] = seg_tree[n*2] + seg_tree[n*2|1];
    }

    static int query(int n ,int s, int e ,int i , int j) {
        if (lazy[n] != 0) {
            // 전파
            if (s != e) {
                lazy[n * 2] += lazy[n];
                lazy[n * 2 | 1] += lazy[n];
            }
            seg_tree[n] += lazy[n];
            lazy[n] = 0;
        }
        if (e < i || j < s) return 0;
        if (i <= s && e <= j) {
            // 전파
            if (s != e) {
                lazy[n * 2] += lazy[n];
                lazy[n * 2 | 1] += lazy[n];
            }
            seg_tree[n] += lazy[n];
            lazy[n] = 0;
            return seg_tree[n];
        }

        int mid = (s + e) >> 1;
        int l = query(n * 2, s, mid, i, j);
        int r = query(n * 2 | 1, mid + 1, e, i, j);
        return l + r;
    }
}
