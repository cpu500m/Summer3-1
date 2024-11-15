package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Silver
 * @fileName : S2_16953
 * @date : 2024-11-15
 */
public class S2_16953 {
    private static class Info{
        int count;
        long number;
        Info(int count, long number){
            this.count = count;
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Queue<Info> q = new LinkedList<>();

        q.add(new Info(1, A));
        int result = -1;
        while(!q.isEmpty()){
            Info cur = q.poll();
            if(cur.number >= B){
                if(cur.number == B){
                    result = cur.count;
                    break;
                }
                continue;
            }

            q.add(new Info(cur.count +1, cur.number*2));
            String str = String.valueOf(cur.number);
            String appendStr = str + "1";

            q.add(new Info(cur.count+1, Long.parseLong(appendStr)));
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
