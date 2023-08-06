package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_1813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[51];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }
        int i;
        for (i = n; i >= 0 ; i--) {
            if(arr[i] == i){
                bw.write(String.valueOf(i));
                break;
            }
        }
        if(i < 0)
            bw.write("-1");
        bw.flush();
    }
}
