package Bronze;

import java.io.*;

public class B1_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[1000];
        int cur = 1;
        int cnt = 1;
        for(int i = 0 ; i < 1000 ; i++){
            arr[i] = cur;
            cnt++;
            if(cur < cnt){
                cnt = 1;
                cur++;
            }
        }
        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0])-1;
        int e = Integer.parseInt(input[1])-1;
        int sum = 0;
        for(int i = s ; i <=e ; i++)
            sum += arr[i];
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
