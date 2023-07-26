package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int L = Integer.parseInt(br.readLine());
        int[] arr = new int[L+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = 0;
        for (int i = 1; i < L+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int n = Integer.parseInt(br.readLine());

        // 이분 탐색 구간 : [ , )
        int low = find_low(0,L+1,n, arr);
        int high = find_high(0,L+1,n,arr);

        // 답
        int res = 0;
        for (int i = low+1; i <high; i++) {
            if(i > n) break;

            if(i < n)
            res += ((high-1 - i) - (n-i-1));
            else res +=( high-1 - i );
        }
        bw.write(String.valueOf(res));
        bw.flush();
        // 진짜 개떡같이도 짰네 로직
    }

    private static int find_low(int left, int right ,int target, int[] arr) {
        while (left < right-1) {
            int mid = left + (right - left) / 2;
            if(arr[mid] >= target)
                right = mid;
            else left = mid;
        }
        return arr[left];
    }
    private static int find_high(int left, int right ,int target, int[] arr) {
        while (left < right-1) {
            int mid = left + (right - left) / 2;
            if(arr[mid] >= target)
                right = mid;
            else left = mid;
        }
        return arr[right];
    }
}
