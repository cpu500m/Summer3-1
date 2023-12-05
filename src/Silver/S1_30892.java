package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S1_30892 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());

        // list 생성 및 오름차순 정렬
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        // 이분 탐색
        for (int i = 0; i < k; i++) {
            int idx = find(list, t)-1;
            // 더이상 잡아먹을 것이 없는 경우
            if(idx == -1) break;

            t += list.remove(idx);
        }
        bw.write(String.valueOf(t));
        bw.flush();
    }

    private static int find(List<Integer> list, long size) {
        int s = 0;
        int e = list.size();
        while (s != e) {
            int m = s + (e-s)/2;
            if(list.get(m) < size) s = m+1;
            else e = m;
        }
        return s;
    }
}
