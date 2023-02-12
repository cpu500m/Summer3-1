package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G1_18346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int[] even_tree = new int[2 * n];
        int[] odd_tree = new int[2 * n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        // 세그먼트 트리 생성
        make_even_segment_tree(arr, even_tree, n);
        make_odd_segment_tree(arr, odd_tree, n);


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int act = Integer.parseInt(st.nextToken());
            if( act == 1){
                // 1부터니깐 1 빼준거고
                int idx = Integer.parseInt(st.nextToken())-1;
                int val =  Integer.parseInt(st.nextToken());
                even_update(idx,val,even_tree , n);
                odd_update(idx,val,odd_tree , n);
            }
            else if( act == 2){
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                // 폐구간 ~ 개구간 이므로 좌측 구간은 -1 해준거고
                int val =  even_query(left-1, right, even_tree, n);
                sb.append(val+"\n");
            }
            else if(act == 3){
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                // 얘도 똑같고
                int val =  odd_query(left-1, right, odd_tree, n);
                sb.append(val+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static void make_even_segment_tree(int[] arr, int[] seg_tree, int n) {
        // 리프 노드 생성하는데 짝수면 1 , 홀수면 0
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 1)
                seg_tree[i + n] = 1;
            else seg_tree[i+n] = 0;
        }

        // 부모는 자식 두명 더한 값이고
        for (int i = n - 1; i > 0; i--)
            seg_tree[i] = seg_tree[i << 1] +seg_tree[i << 1 | 1];
    }

    static void make_odd_segment_tree(int[] arr, int[] seg_tree, int n) {
        // 리프 노드 생성하는데 홀수면 1 짝수면 0이고
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 1)
                seg_tree[i + n] = 1;
            else seg_tree[i+n] = 0;
        }

        // 부모는 자식 두명 더한 값이고
        for (int i = n - 1; i > 0; i--)
            seg_tree[i] =  seg_tree[i << 1] + seg_tree[i << 1 | 1];
    }

    static void even_update(int idx, int val, int[] seg_tree, int n) {

        // val 값이 짝수면 리프 노드 값이 1이고 홀수면 0 이고
        if(val %2 == 0)
            seg_tree[idx += n] = 1;
        else seg_tree[idx += n] = 0;

        // 부모를 차례차례 올라가며 갱신.
        while ((idx >>= 1) > 0) {
            seg_tree[idx] = seg_tree[idx << 1] + seg_tree[idx << 1 | 1];
        }
    }

    static void odd_update(int idx, int val, int[] seg_tree, int n) {

        // val 값이 홀수면 리프 노드 값이 1이고 짝수면 0이고
        if(val %2 == 1)
            seg_tree[idx += n] = 1;
        else seg_tree[idx += n] = 0;

        // 부모를 차례차례 올라가며 갱신.
        while ((idx >>= 1) > 0) {
            seg_tree[idx] = seg_tree[idx << 1] + seg_tree[idx << 1 | 1];
        }
    }


    static int even_query(int left, int right, int[] seg_tree, int n) {
        int result = 0;

        // 루트 까지 올라가고
        // 리프부터 왼 , 오른 더해가는 식이고
        for (left += n, right += n; left != right; left >>= 1, right >>= 1) {
            if ((left & 1) != 0) result += seg_tree[left++];
            if ((right & 1) != 0) result += seg_tree[--right];
        }
        return result;
    }

    static int odd_query(int left, int right, int[] seg_tree, int n) {
        int result = 0;

        // 얘도 마찬가지고 사실 쿼리 메서드를 나눌 필요는 없었는데 아무튼
        for (left += n, right += n; left != right; left >>= 1, right >>= 1) {
            if ((left & 1) != 0) result += seg_tree[left++];
            if ((right & 1) != 0) result += seg_tree[--right];
        }
        return result;
    }
}
