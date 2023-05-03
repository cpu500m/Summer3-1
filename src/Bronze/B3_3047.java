package Bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3_3047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[3];
        for(int i = 0 ; i < 3;  i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        String str = br.readLine();
        for(int i = 0 ; i <3 ; i++)
            sb.append(arr[str.charAt(i)-'A']+" ");
        bw.write(sb.toString());
        bw.flush();
    }
}
