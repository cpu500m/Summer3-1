package Bronze;

import java.io.*;

public class B2_1668 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int cnt = 0 , cur_val = 0;
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0 ; i <N; i++){
            if(cur_val < arr[i]){
                cur_val = arr[i];
                cnt++;
            }
        }
        sb.append(cnt+"\n");
        cnt = 0;
        cur_val = 0;
        for(int i = N-1; i>= 0 ; i--){
            if(cur_val < arr[i]){
                cur_val = arr[i];
                cnt++;
            }
        }
        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();
    }
}
