package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G5_21758
 * @date : 2024-09-07
 */
public class G5_21758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* 입력 처리 */
        int n = Integer.parseInt(br.readLine());

        int[] honey = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
        }

        int firstCase = layHoneycombAtLeft(0, n - 1, honey);
        int secondCase = layHoneycombAtRight(0, n - 1, honey);
        int thirdCase = layHoneycombBetweenBees(0, n - 1, honey);
        int result = Math.max(thirdCase, Math.max(firstCase, secondCase));
        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static int layHoneycombAtLeft(int left, int right, int[] honey) {
        int honeyComb = left;
        int beeIndex = right - 1;
        int[] cumulativeSum = new int[honey.length];
        cumulativeSum[right - 1] = 0;
        int sum = 0;
        for (int i = right - 2; i > honeyComb; i--) {
            sum += (honey[i + 1] - honey[i] * 2);
            cumulativeSum[i] = sum;
        }

        int max = -1;
        for (int i = right - 1; i > honeyComb; i--) {
            if (max < cumulativeSum[i]) {
                max = cumulativeSum[i];
                beeIndex = i;
            }
        }

        int result = 0;
        for (int i = right - 1; i >= honeyComb; i--) {
            if (i == beeIndex) {
                continue;
            }
            if (i < beeIndex) {
                result += honey[i] * 2;
            } else {
                result += honey[i];
            }
        }
        return result;
    }

    private static int layHoneycombAtRight(int left, int right, int[] honey) {
        int honeyComb = right;
        int beeIndex = left + 1;

        int[] cumulativeSum = new int[honey.length];
        cumulativeSum[left + 1] = 0;
        int sum = 0;
        for (int i = left + 2; i <honeyComb; i++) {
            sum += (honey[i - 1] - honey[i] * 2);
            cumulativeSum[i] = sum;
        }

        int max = -1;
        for (int i = left +1; i < honeyComb; i++) {
            if (max < cumulativeSum[i]) {
                max = cumulativeSum[i];
                beeIndex = i;
            }
        }

        int result = 0;
        for (int i = left + 1; i <= honeyComb; i++) {
            if (i == beeIndex) {
                continue;
            }
            if (i > beeIndex) {
                result += honey[i] * 2;
            } else {
                result += honey[i];
            }
        }
        return result;
    }

    private static int layHoneycombBetweenBees(int left, int right, int[] honey) {
        int honeyCombIndex = 0;
        int max = -1;
        for (int i = 1; i < right; i++) {
            if (honey[i] > max) {
                max = honey[i];
                honeyCombIndex = i;
            }
        }

        int sum = 0;
        for (int i = left + 1; i <= honeyCombIndex; i++) {
            sum += honey[i];
        }
        for (int i = right - 1; i >= honeyCombIndex; i--) {
            sum += honey[i];
        }
        return sum;
    }
}
