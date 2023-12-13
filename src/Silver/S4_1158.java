package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S4_1158 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =  new StringBuilder("<");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            list.add(i);
        }
        int idx = 0;
        while (!list.isEmpty()) {
            idx = (idx + (k-1)) % list.size();
            sb.append(list.remove(idx));
            if(list.size() != 0) {
                sb.append(", ");
            }
        }
        sb.append(">");
        bw.write(sb.toString());
        bw.flush();
    }
}
