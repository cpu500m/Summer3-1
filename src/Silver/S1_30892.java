// 1번 : 리스트 + 이분탐색 ( 시간이 조금 걸리지만 list를 사용하므로 메모리 절약)
// 2번 : 스택에 쌓으면서 그리디하게. ( 시간을 줄이지만 arr에 정보를 저장해놔야하므로 메모리 더 써야됨)
package Silver;

import java.io.*;
import java.util.*;

public class S1_30892 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        for (int i = 0; i < k; i++) {
            // 스택에 넣어
            while (idx < n && arr[idx] < t){
                stack.add(arr[idx++]);
            }
            // 비어있으면 더먹을거없다
            if(stack.isEmpty()) break;
            // 가장 큰거먹어
            t += stack.pop();
        }

        bw.write(String.valueOf(t));
        bw.flush();
    }
   /* public static void main(String[] args) throws IOException {
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
    }*/
}
