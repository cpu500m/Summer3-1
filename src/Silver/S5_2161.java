package Silver;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class S5_2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        init(n, deque);

        for (int i = 0; i < n; i++) {
            bw.write(deque.poll()+" ");
            deque.addLast(deque.poll());
        }

        bw.flush();
    }

    private static void init(int n, Deque<Integer> deque) {
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }
    }
}
