// 목표 시간복잡도 O(N*log n ) 이하
// 메모리 128MB
package Gold;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_2493 {

    static class Top{
        int idx;
        int height;

        public Top(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        // 높이 기준 오름차순
        Queue<Top> queue = constructQueue();

        // 각 탑의 신호와 매칭되는 탑.
        int[] matchedTop = new int[n];

        int[] height = initHeight(br, n);

        logic(n, queue, matchedTop, height);

        printResult(bw, n, matchedTop);
    }

    private static Queue<Top> constructQueue() {
        Queue<Top> queue = new PriorityQueue<>(new Comparator<Top>() {
            @Override
            public int compare(Top o1, Top o2) {
                // 만약 두 탑의 높이가 같다면 오른쪽이 우선권.
                if (o1.height == o2.height)
                    return o2.idx - o1.idx;
                return o1.height - o2.height;
            }
        });
        return queue;
    }

    private static int[] initHeight(BufferedReader br, int n) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        return height;
    }

    private static void logic(int n, Queue<Top> queue, int[] matchedTop, int[] height) {
        for (int i = 0; i < n; i++) {
            int cur = height[n -1-i];
            // 큐가 비어있지 않다면 큐의 최상단과 비교.
            while (!queue.isEmpty()) {
                // 큐의 최상단 값이 더 크거나 같다면 while 문 중단
                if (queue.peek().height >= cur) break;

                // 그렇지않다면 큐의 최상단 값을 꺼내고 matchedTop배열 해당 idx값 갱신
                Top val = queue.poll();
                matchedTop[val.idx-1] = n -i;
            }
            // 큐에 정보 추가
            queue.add(new Top(n -i, cur));
        }
    }

    private static void printResult(BufferedWriter bw, int n, int[] matchedTop) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(matchedTop[i]+" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
