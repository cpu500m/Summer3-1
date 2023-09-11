package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_29736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int result = 0;
        int s = k - x;
        int e = k+ x;
        for (int i = s; i <= e; i++) {
            if(a<= i && i <= b)
                result++;
        }
        if(result == 0)
            bw.write("IMPOSSIBLE");
        else
            bw.write(String.valueOf(result));
        bw.flush();
    }
}
