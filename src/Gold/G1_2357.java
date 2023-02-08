package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G1_2357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] max_tree = new int[2 * n];
        int[] min_tree = new int[2 * n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        make_max_segment_tree(arr, max_tree, n);
        make_min_segment_tree(arr, min_tree, n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int max = max_query(left-1, right, max_tree, n);
            int min = min_query(left-1, right, min_tree, n);
            sb.append(min + " " + max + " " + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static void make_max_segment_tree(int[] arr, int[] seg_tree, int n) {
        for (int i = 0; i < n; i++)
            seg_tree[i + n] = arr[i];

        // 왼자식 오른자식 더하고
        for (int i = n - 1; i > 0; i--)
            seg_tree[i] = Math.max(seg_tree[i << 1], seg_tree[i << 1 | 1]);
    }

    static void make_min_segment_tree(int[] arr, int[] seg_tree, int n) {
        for (int i = 0; i < n; i++)
            seg_tree[i + n] = arr[i];

        // 왼자식 오른자식 더하고
        for (int i = n - 1; i > 0; i--)
            seg_tree[i] = Math.min(seg_tree[i << 1], seg_tree[i << 1 | 1]);
    }

    static void max_update(int idx, int val, int[] seg_tree, int n) {

        seg_tree[idx += n] = val;

        // 부모를 차례차례 올라가며 갱신.
        while ((idx >>= 1) > 0) {
            seg_tree[idx] = Math.max(seg_tree[idx << 1], seg_tree[idx << 1 | 1]);
        }
    }

    static void min_update(int idx, int val, int[] seg_tree, int n) {

        seg_tree[idx += n] = val;

        // 부모를 차례차례 올라가며 갱신.
        while ((idx >>= 1) > 0) {
            seg_tree[idx] = Math.min(seg_tree[idx << 1], seg_tree[idx << 1 | 1]);
        }
    }


    static int max_query(int left, int right, int[] seg_tree, int n) {
        int result = Integer.MIN_VALUE;

        // 말단 노드부터 부모노드로 올라가면서 값을 더해준다.
        for (left += n, right += n; left != right; left >>= 1, right >>= 1) {
            // left의 경우 폐구간이므로 홀수 인덱스이면 현재 값과 비교
            if ((left & 1) != 0) result = Math.max(seg_tree[left++], result);
            // right의 경우 열린구간이므로 홀수 인덱스이면 왼쪽 노드 값과 비교
            if ((right & 1) != 0) result = Math.max(seg_tree[--right], result);
        }
        return result;
    }

    static int min_query(int left, int right, int[] seg_tree, int n) {
        int result = Integer.MAX_VALUE;

        // 말단 노드부터 부모노드로 올라가면서 값을 더해준다.
        for (left += n, right += n; left != right; left >>= 1, right >>= 1) {
            // left의 경우 폐구간이므로 홀수 인덱스이면 현재 값과 비교
            if ((left & 1) != 0) result = Math.min(seg_tree[left++], result);
            // right의 경우 열린구간이므로 홀수 인덱스이면 왼쪽 노드 값과 비교
            if ((right & 1) != 0) result = Math.min(seg_tree[--right], result);
        }
        return result;
    }
}
