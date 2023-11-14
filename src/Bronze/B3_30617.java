package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_30617 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int left = -2;
        int right = -2;
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if(left == l && left !=0) result++;
            if(right == r && right !=0) result++;
            left = l;
            right = r;
            if(left !=0 && left == right) result++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
