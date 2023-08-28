package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S5_28464 {

    private final static int PARK = 0;
    private final static int SEONGWOO = 1;
    private final static int PERSON_COUNT = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dishes = new int[n];
        int[] cnt = new int[PERSON_COUNT];
        for (int i = 0; i < n; i++) {
            dishes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dishes);

        Deque<Integer> deque = initDeque(dishes);

        logic(deque, cnt);

        bw.write(String.valueOf(cnt[SEONGWOO]) + " " + String.valueOf(cnt[PARK]));
        bw.flush();
    }

    private static void logic(Deque<Integer> deque, int[] cnt) {
        int turn = 0;
        while (!deque.isEmpty()) {
            if (turn == PARK)
                cnt[turn++] += deque.pollLast();
            else cnt[turn++] += deque.pollFirst();
            turn %= PERSON_COUNT;
        }
    }

    private static Deque<Integer> initDeque(int[] dishes) {
        Deque<Integer> deque = new LinkedList<>();
        Arrays.stream(dishes).forEach(dish -> deque.add(dish));
        return deque;
    }
}
