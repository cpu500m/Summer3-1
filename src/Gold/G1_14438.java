package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G1_14438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] seg_tree = new int[2*N];
        for(int i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        make_segment_tree(arr,seg_tree,N);
        for(int i = 0; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int act = Integer.parseInt(st.nextToken());
            if(act == 1){
                update_value(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), seg_tree, N);
            }
            else if(act == 2){
                long val = query(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),seg_tree,N);
                sb.append(val+"\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
    static void make_segment_tree(int[] arr, int[] seg_tree,int N){
        for(int i = 0 ; i < N ; i++){
            seg_tree[i+N] = arr[i];
        }
        // 부모도 갱신 (왼 + 오 자식)
        for(int i = N-1 ; i > 0 ; i--)
            seg_tree[i] = Math.min(seg_tree[i<<1] , seg_tree[i<<1 | 1]);
    }
    static void update_value(int idx, int value,int[] seg_tree ,int N){
        // 일단 해당 값을 갱신해줘야함
        // 내가 인덱스 0에서부터 시작하는 거로 했으니깐 헷갈리지 않게 그냥 이렇게 쓰자
        int i = idx-1;
        seg_tree[i+=N] = value;

        // 부모를 따라가며 갱신. 루트노드가 1이니깐.. 1까지
        while ( (i>>=1) > 0){
            seg_tree[i] = Math.min(seg_tree[i<<1] , seg_tree[i<<1|1]);
        }
    }
    static int query(int left ,int right , int[] seg_tree, int N){
        // 역시 이것도 헷갈리니깐 걍 이렇게.
        int l = left-1 , r = right;
        int result = Integer.MAX_VALUE;

        // 맨 아래 부터 훑으면서 올라오도록.
        for(l+=N , r+=N ; l != r ; l>>=1 , r>>=1){
            // 왼쪽은 폐구간 이므로 오른쪽 자식을 가리키면 그대로 위로 가면 안된다. 오른자식만 보고 구간을 오른쪽으로 좁힌다.
            if(l % 2 == 1) result= Math.min(result, seg_tree[l++]);
            // 오른쪽은 개구간으로 잡았으므로 오른쪽 자식을 가리키면 왼자식만 보고 구간을 왼쪽으로 좁혀야한다.
            if(r % 2 == 1) result = Math.min(seg_tree[--r], result);
        }
        return result;
    }
}
