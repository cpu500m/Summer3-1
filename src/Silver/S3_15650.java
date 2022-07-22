package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S3_15650 {
    private static int[] arr;
    private static int M;
    private static int N;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M+1];
        sequence(0);
        bw.write(sb.toString());
        bw.flush();
    }
    static void sequence(int i){
        if(promising(i)){
            if( i == M) {
                for(int a = 1; a <= M; a++)
                    sb.append(arr[a]+" ");
                sb.append("\n");
            }
            else{
                for(int j = 1; j<= N;  j++) {
                    arr[i + 1] = j;
                    sequence(i+1);
                }
            }
        }
    }
    static boolean promising(int i){
        int k=1;
        boolean flag= true;
        while(k < i && flag){
            if(arr[i] == arr[k] || arr[i] < arr[k])
                flag = false;
            k++;
        }
        return flag;
    }
}
