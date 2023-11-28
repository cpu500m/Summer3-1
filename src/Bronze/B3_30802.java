package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_30802 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        int shirt = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int t,p;
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        for (int i = 0; i < arr.length; i++) {
            shirt += ((arr[i]/t)+1);
            if(arr[i] % t == 0) shirt--;
        }
        bw.write(shirt+"\n");
        bw.write(n/p +" "+n%p);
        bw.flush();
    }
}
