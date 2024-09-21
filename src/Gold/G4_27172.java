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
 * @fileName : G4_27172
 * @date : 2024-09-21
 */
public class G4_27172 {

    private static final int MAX = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cards = new int[n];
        boolean[] existed = new boolean[MAX];

        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            existed[cards[i]] = true;
        }

        int[] countArray = applyEratosthenes(cards,existed);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(countArray[cards[i]]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static int[] applyEratosthenes(int[] cards,boolean[] existed) {
        int[] countArray = new int[MAX];

        for (int i = 0; i < cards.length; i++) {
            for (int j = 2 * cards[i]; j < MAX; j += cards[i]) {
                if (!existed[j]) {
                    continue;
                }
                countArray[cards[i]]++;
                countArray[j]--;
            }
        }
        return countArray;
    }
}