package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S2_1654 {
    private static int[] lan;
    private static long possible_val;
    private static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        lan = new int[K];
        possible_val = Integer.MIN_VALUE;
        int max_val = Integer.MIN_VALUE;
        for(int i = 0; i < K ; i++) {
            lan[i]= Integer.parseInt(br.readLine());
            if(max_val < lan[i])
                max_val = lan[i];
        }
        binary_search(N, 1 , max_val);
        bw.write(String.valueOf(possible_val));
        bw.flush();
    }
    private static void binary_search(int object, long start , long end){
        if( start > end)
            return ;
        long mid = (start+end)/2;
        int cnt = 0;
        int mul;
        for(int i = 0; i < K ; i++){
            mul = 1;
            while(lan[i] >= mul*mid){
                mul++;
                cnt++;
            }
        }
        if(object <= cnt ) {
            if(possible_val < mid)
                possible_val = mid;
            binary_search(object, mid + 1, end);
        }
        else if(object > cnt)
            binary_search(object, start, mid-1);
    }
}
