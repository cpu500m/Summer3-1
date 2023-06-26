package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G1_12837 {
    static long[] seg_tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        seg_tree = new long[N << 2];

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int act = Integer.parseInt(st.nextToken());
            if (act == 1) {
                int idx = Integer.parseInt(st.nextToken());
                long val = Long.parseLong(st.nextToken());
                update(1,1,N,idx,val);
            }
            else{
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                long res = query(1, 1, N, l, r);
                sb.append(String.valueOf(res)+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static void update(int n , int s , int e , int i , long v) {
        // 범위 밖이라면 메서드 리턴
        if(i < s || i > e) return;
        // 단일 구간 업데이트니깐.
        if(s == e){
            seg_tree[n] += v;
            return ;
        }
        int mid = (s + e) >> 1;
        update(n<<1 , s , mid , i,v);
        update(n<<1|1, mid+1,e , i,v);
        seg_tree[n] = seg_tree[n<<1] + seg_tree[n<<1|1];
    }

    static long query(int n, int s, int e, int i, int j) {
        // 구간 밖이라면
        if(j < s || i > e) return 0;

        if (i <= s && e <= j) {
            return seg_tree[n];
        }

        int mid = (s + e) >> 1;
        long l = query(n << 1, s, mid, i, j);
        long r = query(n << 1 | 1, mid + 1, e, i, j);
        return l + r;
    }
}
