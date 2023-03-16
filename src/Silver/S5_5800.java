package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int K =Integer.parseInt(br.readLine());
        for(int i =0 ; i < K ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for(int j = 0 ; j <N ; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int gap = 0;
            for(int j = 0 ; j < N-1 ; j++){
                if( arr[j+1]-arr[j] > gap)
                    gap = arr[j+1] - arr[j];
            }
            sb.append("Class "+(i+1)+"\n");
            sb.append("Max "+arr[N-1]+", Min "+arr[0]+", Largest gap "+ gap+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
