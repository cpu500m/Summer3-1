/* 2022-06-29 */
package Silver;

import java.io.*;
import java.util.Arrays;

public class S5_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i =0; i < n ; i++)
            arr[i]=Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        for(int i =0;i<n; i++)
            sb.append(arr[i]+"\n");
        bw.write(sb.toString());
        bw.flush();
    }
}
