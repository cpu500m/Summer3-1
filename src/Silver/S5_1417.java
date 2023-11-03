package Silver;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class S5_1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int score = Integer.parseInt(br.readLine());
        int result = 0;
        Queue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

        initQueue(br, n, pQueue);

        result = logic(score, result, pQueue);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static int logic(int score, int result, Queue<Integer> pQueue) {
        if(pQueue.isEmpty()) return 0;
        while (pQueue.peek() >= score) {
            score++;
            result++;
            Integer cur = pQueue.poll();
            pQueue.add(--cur);
        }
        return result;
    }

    private static void initQueue(BufferedReader br, int n, Queue<Integer> pQueue) throws IOException {
        for (int i = 1; i < n; i++) {
            pQueue.add(Integer.parseInt(br.readLine()));
        }
    }
}
