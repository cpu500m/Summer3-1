/* 2022-06-27 */
package Bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[size];
        for(int i = 0 ; i <arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        bw.write(arr[0]+" "+arr[size-1]);
        bw.flush();
    }
}
