package Bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1_2693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        for(int tc = 1 ; tc <= TC ; ++tc){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 10; i++) {
                arr[i-1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            sb.append(arr[7]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
