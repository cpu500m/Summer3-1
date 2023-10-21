package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S3_2346 {

    static class Balloon {
        int idx;
        int next;

        Balloon(int idx, int next) {
            this.idx = idx;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Balloon> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Balloon(i+1,Integer.parseInt(st.nextToken())));
        }

        int cur = 0;
        while (!list.isEmpty()) {
            Balloon b = list.remove(cur);
            sb.append(b.idx+" ");

            if(b.next > 0) cur -=1;

            if(n == 1) break;
            cur = (cur+b.next) % --n;
            if(cur < 0) cur+=n;
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
