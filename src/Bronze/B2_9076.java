package Bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2_9076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb =new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[5];
            for(int j = 0 ; j <5 ; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            if(arr[3] - arr[1] >= 4)
                sb.append("KIN\n");
            else
                sb.append(arr[1]+arr[2]+arr[3]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
