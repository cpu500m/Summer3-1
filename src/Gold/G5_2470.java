package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G5_2470
 * @date : 2025-04-14
 */
public class G5_2470 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int minAbsoluteValue = Integer.MAX_VALUE;
        int p1 =0, p2=0;
        while (left >= 0 && right < arr.length && left < right) {
            int sum = arr[left] + arr[right];
            if(Math.abs(sum) < minAbsoluteValue) {
                minAbsoluteValue = Math.abs(sum);
                p1 = arr[left];
                p2 = arr[right];
            }
            if(sum > 0) right--;
            else left++;
        }

        bw.write(p1 + " " + p2);
        bw.flush();
    }
}
