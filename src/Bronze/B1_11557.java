package Bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1_11557 {
    static class Info implements Comparable<Info>{
        String name;
        int val;

        public Info(String name, int val) {
            this.name = name;
            this.val = val;
        }

        @Override
        public int compareTo(Info o) {
            return o.val - this.val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 0; tc < TC; tc++) {
            int n = Integer.parseInt(br.readLine());
            Info[] infos = new Info[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                infos[i] = new Info(st.nextToken(), Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(infos);
            sb.append(infos[0].name + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
