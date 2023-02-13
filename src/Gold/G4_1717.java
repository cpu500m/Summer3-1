package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G4_1717 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i = 0 ; i < n+1 ; i++)
            parent[i] =i;
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int act = Integer.parseInt(st.nextToken());
            if (act == 0)
                merge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            else if (act == 1) {
                boolean res = is_union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                sb.append(res ? "YES\n" : "NO\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static boolean is_union(int a, int b){
        int a_root = find(a);
        int b_root = find(b);
        if(a_root == b_root)
            return true;
        return false;
    }
    // find 함수
    public static int find(int idx) {
        if(parent[idx] == idx)
            return idx;

        return parent[idx] = find(parent[idx]);
    }

    // merge 함수
    // b를 a가 속한 그룹에 넣음.
    public static void merge(int a_idx, int b_idx){
        int a_root = find(a_idx);
        int b_root = find(b_idx);
        if(a_root == b_root) return ;
        parent[b_root] = a_root;
    }
}
