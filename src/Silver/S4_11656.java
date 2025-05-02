package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/**
 * @author : paulkim
 * @description :
 * @packageName : Silver
 * @fileName : S4_11656
 * @date : 25. 5. 2.
 */
public class S4_11656 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < str.length(); i++) {
            pq.add(str.substring(i, str.length()));
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            sb.append(pq.poll()+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
