package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_30033 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] plan = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }


        int res = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if(Integer.parseInt(st.nextToken()) >= plan[i]) res++;
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
