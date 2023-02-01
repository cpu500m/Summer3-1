// P5_1517 과 문제만 다르지 완벽히 같은 코드
package Platinum;

import java.io.*;
import java.util.StringTokenizer;

public class P5_10090 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long result;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        result = merge_sort(arr, 0, N);
        bw.write(String.valueOf(result));
        bw.flush();
    }

    static long merge_sort(int[] arr, int start, int end) {
        if (end - start == 1) return 0;

        int size = end - start;
        int mid = (start + end) / 2;
        long result = 0;

        result += merge_sort(arr, start, mid);
        result += merge_sort(arr, mid, end);

        int[] temp = new int[size];
        int i = start, j = mid, k = 0;
        while (i < mid && j < end) {
            if (arr[i] > arr[j])
                result += (mid - i);
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i < mid)
            temp[k++] = arr[i++];
        while (j < end)
            temp[k++] = arr[j++];
        for (i = start; i < end; i++)
            arr[i] = temp[i - start];
        return result;
    }
}
