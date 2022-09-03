package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S2_2805 {
    private static int[] tree;
    private static long max_height;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        tree = new int[N];
        max_height = Integer.MIN_VALUE;
        int max_val = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++) {
            tree[i]= Integer.parseInt(st.nextToken());
            if(max_val < tree[i])
                max_val = tree[i];
        }
        binary_search(M, 0 , max_val);
        bw.write(String.valueOf(max_height));
        bw.flush();
    }
    private static void binary_search(int object, long start , long end){
        if( start > end)
            return ;
        long mid = (start+end)/2;
        long height = 0;
        for(int i = 0; i < N ; i++){
            height += (tree[i] - mid >= 0 ? tree[i] -mid : 0);
        }
        if(height >= object ) {
            if(max_height < mid)
                max_height = mid;
            binary_search(object, mid + 1, end);
        }
        else if(height < object)
            binary_search(object, start, mid-1);
    }
}
