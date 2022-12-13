package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S4_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a, Collections.reverseOrder());
        Arrays.sort(b);
        for(int i = 0 ; i < n ; i++){
            sum+= a[i]*b[i];
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
