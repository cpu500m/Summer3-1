// TODO 내일 다시해 너무 대충 햇다
package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S3_2346 {

    static class Balloon{
        int idx;
        int next;
        boolean check;

        Balloon(int idx ,int next) {
            this.idx = idx;
            this.next = next;
            check = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Balloon[] balloons = new Balloon[n];
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            balloons[i] = new Balloon(i+1,Integer.parseInt(st.nextToken()));
        }

        int cur = 0;
        int cnt = 0;
        int val;
        while (true) {
            sb.append((balloons[cur].idx)+" ");
            balloons[cur].check = true;
            cnt++;
            if(cnt == n) break;

            if(balloons[cur].next > 0) val = 1;
            else val = -1;

            cur += balloons[cur].next;


            if(cur < 0)
                cur += n;

            else if(cur >= n)
                cur %= n;

            while (balloons[cur].check){
                cur = (cur+val) % n;
                if(cur < 0) cur+=n;
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
