package Silver;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S4_2776 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if(set.contains(Integer.parseInt(st.nextToken())))
                    sb.append("1\n");
                else sb.append("0\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
