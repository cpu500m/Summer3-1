package Bronze;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[count];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        bw.write(String.valueOf(arr[0]*arr[arr.length-1]));
        bw.flush();
    }
}
