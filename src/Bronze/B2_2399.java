package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_2399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        int[] arr = new int[N];
        st= new StringTokenizer(br.readLine());
        for(int i =0; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i <N ;i++){
            for(int j = 0; j <N;j++){
                sum += Math.abs(arr[j]-arr[i]);
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
