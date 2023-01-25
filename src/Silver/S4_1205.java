package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S4_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        if(N ==0){
            bw.write("1");
            bw.flush();
            return;
        }
        Integer[] arr = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr, Collections.reverseOrder());

        int rank = -1;
        int second = 0;
        for(int i = 0 ; i < N ; i++){
            if(arr[i] <= M){
                rank = i+1;
                int j = i;
                while (j < N){
                    if(arr[j++] == M)
                        second++;
                    else break;
                }
                break;
            }
        }
        if(rank == -1)
            rank = N+1;
        if(rank + second > P)
            rank = -1;
        bw.write(String.valueOf(rank));
        bw.flush();
    }
}
