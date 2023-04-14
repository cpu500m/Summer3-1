// 수정
package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        sb.append(arr[0]+" ");
        for(int i = 1 ; i < n ; i++){
            if(arr[i] != arr[i-1])
                sb.append(arr[i]+" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
