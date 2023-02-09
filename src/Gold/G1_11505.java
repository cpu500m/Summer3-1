package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G1_11505 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        for(int i = 0 ; i < N ; i++)
            arr[i] = Long.parseLong(br.readLine());

        long[] seg_tree = new long[2*N];
        // 세그먼트 트리 생성
        make_segment_tree(arr,seg_tree,N);
        for(int i = 0 ; i < M+K ; i++){
            st = new StringTokenizer(br.readLine());
            String act = st.nextToken();
            // 바꾸기
            if(act.equals("1")){
                int idx = Integer.parseInt(st.nextToken());
                long val = Long.parseLong(st.nextToken());
                update(idx,val,seg_tree,N);
            }
            // 곱하기 근데 r이 폐구간이라 알아서 처리하자
            else if(act.equals("2")){
                long val;
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                val = query(l , r ,seg_tree,N);
                sb.append(val+"\n");
            }

        }
        bw.write(sb.toString());
        bw.flush();
    }
    static void make_segment_tree(long[] arr,long[] seg_tree,int N){
        for(int i = 0 ; i < N ; i++)
            seg_tree[i+N] = arr[i];

        // 그리고 올라가면서 부모 갱신
        // 왼 오른 곱
        for(int i = N-1 ; i > 0 ; i--)
            seg_tree[i] = ( seg_tree[i<<1] * seg_tree[i<<1|1] ) % 1_000_000_007;
    }

    static void update(int idx,long value,long[] seg_tree, int N){
       int i = idx-1;
        // 일단 idx값 바꿔주고
       seg_tree[i+=N] = value;

       // 부모 올라가면서 갱신해주고
        while ( (i>>=1) > 0){
            seg_tree[i] = ( seg_tree[i<<1] * seg_tree[i<<1|1] ) % 1_000_000_007;
        }
    }

    static long query(int left , int right ,long[] seg_tree, int N){
        int l = left-1;
        int r = right;

        long result = 1;
        // 자식부터 시작해서 올라가야댐
        for(l+= N , r+=N ; l != r ; l>>=1 , r>>=1){
            if( (l & 1) > 0)  result = (result * seg_tree[l++])%1_000_000_007;
            if( (r & 1) > 0) result = (result*seg_tree[--r] )%1_000_000_007;
        }
        return result;
    }
}
